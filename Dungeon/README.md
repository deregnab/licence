Dungeon
=======

Introduction
------------
Premier Projet en COO de la Licence 3 Informatique.     
Ce projet est un Jeu de Rôle (RPG) simulant un Donjon pouvant être exploré
par le joueur, dans le but d'atteindre la sortie en ramassant le plus d'or
possible.   
Le donjon comprend des Monstres qui bloquent le chemin du joueur ainsi que
des objets aidant le joueur à rejoindre la sortie !

Utilisation
-----------
Recuperer les sources du projet :
```sh
$ git clone https://gitlab-etu.fil.univ-lille1.fr/seysn/Dungeon.git
```

Rentrer dans le projet puis compiler :
```sh
$ cd Dungeon
$ mvn package 
```

Puis lancer le projet :
```sh
$ java -jar target/dungeon-1.0-SNAPSHOT.jar
```

Pour generer la documentation :
```sh
$ mvn javadoc:javadoc
```

Auteurs
-------
Clément BOIN - cboin - Gp 3     
Nicolas SEYS - seysn - Gp 3