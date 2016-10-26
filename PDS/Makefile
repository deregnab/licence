# On désactive toutes les règles implicites
.SUFFIXES:

# Déclarations de constantes
CFLAGS =-Wall -Werror -ansi -pedantic
CFLAGS += -D_XOPEN_SOURCE=500
CFLAGS +=-g

all: mdo 

# 
args: args.c makeargv.c
	gcc $(CFLAGS) -o args $^

mdo: mdo.c makeargv.c
	gcc $(CFLAGS) -o mdo $^


# Règle générique : $< == le fichier .c compilé
%.o: %.c
	gcc $(CFLAGS) -c -o $@ $<

clean :
	rm *.o || true

test :
	script -c ./test.sh session.txt

.PHONY: all clean realclean test

