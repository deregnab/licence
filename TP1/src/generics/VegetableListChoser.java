package generics;

import scanner.*;

import java.util.*;

public class VegetableListChoser {

    // methode chose
    // elle est similaire a celle de ListChoser simplement elle ne fonctionne
    // qu'avec des listes d'objets de type Legume (cf. interface Legume)
    // quel changement apporter a la methode de ListChoser  ?
    
	
public <T extends Vegetable> T chose(String msg, List<T> liste ){
		
		int valeur = 0;
		for (int i=0; i<liste.size();i++){
			if (i==0){
				System.out.println(" 0 : aucun");
			}
			else{
				System.out.println(valeur + " : " + liste.get(i-1));
			}
			valeur++;
		}
		System.out.println(msg);
		int valRetournee=ScannerInt.readInt(valeur-1);
		
		if (valRetournee!=0){
			return liste.get(valRetournee-1);
		}
		return null;
	}

    public static void main(String[] args) {
		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		VegetableListChoser lcl = new VegetableListChoser();

		Carrot chosenCarrot = lcl.chose("which carrot ? ", lCarrots);
		System.out.println("You have chosen : " + chosenCarrot);

		// NE COMPILE PAS
		// Apple chosenApple = lcl.chose("which apple ? ",lApples);


    }
}
