#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <assert.h>


int main(int argc, char *argv[])
{
  int nbl;
  int buf_size;
  char *buff;
  int fd;

  assert(argc >= 1 && argv[1] != NULL);

  buf_size = atoi(getenv("MCAT_BUFSIZ"));
  buff = malloc(buf_size);

  fd = open(argv[1], O_RDONLY);
  assert(fd > 0);

  while ((nbl = read(fd, buff, buf_size)) > 0)
  {
      if(write(STDOUT_FILENO, buff, nbl) < 0)
      {
        perror("write");
        exit(EXIT_FAILURE);
      }
  }

  close(fd);
  free(buff);
  return EXIT_SUCCESS;
}
