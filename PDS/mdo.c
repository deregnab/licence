#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

#include "makeargv.h"

int OR_OPERATOR = 0;
int AND_OPERATOR = 0;
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
	if (WIFEXITED(status)) {
		perror(args[0]);
		exit(EXIT_FAILURE);
	}
	return 0;
}

int execution(const char **args, int nbArgs) {
	int cpt;
	char **cmdargv;
	int retour = 0;
	if (OR_OPERATOR == 1) {
		printf("NON IMPLEMENTE");
	} else {
		if (OPERATOR == 0) {
			cpt = 1;
		} else {
			cpt = 2;
		}
		printf("%d\n", nbArgs);
		while((cpt < nbArgs) && (retour == 0)){
			retour = mdo(cmdargv = makeargv(args[cpt]));
			 freeargv(cmdargv);
			cpt++;
		}
	}
	return retour;
}

int main(int argc, const char **argv) {
	/*int i;*/
	if (argc < 2) {
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
	}
	/*for ( i = 0; i< argc ;i++) {
		fprintf(stderr, "| %s\n", argv+1[i]);
	}*/
	
	return execution (argv, argc+2) ;
}
























