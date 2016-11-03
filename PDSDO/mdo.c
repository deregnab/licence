#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <getopt.h>
#include "makeargv.h"

int OR_OPERATOR = 0;
int AND_OPERATOR = 0;
int KILL_OPERATOR = 0;
int CC_OPERATOR = 0;
int OPERATOR = 0;


int mdo (char **args) {
	int status;
	switch(fork()){
		case -1 : 
			perror("fork");
			exit(EXIT_FAILURE);
		case 0 :
			
			execvp(args[0], args);
			
			exit(EXIT_FAILURE);
		default : ;
	}
	wait(&status);
	if (!WIFEXITED(status)) {
		perror(args[0]);
		exit(EXIT_FAILURE);
	}
	
	return 0;
}

int execution(char **args, int nbArgs) {
	int cpt;
	char **cmdargv;
	int status;
	/*if (OR_OPERATOR == 1) {
		printf("NON IMPLEMENTE\n");
	} else if (AND_OPERATOR == 1) {*/
	if (OPERATOR == 1) {
		if (CC_OPERATOR == 0) {
			printf("%d\n", nbArgs);
			/*printf("CPT COMMANDE : %d \n", cpt);*/
			/*while((cpt < nbArgs-2) && (retour == 0)){
				
				retour = mdo(cmdargv = makeargv(args[cpt]));
				freeargv(cmdargv);
				cpt++;
				
			}*/
			for (cpt = 0 ; cpt < nbArgs-2 ; cpt++) {
				switch(fork()){
					case -1 : 
						perror("fork");
						exit(EXIT_FAILURE);
					case 0 :
						execvp(args[0], cmdargv = makeargv(args[cpt]));
						exit(EXIT_FAILURE);
					default : ;
				}
			}
			if (AND_OPERATOR == 1){
				for (cpt = 0 ; cpt < nbArgs-2 ; cpt++) {
					wait(&status);
					if (!WIFEXITED(status)) {
						freeargv(cmdargv);
						exit(EXIT_FAILURE);
					} 
				}
				freeargv(cmdargv);
				exit(EXIT_SUCCESS);
			} else {
				for (cpt = 0 ; cpt < nbArgs-2 ; cpt++) {
					wait(&status);
					if (WIFEXITED(status)) {
						freeargv(cmdargv);
						exit(EXIT_SUCCESS);
					}
				}
				freeargv(cmdargv);
				exit(EXIT_FAILURE);
		} else {
			printf("NON IMPLEMENTE\n");
			exit(EXIT_FAILURE);
		}
	} else {
		int status;
		switch(fork()){
		case -1 : 
			perror("fork");
			exit(EXIT_FAILURE);
		case 0 :
			execvp(args[0], args);
			exit(EXIT_FAILURE);
		default : ;
		}
		wait(&status);
		if (!WIFEXITED(status)) {
			perror(args[0]);
			exit(EXIT_FAILURE);
		}
		return 0;
	} else  {
		
}

int main(int argc, char **argv) {
	/*int i;*/
	/*if (argc < 2) {
		printf("Erreur d'arguments");
		exit(EXIT_FAILURE);
	}
	
	
	if (strcmp("--or", argv[1]) == 0) {
		OR_OPERATOR = 1;
		OPERATOR = 1;
	} else if  (strcmp("--and", argv[1]) == 0) {
		AND_OPERATOR = 1;
		OPERATOR = 1;
	} else {
		AND_OPERATOR = 1;
	}*/
	/*for ( i = 0; i< argc ;i++) {
		fprintf(stderr, "| %s\n", argv+1[i]);
	}*/
	int c;
	int option_index = 0;
	static struct option long_options[] = {
		{"and",  no_argument, NULL,  '1' },
		{"or",   no_argument, NULL,  '2' },
		{"cc",   no_argument, NULL,  '3' },
		{"kill", no_argument, NULL,  '4' }
	};
	while ((c = getopt_long(argc, argv, "1234:",
			long_options, &option_index)) != -1) {
		if (c == -1)
			break;
		switch (c) {
			case '1':
				printf("Option and activé\n"); AND_OPERATOR = 1;
				break;
			case '2' :
				printf("Option or activé \n"); OR_OPERATOR = 1;
				break;
			case '3' :
				printf("Option cc activé \n"); CC_OPERATOR = 1; 
				break;
			case '4' :
				printf("Option kill activé \n"); KILL_OPERATOR = 1;
				break;
			default : 
				break;
		}
	}
	return execution (argv, argc+2) ;
}
























