package froggerJUnittest;


import froggerAnimal_Actions.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.embed.swing.JFXPanel;

import froggerAnimal_Actions.AnimalDeathContext;
import froggerAnimal_Actions.CarDeath;

/** Test for {@link froggerAnimal_Actions.AnimalDeathContext}, {@link froggerAnimal_Actions.AnimalDeath} interface and concrete classes implementing the interface*/
public class AnimalDeathTest{

	Animal animal;
	AnimalDeathContext adcontext;
	JFXPanel p = new JFXPanel();
	
	@Before
	public void setUp() throws Exception {
		
		//create an animal
		animal = new Animal("file:src/froggertextures/froggerUp.png");
		//set up animal initial points and life
		animal.setPoints(100);
		animal.setLife(5);
	}

	/**
	 * Test : <br>
	 * When Animal experiences car death, its points and life will be deducted.<br>
	 * When Animal doesn't experience any car death, its points and life will remain.
	 */
	@Test
	public void test_Animal_CarDeath() {
		
		boolean cardeath;
		int now;//time frame
		
		
		System.out.println("Initial points " + animal.getPoints());
		System.out.println("Initial life amount " + animal.getLife());

		cardeath=true;
		System.out.println("Executing car death action...(car death occurs)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,cardeath));
		for(now=11;now<=44;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
		cardeath=false;
		System.out.println("Executing car death action...(car death doesn't occur)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,cardeath));
		for(now=11;now<=44;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
	}
	
	/**
	 * Test : <br>
	 * When Animal experiences monster death, its points and life will be deducted.<br>
	 * When Animal doesn't experience any monster death, its points and life will remain.
	 */
	@Test
	public void test_Animal_MonsterDeath() {
		
		boolean monsterdeath;
		int now;//time frame
		
		
		System.out.println("Initial points " + animal.getPoints());
		System.out.println("Initial life amount " + animal.getLife());

		monsterdeath=true;
		System.out.println("Executing monster death action...(monster death occurs)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,monsterdeath));
		for(now=11;now<=44;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
		monsterdeath=false;
		System.out.println("Executing monster death action...(monster death doesn't occur)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,monsterdeath));
		for(now=11;now<=44;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
	}
	
	
	/**
	 * Test : <br>
	 * When Animal experiences water death, its points and life will be deducted.<br>
	 * When Animal doesn't experience any water death, its points and life will remain.
	 */
	@Test
	public void test_Animal_WaterDeath() {
		
		boolean waterdeath;
		int now;//time frame
		
		
		System.out.println("Initial points " + animal.getPoints());
		System.out.println("Initial life amount " + animal.getLife());

		waterdeath=true;
		System.out.println("Executing water death action...(water death occurs)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,waterdeath));
		for(now=11;now<=55;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
		waterdeath=false;
		System.out.println("Executing water death action...(water death doesn't occur)");
		adcontext = new AnimalDeathContext(new CarDeath(animal,waterdeath));
		for(now=11;now<=55;now=now+11) {
			adcontext.executeAction(now);
		}
		
		System.out.println("Latest points " + animal.getPoints());//90
		System.out.println("Latest life amount " + animal.getLife());//4
		assertEquals(90,animal.getPoints());
		assertEquals(4,animal.getLife());
		
		
	}
	
	


}
