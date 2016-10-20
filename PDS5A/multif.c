#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

typedef int (*func_t) (int);
int multif(func_t f[], int args[], int n);
int f1(int n);
int f2(int n);
int f3(int n);
int f4(int n);


int main(void) {
  func_t f[] = {f1,f2,f3};
  func_t fct2[] = {f1,f4,f3};
  int args[] = {1,2,3};
  int n = 3;
  int ret;
  printf("########### MULTIF ###########\n");
  printf("Les fonctions retournent une valeur vraie\n");
  ret = multif(f,args,n);
  printf("ret : %d\n\n",ret);

  args[1] = 4;
  args[2] = 3;
  
  printf("Les fonctions retournent une valeur vraie sauf la fonction f4\n");
  ret = multif(fct2,args,n);
  printf("ret : %d\n",ret);
  
  return 1;
}

int multif(func_t f[], int args[], int n) {
  int i;
  int status;
  int ret;
  
  for(i=0;i<n;i++){
    switch(fork()){
    case -1:
      perror("fork");
      return -1;
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
  return 1;
}

int f1(int n) {
  printf("f%d\n",n);
  return 1;
}

int f2(int n) {
  printf("f%d\n",n);
  return 1;
}

int f3(int n) {
  printf("f%d\n",n);
  return 1;
}

int f4(int n) {
  printf("f%d\n",n);
  return -1;
}






