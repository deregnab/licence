#include <assert.h>
#include <ctype.h>
#include <dirent.h>
#include <getopt.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

static int taille =0;
static int lflag = 0;
static int bflag =0;

static void usage(void)
{
	(void)fprintf(stderr,"usage: mdu [-L | -b | -v] file\n");
	exit(EXIT_FAILURE);
}

int path_valid(struct dirent *subdir)
{
  return strcmp(subdir->d_name, ".") && strcmp(subdir->d_name,"..");
}

int du_file(const char *pathname)
{
  struct stat st;
  int status = lstat(pathname,&st);
  assert(status != -1);
  taille += bflag ? st.st_size : st.st_blocks;

  if (S_ISDIR(st.st_mode))
  {
    DIR *dir;
    struct dirent *subdir;
    char sub_path[PATH_MAX];
    dir = opendir(pathname);
    while ((subdir = readdir(dir))!=NULL)
    {
      if(path_valid(subdir))
      {
        snprintf(sub_path,PATH_MAX,"%s/%s",pathname,subdir->d_name);
        taille += du_file(sub_path);
      }
    }
    closedir(dir);
    printf("%d\t%s\n", taille, pathname);
  }
  return taille;
}

int main(int argc, char *argv[])
{
    int vflag = 0;
    int index;
    int c;
    char * path = NULL;

    while ((c = getopt(argc, argv, "Lbv")) != -1)
      switch (c) {
      case 'L':
        lflag = 1;
        break;
      case 'b':
        bflag = 1;
        break;
      case 'v':
        vflag = 1;
        break;
      case '?':
        if (isprint(optopt)){
            fprintf(stderr, "Unknown option `-%c'.\n", optopt);
            usage();
        }
        else {
            fprintf(stderr,
              "Unknown option character `\\x%x'.\n", optopt);
              usage();
        }
      default:
        abort();
      }

    if (vflag)
      printf("lflag = %d, bflag = %d, vflag = %d\n", lflag, bflag, vflag); /*debug*/

    for (index = optind; index < argc; index++) {
      /*printf ("Non-option argument %s\n", argv[index]);*/
      path = argv[index];
    }

    if (path == NULL) {
      fprintf(stderr, "path file missing.\n");
      usage();
    }

    du_file(path);

    return 0;
}
