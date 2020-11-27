package froggerJUnittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import froggerAnimal_Actions.Animal;
import froggerGameActions.*;
import froggerLevels.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

/** Test on {@link froggerGameActions.GameActionContext}, {@link froggerGameActions.UpLevel} class*/
public class GameAction_UpLevelTest{

	Level1 currentlevel;
	Level2 nextlevel;
	Scene currentlevelscene, nextlevelscene;
	Animal animal;
	GameActionContext gacontext;
	JFXPanel p = new JFXPanel();
	
	
	@Before
	public void setUp() throws Exception {
		
		//create an animal
		animal = new Animal("file:src/froggertextures/froggerUp.png");
				
		//set up level 1 as current level
		currentlevel = new Level1(animal);
		currentlevelscene = new Scene(currentlevel,600,800);
		
		//set up level 2 as next level
		nextlevel = new Level2(animal);
		nextlevelscene = new Scene(nextlevel,600,800);

		//start current level 
		currentlevel.start();
		currentlevel.activateAnimal();

	}
	

	@After
	public void tearDown() throws Exception {
		
		//stop next level
		nextlevel.stop();

	}

	
	/** Test when level up, the SAME animal will be moved from the current level to the next level*/
	@Test
	public void test_LevelUp_AnimalwillMove() {
		
		//animal is at current level
		assertEquals(animal.getLevel(),currentlevel.getcurrentLevel());
		
		//executing levelup
		gacontext=new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
		gacontext.TestexecuteAction();
		
		//animal is still the same
		assertEquals(nextlevel.getlevelAnimal(),currentlevel.getlevelAnimal());
		
		//but animal has been moved to the next level
		assertFalse("Animal is not at previous level",animal.getLevel()==currentlevel.getcurrentLevel());
		assertEquals(animal.getLevel(),nextlevel.getcurrentLevel());
		
		
	}
	
	
	/** Test when level up, the animal's points at current level will be brought along to the new level*/
	@Test
	public void test_LevelUp_points_sync() {
		
		//set the points of animal at current level to 60 points 
		currentlevel.getlevelAnimal().setPoints(60);
		assertTrue("current level has 60 points",currentlevel.getlevelPoints()==60);
		
		//level up
		gacontext=new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
		gacontext.TestexecuteAction();
		
		//next level starts with the latest points of the previous level (current level) 
		assertEquals(nextlevel.getlevelPoints(),currentlevel.getlevelPoints());
		assertTrue("Next level starts with 60 points from previous level",nextlevel.getlevelPoints()==60);

	}

	
	/** Test when level up, it will restored the animal's Life to 5 by default*/
	@Test
	public void test_LevelUp_Life_restored() {
		
		//set the amount of life of animal at current level
		currentlevel.getlevelAnimal().setLife(2);
		
		//animal at current level has 2 life
		assertTrue("Animal at cuurent level has 2 life",animal.getLife()==2);

		//level up...
		gacontext=new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
		gacontext.TestexecuteAction();
		
		//animal life is restored to 5
		assertTrue("Animal after level up to next level has 5 life",animal.getLife()==5);
				
	}
	
	@Test
	public void test_LevelUp_EndDestination_reset() {
		
		//set the number of end destinations animal at current level has reached
		currentlevel.getlevelAnimal().setEnd(5);
		
		//animal has reached all 5 destinations at current level
		assertTrue("Animal has reached all 5 end destinations at current level",animal.getEnd()==5);
		
		//level up...
		gacontext=new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
		gacontext.TestexecuteAction();
		
		//animal number of destinations reached is reset at new next level
		assertTrue("Animal's number of end destinations reached is reset to 0 at new level",animal.getEnd()==0);
		
	}
	

}
