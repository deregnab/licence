set title "Temps et vitesse d'execution"
set logscale x
set xlabel "taille du buffer"
set logscale y
set ylabel "temps en s"
set style data linespoints
set term png
set output "mcat_scd.png"
plot "mcat-tm.dat" using 1:2 title "vitesse"
#pause -1  "Hit return to continue"
