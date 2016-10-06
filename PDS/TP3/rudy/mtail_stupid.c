#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <getopt.h>
#include <stdlib.h>
#include <unistd.h>
#include <limits.h>

#define BUF 1 << 8

extern char *optarg;
extern int optind, opterr, optopt;


int main(int argc, char  *argv[]) {
	char buff_read[BUF];
	int s_read;
	int cptl;
	int cptl2;
	int o;
	int i;
	int nb_line;
	int fd_filename;
	/*const char *optarg = "n:";*/

	while((o = getopt(argc, argv, "n:")) != -1){
		switch ((char) o) {
			case 'n':
				nb_line = atoi(optarg);
				break;
		}
	}





/*1er lect compte*/
	if((fd_filename = open(argv[optind], O_RDONLY)) == -1){
		perror("open");
		exit(EXIT_FAILURE);
	}
	while ((s_read = read(fd_filename, buff_read, BUF)) != 0)
	{
		for (i = 0; i < s_read; i++)
			if ('\n' == buff_read[i])
				cptl++;
	}
	if(s_read == -1)
	{
		perror("read");
		exit(EXIT_FAILURE);
	}
	close(fd_filename);














	/*2nd lect affichage*/
	if((fd_filename = open(argv[optind], O_RDONLY)) == -1){
		perror("open");
		exit(EXIT_FAILURE);
	}
	while ((s_read = read(fd_filename, buff_read, BUF)) != 0)
	{
		for (i = 0; i < s_read; i++)
		{
			if ('\n' == buff_read[i])
			cptl2++;
			if (cptl2 >= cptl - nb_line)
			{
				printf("%c", buff_read[i]);
			}
		}

	}
	if(s_read == -1)
	{
		perror("read");
		exit(EXIT_FAILURE);
	}
	close(fd_filename);

	return EXIT_SUCCESS;
}
