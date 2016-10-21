#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

typedef int (*func_t) (int);

int toto (int a){

printf("toto %d\n",a);
exit(EXIT_SUCCESS);

}

int tata (int a){

printf("tata %d\n",a);
exit(EXIT_SUCCESS);

}
int titi (int a){

printf("titi %d\n",a);
exit(EXIT_SUCCESS);

}
int multif(func_t f[], int args[], int n) {
  int i;
  int status;
  int ret;

  for(i=0;i<n;i++){
    switch(fork()){
    case -1:
      perror("fork");
      return exit(EXIT_FAILURE);
    case 0:
      ret = f[i](args[i]);
      if(ret < 0 ) {
        exit(EXIT_FAILURE);
      } else {
        exit(EXIT_SUCCESS);
      }
    default:
      waitpid(-1,&status,0);
      if(WEXITSTATUS(status) != EXIT_SUCCESS) {
        return -1;

          }
    }
  }
  return exit(EXIT_SUCCESS);
}


int main(int argc, char *argv[]){
	
	funct_t f[]={toto,tata,titi,tata,toto};
	int args[]={1,2,3,4,5};
	
	multif(f,args);

}