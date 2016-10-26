#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <wait.h>
#include "string.h"
#include "makeargv.h"
#include <getopt.h>

int main (int argc, char *argv[]) {
    int i, c;
    int digit_optind = 0;
    int flag_or, flag_cc, flag_kill;
    int statut = -1;

    /* Options avec getopt_long */
    while (1) {
        int this_option_optind = optind ? optind : 1;
        int option_index = 0;
        static struct option long_options[] = {
            {"and", no_argument, 0, 1},
            {"or", no_argument, 0, 2},
            {"cc", no_argument, 0, 3},
            {"kill", no_argument, 0, 4}
        };

        c = getopt_long(argc, argv, "", long_options, &option_index);
        if (c == -1)
            break;

        switch (c) {
            case 1 :
                flag_or = 0;
                break;
            case 2 :
                flag_or = 1;
                break;
            case 3 :
                flag_cc = 1;
                break;
            case 4 :
                flag_kill = 1;
                break;
            case '?' :
                break;
        }
    }

    for (i = 2; i < argc; i++) {

        /* traiter argv[i] */
        char **cmdargv;

        /* création du argv de l'argument i */
        cmdargv = makeargv(argv[i]);

        assert(cmdargv != NULL);

        switch(fork()){
            case -1 :
                perror("ERROR FORK");
                exit(EXIT_FAILURE);
            case 0 :
                execvp(cmdargv[0], cmdargv+1);
                perror("Error execvp");
                exit(EXIT_FAILURE);
        }

        /* libération mémoire */
        freeargv(cmdargv);
    }

    for (i= 0; i < argc; i++) {

        int status;

        wait(&status);
        if (WIFEXITED(status)) {
            if (WEXITSTATUS(status) == 0) {
                if (flag_or) {
                    if (statut == -1)
                        statut = status;
                    else
                        statut = statut | status;
                }
                else {
                    if (statut == -1)
                        statut = status;
                    else
                        statut = status & status;
                }
            }
            exit(WEXITSTATUS(status));
        }
        exit(EXIT_FAILURE);
    }

    return statut;
}
