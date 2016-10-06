#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <getopt.h>
#include <stdlib.h>
#include <unistd.h>
#include <limits.h>
#define BUF 1 << 8
int tail(char* pathname,int n){
    int fichier;
    int cpt=0;
    int cpt2=0;
    char buffer[BUF];
    int i;
    int nread;
    fichier=open(pathname,'r');
    if(!fichier){
        perror("le fichier ne peut etre ouvert");
        exit(EXIT_FAILURE);
    }
    while((nread=read(fichier,buffer,BUF)) != 0){
        printf("haha");
            for(i=0;i<nread;i++)        
            if(buffer[i]=='\n'){
                cpt++;
            }
    }
    if(nread ==-1){
        perror("le fichier ne peut etre lu");
        exit(EXIT_FAILURE);
    }
    printf("%d",cpt);


    if((fichier=open(pathname,'r'))==-1){
        perror("le fichier ne peut etre ouvert 2");
        exit(EXIT_FAILURE);
    }
    while((nread=read(fichier,buffer,BUF)) !=0){
        printf("allo");
        
        for(i=0;i<nread;i++){
            if(buffer[i] =='\n'){
                cpt2++;
            }
            if(cpt2>=cpt-n){
                printf("%c",buffer[i]);
            }
            if(nread == -1)
            {
                perror("Le fichier ne peut etre lu 2");
                exit(EXIT_FAILURE);
            }
            close(fichier);


        }

    }
    return EXIT_SUCCESS;
}
int main(int argc,char **argv){
    int nb_line=10;
    int o;
    while((o = getopt(argc, argv, "n:")) != -1){
        switch ((char) o) {
            case 'n':
                nb_line = atoi(optarg);
                break;
        }
    }

    tail(argv[1],nb_line);
    return 0;
}
