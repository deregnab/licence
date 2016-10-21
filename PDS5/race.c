int main(void) {

  course();
  return exit(EXIT_SUCCESS);
}

int course(void) {
  int i;
  int res[10];

  for(i =0; i< 10; i++) {
    switch(fork()) {
      int k, j;
    case -1:
      perror("fork");
      exit(EXIT_FAILURE);

    case 0:
      printf("Processus %d : pid = %d\n", i+1, getpid());
      for(k=0;k<2;k++) {
        for(j=0;j<100000000;j++);
        if(k == 0)
          printf("Fin boucle %d pid = %d\n", k+1, getpid());
      }
      exit(EXIT_SUCCESS);
    }
  }

  for( i=0;i<10;i++) {
    res[i] = wait(NULL);
  }
  for(i = 0;i<10;i++) {
     printf("\n\nPosition %d : pid = %d\n",i+1,res[i]);
  }

  return 1;
}
