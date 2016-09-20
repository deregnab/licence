package generics;   
import java.util.*;
import exception.AlreadyCarryingException;;
/**
 * @author Deregnaucourt
 *define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 * @param <T>
 */
public class Collector<T>{

    public Collector(String name) {
	this.name = name;
    }

    private String name;
	
    /**
     * carry the Object T
     */
    private T carriedObject;
    
    
    /**
     * Methode toString classique on va pas epiloguer
       @return le nom du collector
     */
    public String toString() {
	return this.name;
    }
    
    /**
     * @return une chaine comportant le nom du collector et l'objet qu'il porte
     */
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }
    // METHODES a DEFINIR
    // take : pour prendre un objet de type T (si aucun de "tenu")
    // getCarriedObject : pour connaitre l'objet "porte" (null si saucun)
    // giveTo : donne l'objet porte a un autre ramasseur compatible 
    // drop : depose l'objet "tenu"

    
    public T collect(T object){

    	try{
    	if(this.carriedObject==null){
    		this.carriedObject=object;
    		
    	}else{
    		throw new AlreadyCarryingException();
			}
    	} catch (AlreadyCarryingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
    	
    	}
    	return this.carriedObject;
    }
  
    
    /**
     * @return l'objet porte par le collector
     */
    public T getCarriedObject(){
    	return this.carriedObject;
    	
    }
    
    /**
	 * methode permettant au collector de relacher l'objet porté
     * @return le type de l'objet laché par le collector
     */
    public T drop(){
    	T tmp = this.getCarriedObject();
    	this.carriedObject=null;
    	return tmp;
    }
    
    /**
     * permet à un collector de donner l'objet qu'il porte à un autre collector
     * @return 
     * @throws AlreadyCarryingException 
     */
    public void giveTo (Collector<? super T> c) {
    	try{
    	if (c.getCarriedObject()==null){
    		T tmp;
    		tmp=this.getCarriedObject();
    		this.carriedObject=null;
    		c.carriedObject=tmp;
    	
    	}else{
    		throw new AlreadyCarryingException();
			}
    	} catch (AlreadyCarryingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
    	
    	}

    }
	
    public static void main(String[] args) {
	
		Carrot c1 = new Carrot(1);
		Carrot c2 = new Carrot(2);
		Carrot c3 = new Carrot(3);
		Apple p1 = new Apple(1);
		Apple p2 = new Apple(2);

		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");
		
		// attention ici le type d'objets ramasses est Legume :
		Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

		carrotCollector1.collect(c3);
		System.out.println(carrotCollector1.description());
		// NE COMPILE PAS
		// carrotCollector2.collect(p1);

		// NE COMPILE PAS
		// carrotCollector1.giveTo(appleCollector1);

		// COMPILE :
		carrotCollector1.giveTo(vegetableCollector);

		// NE COMPILE PAS
		// vegetableCollector.giveTo(carrotCollector1);
		// NE COMPILE PAS
		// appleCollector1.giveTo(vegetableCollector);

		carrotCollector1.collect(c1);
		carrotCollector1.giveTo(carrotCollector2);
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		carrotCollector1.collect(c2);
		
		
		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (IllegalStateException e) {
			//System.out.println("*** exception : " + carrotCollector2 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}

		appleCollector1.collect(p2);
		System.out.println(appleCollector1.description());
		try {
			appleCollector1.collect(p1);
		} catch (IllegalStateException e) {
			//System.out.println("*** exception : " + appleCollector1 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}
		appleCollector1.drop();
		System.out.println(appleCollector1.description());
		appleCollector1.collect(p1);
	
     }


}
