package froggerJUnittest;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import froggerAnimal_Actions.*;
import froggerLevels.*;
import javafx.embed.swing.JFXPanel;

/** Test {@link froggerLevels.Level} superclass and its subclasses*/
public class LevelTest{

	Level level;
	Animal animal;
	JFXPanel p = new JFXPanel();

	@Before
	public void setUp() throws Exception {
		
		//create an animal
		animal = new Animal("file:src/froggertextures/froggerUp.png");
		
		//set up level 4 with animal
		level = new Level4(animal);
		
	}


	/** Test when Level activates its Animal, it will give it a default 5 life and 0 end*/
	@Test
	public void test_activateAnimal() {
		level.activateAnimal();
		assertEquals(5,animal.getLife());
		assertEquals(0,animal.getEnd());
	}

	/** Test when the Level's Animal runs out of life, the Level is stopped*/
	@Test
	public void test_levelStop() {
		level.getlevelAnimal().setLife(0);
		assertTrue("Level is stopped",level.levelStop());
	}
	
	/** Test when the Level's Animal has reached all the destinations, the Level is complete*/
	@Test
	public void test_levelComplete() {
		level.getlevelAnimal().setEnd(5);
		assertTrue("Level is complete",level.levelComplete());
	}
	
	/** Test the Level is syncing points with its Animal*/
	@Test
	public void test_Levelpoints_sync_Animalpoints() {
		
		//set the animal at the level with 40 points
		level.getlevelAnimal().setPoints(40);
		assertEquals(40,level.getlevelPoints());
		
	}
	
	/** Test the Level is syncing life with its animal*/
	@Test
	public void test_Levellife_sync_Animallife() {
		
		//set the animal at the level with 3 life
		level.getlevelAnimal().setLife(3);
		assertEquals(3,level.getlevelLife());
		
	}
	


}

