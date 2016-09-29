#include <stdio.h>






int du_file(const char *pathname){
    struct stat st;
    int status,taille=0;
    status=stat(name,&st);

    //test des erreurs
    
    taille += st.st_blocks;
    if (S_Isdir(st.st_block)) (
            char tmp[PATH_MAX];
            DIR *dossier;

            dossier=opendir(name);

    //test des erreurs
    
            while(dir=readdir(dossier) && !(strcmp(dir->d_name,".") || strcmp(dir->d_name,".."))){

                snprintf(tmp,PATH_MAX+1,%s/%s, dir->d_name, name));
                taille+= du_file(tmp);
            }


            if(opt_follow_links && S_ISLINK(st.st_mode)){
                char tmp[PATH_MAX+1];
                status = readlink(name, tmp, PATH_MAX);
                
            
        }
            
