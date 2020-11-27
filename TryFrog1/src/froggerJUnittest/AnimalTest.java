package froggerJUnittest;


import static org.junit.Assert.*;

import javafx.embed.swing.JFXPanel;

import org.junit.Before;
import org.junit.Test;

import froggerAnimal_Actions.*;
import froggerLevels.*;

/**
 * Test on {@link froggerAnimal_Actions.Animal} class.<br>
 * @author GohXinYee
 *
 */
public class AnimalTest{

	public Animal animal;
	public Level1 level1;
	public Level2 level2;
	JFXPanel p = new JFXPanel();
	
	@Before
	public void setUp() throws Exception {
		
		//create an animal
		animal = new Animal("file:src/froggertextures/froggerUp.png");

	}

	
	/**
	 * Test when Animal has reached all the destinations, it will be stopped.
	 */
	@Test
	public void test_Animal_getStop() {
	
		//Animal has reached all 5 destinations at level 1
		animal.setEnd(5);
		assertTrue("Animal is stopped",animal.getStop());
		
	}

	/**
	 * Test when Animal has run out of life, it will be marked as no more life.
	 */
	@Test
	public void test_Animal_noLife() {
		
		//Animal has run out of life
		animal.setLife(0);
		assertTrue("Animal has no more life",animal.noLife());
	}

	/**
	 * Test when the same Animal is activated at different level, its level value will change
	 */
	@Test
	public void test_Animal_at_different_level() {
		
		//set up level 1
		level1 = new Level1(animal);
		//set up level 2
		level2 = new Level2(animal);
		
		//level 1 activates animal
		level1.activateAnimal();
		//animal is now at level 1
		assertTrue("Animal at level 1",animal.getLevel()==1);
		
		//level2 activates animal
		level2.activateAnimal();
		//animal is now at level 2 and not level 1
		assertFalse("Animal not at level 1",animal.getLevel()==1);
		assertTrue("Animal at level 2",animal.getLevel()==2);
	}




}

