#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int obs(int n);


int main(void) {
  printf("######## OBS #######\n\n");
  obs(3);
  return 1;
}

int obs(int n) {
  int i;
  int pid;
  
  for(i=0;i<n;i++){
    switch(fork()) {
    case -1:
      perror("fork");
      exit(EXIT_FAILURE);
    case 0:
      while(1){
	printf("Pid : %d\n",getpid());
	sleep(5);
      }
    }
  }
  
  
  for(i=0;i<n;i++) {
    char tmp[256];
    system("ps -a");
    scanf("%s",tmp);
    pid = wait(NULL);
    printf("pid terminé : %d\n", pid);
  }

  return 1;
}
