package Test;
import generics.*;
import exception.*;
import static org.junit.Assert.*;

import org.junit.Test;
import exception.*;
public class TestCollector {

	@Test(expected = AlreadyCarryingException.class)
	public void testTake(){
		Collector<Rutabaga> c = new Collector<Rutabaga>("AbraKadabraAlakazam");
		Rutabaga r = new Rutabaga(1);
		Rutabaga r2 = new Rutabaga(2);
		c.collect(r);
		c.collect(r2);
		
	}
	@Test
	public void testDrop(){
		Collector<Carrot> BugsBunny = new Collector<Carrot>("PosipiNegapi");
		Carrot docteur = new Carrot(1);
		BugsBunny.collect(docteur);
		assertSame(docteur, BugsBunny.drop());
	}
	
	@Test
	public void testGiveTo(){
		Collector<Apple> c = new Collector<Apple>("Pomme");
		Collector<Apple> c2= new Collector<Apple>("Pomme");
		Apple pomme = new Apple(1);
		c.collect(pomme);
		c.giveTo(c2);
		assertSame(pomme,c2.getCarriedObject());
		
	}
	
	@Test
	public void TestGetCarriedObject(){
		Collector<Apple> c = new Collector<Apple>("Pomme");
		Apple pomme = new Apple(1);
		c.collect(pomme);
		assertSame(pomme,c.getCarriedObject());
	}
}
