#!/bin/bash

cd fichiers
echo "ex1q1:"
egrep --color ' nez.' Cyrano.txt
echo "ex1q2:"
egrep --color '\(.*)' Cyrano.txt
echo "ex1q3:"
egrep --color '([[:punct:]]|[[:space:]])[[:alpha:]]{4}([[:punct:]]|[[:space:]])' Cyrano.txt
echo "ex1q4:"
echo "car il interpréte le premier \" vous \" quand il arrive sur le second (qui ne contient plus de séparateur avant le v)"
echo "ex1q5:"
egrep --color -o '.* : " ' Cyrano.txt

cd html
echo "ex2q1:"
valeurAttribut='="[^"]*"'
egrep --color $valeurAttribut *.html
echo "ex2q2:"

echo "ex2q3:"
egrep --color '(\+[[:digit:]]{2}[[:space:]]\(0\)[[:space:]][[:digit:]](.[[:digit:]]{2}){4})|(.[[:digit:]]{2}){5}' *.html
cd ..
echo "ex3q1:"
egrep --color '[[:digit:]](BIS|TER)' bano-59009.csv
echo "ex3q2:"
egrep --color 'Ruelle' bano-59009.csv
echo "ex3q3:"
egrep --color ',.*,[[:upper:]]{2}+[[:space:][:punct:]][[:upper:]]*' bano-59009.csv
