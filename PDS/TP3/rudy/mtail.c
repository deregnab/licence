#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>

#define BUF_SIZE 1 << 8
extern char *optarg;


void foo(int fd, int nb_line)
{
  char buf[BUF_SIZE];
  ssize_t sread;
  int cpt;

  if((sread = read(fd, buf, BUF_SIZE)) == -1)
  {
    perror("read");
    exit(EXIT_FAILURE);
  }
  for(cpt = sread; cpt > 0 && nb_line == 0; cpt--)
  {
    if(buf[cpt] == '\n')
    {
      nb_line--;
    }
  }

  if(nb_line == 0)
  {
    printf("%s\n", buf);
    return;
  }
  foo(fd, nb_line);
}


int main(int argc, char *argv[])
{
  int nb_line;
  int o;
  off_t cur;
  off_t total;
  int fd_filename;

  while((o = getopt(argc, argv, "n:")) != -1)
  {
    switch ((char) o)
    {
      case 'n':
        nb_line = atoi(optarg) /*+ 1*/;
      break;
    }
  }

  if((fd_filename = open(argv[optind], O_RDONLY)) == -1)
  {
    perror("open");
    exit(EXIT_FAILURE);
  }

  if((cur = total = lseek(fd_filename, 0, SEEK_END)) == -1)
  {
    perror("lseek");
    exit(EXIT_FAILURE);
  }

  foo(fd_filename,nb_line);
/*while(cur = lseek(fd_filename, -BUF_SIZE, SEEK_CUR) >= 0 && nb_line == 0)
{
  if((sread = read(fd_filename, buf, BUF_SIZE)) == -1)
  {
    perror("read");
    exit(EXIT_FAILURE);
  }
  for(cpt = sread; cpt > 0 && nb_line == 0; cpt--)
  {
    if(buf[cpt] == '\n')
    {
      nb_line--;
      if(nb_line == 0)
      {
        cur += BUF_SIZE - cpt;
      }
    }
  }

}


if(cur == -1)
{
perror("lseek");
exit(EXIT_FAILURE);
}*/


  close(fd_filename);
  return EXIT_SUCCESS;
}
