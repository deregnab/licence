#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <wait.h>
#include "string.h"
#include "makeargv.h"
#include <getopt.h>

#define MAX_ARG 50

int contains(const char **tab, const int size_tab, const char *pattern) {

    int i;

    for (i = 0; i < size_tab; i++) {
        if (!strcmp(tab[i], pattern))
            return 1;
    }

    return 0;
}

int main (int argc, char *argv[]) {
    int i, j = 0, c;
    int flag_or = 0, flag_cc = 0, flag_kill = 0;
    int statut = -1;
    int cc_stop = 0;
    pid_t tab_pid[MAX_ARG] = {0};

    const char *tab_arg[] = {"--and", "--or", "--cc", "--kill"};
    const int size_tab = 4;

    /* Options avec getopt_long */
    while (1) {
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

    for (i = 0; i < argc; i++) {

        pid_t pid;

        /* traiter argv[i] */
        char **cmdargv; 

        if (!contains(tab_arg, size_tab, argv[i])) { 
            /* création du argv de l'argument i */ 
            cmdargv = makeargv(argv[i]);

            assert(cmdargv != NULL);

            switch((pid = fork())){
                case -1 :
                    perror("Error fork");
                    exit(EXIT_FAILURE);
                case 0 :
                    execvp(*cmdargv, cmdargv);
                    exit(EXIT_FAILURE);
                default :
                    tab_pid[j++] = pid;
            }

            /* libération mémoire */
            freeargv(cmdargv);
        }
    }

    /* Attente des fils */
    for (i= 1; i < argc && !cc_stop; i++) {

        int status = -1, cont = 0;

        if (!contains(tab_arg, size_tab, argv[i])) {
        
            wait(&status);
            if (WIFEXITED(status)) {
                if (WEXITSTATUS(status) == 0) {
                    if (flag_or) {
                        printf("Entered %s\n", argv[i]);
                        printf("Code de retour : %i\n", status);
                        statut = 0;
                        cont = 1;
                    }
                }
                else {
                    if (!flag_or) {
                        printf("Entered3 %s avec %i\n", argv[i], statut);
                        statut = status;
                        printf("Entered3 %s avec %i\n", argv[i], statut);
                        cont = 1;
                    }
                }

                if (cont && flag_cc) {
                    cc_stop = 1;
                    break;
                }

            }
        }
    }

    if (flag_kill && cc_stop) {
        for (i = 0; i < argc; i++) {
            kill(tab_pid[optind++], SIGTERM);

        }
    }
    
    return statut;
}
