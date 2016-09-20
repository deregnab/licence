package generics;

import scanner.*;
import java.util.*;

public class ClonableVegetableListChoser {

	// methode "chose"
	// elle est similaire a celles de ListChoser et ListChoserLegume
	// simplement elle ne fonctionne qu'avec des listes d'objets de type Legume
	// qui de plus sont clonables (donc implémentent l'interface
	// java.lang.Clonable).
	// quel(s) changement(s) apporter à la méthode de ListChoser ?

public <T extends Vegetable & Cloneable> T chose(String msg, List<T> liste ){
		
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

		List<Cauliflower> lCauliflowers = new LinkedList<Cauliflower>();
		lCauliflowers.add(new Cauliflower(1));
		lCauliflowers.add(new Cauliflower(2));
		lCauliflowers.add(new Cauliflower(3));

		ClonableVegetableListChoser lclc = new ClonableVegetableListChoser();

		Carrot chosenCarrot = lclc.chose("which carrot ? ", lCarrots);
		System.out.println("you have chosen : " + chosenCarrot);

		Cauliflower chosenCauliflower = lclc.chose("which cauliflower ? ", lCauliflowers);
		System.out.println("you have chosen : " + chosenCauliflower);

		List<Rutabaga> lRutabagas = new ArrayList<Rutabaga>();
		lRutabagas.add(new Rutabaga(1));
		lRutabagas.add(new Rutabaga(2));
		lRutabagas.add(new Rutabaga(3));
		// NE COMPILE PAS :
		// Rutabaga chosenRutabaga = lclc.chose("which rutabaga ? ",lRutabagas);

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		// NE COMPILE PAS :
		// Apple chosenApple = lclc.chose("which apple ? ",lApples);

	}
}
