package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;

//level 2 - speed up *1.3

/**
 * Level 2 of Frogger Game. The game speed increases at this level.
 * @author User
 *
 */
public class Level2 extends Level{

	//private Stage level1stage;
	private Animal animallevel2;
	private int currentlevel=2;
	

	/**
	 * Create a {@code Level2} for the game with an {@link p4_group_8_repo.Animal} ready but not yet activated.
	 * Game arena for {@code Level2} will be set up, the level# will be displayed.
	 * @param animal the {@code Animal} to be inserted into the {@code Level2} 
	 */
	public Level2(Animal animal){
		setlevelAnimal(animal);
		createArena();
		createMusic("src/froggermusic/FroggerLevel1.mp3");
		super.displaylevel(getcurrentLevel());

	}

	/**
	 * {@inheritDoc}, Level 2.<br>
	 * relevant Actor class objects such as {@link p4_group_8_repo.Obstacle}, {@link p4_group_8_repo.Turtle},  {@link p4_group_8_repo.WetTurtle},  {@link p4_group_8_repo.Log} ,  {@link p4_group_8_repo.End} will be added to the Level 2 Game Arena with a faster moving speed than Level 1.
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub
		
		//add images of logs, turtles, cars(obstacles) and end boxes///
						
		add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75));
		
		
		//redundant
		add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2));
		add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2));
		add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75));
	
		add(new Turtle(500, 376, -1, 130, 130));
		add(new Turtle(300, 376, -1, 130, 130));
		add(new Turtle(700, 376, -1, 130, 130));
		add(new WetTurtle(600, 217, -1, 130, 130));
		add(new WetTurtle(400, 217, -1, 130, 130));
		add(new WetTurtle(200, 217, -1, 130, 130));

		//no coin End
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		/*animallevel2 = new Animal("file:src/froggertextures/froggerUp.png");
		animallevel2.setmovementX(10.666666*2);
		animallevel2.setLevel(getcurrentLevel());*/
		//add(animallevel2);
		
		
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1, 120, 120));

		add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1, 50, 50));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1, 200, 200));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1, 200, 200));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5, 50, 50));

		add(new Life(5,30,500,60));
		add(new Digit(0, 30, 550, 25));
		
		//add(new Digit(getcurrentLevel(),30,550,450));


	}

	
	
	/**{@inheritDoc}, Level 2*/
	@Override
	public void createMusic(String musicFile) {
		// TODO Auto-generated method stub
		super.musicFile= musicFile ;
		
	}


	/**
	 * {@inheritDoc}, Level 2
	 * @return boolean <b>true</b> if {@code Animal} has completed Level 2
	 */
	@Override
	public boolean levelComplete() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getStop();
	}
	
	@Override
	public boolean levelStop() {
		// TODO Auto-generated method stub
		return getlevelAnimal().noLife();
	}

	/**
	 * {@inheritDoc}, Level 2.
	 * @return boolean <b>true</b> if {@code Animal} score is changed, at Level 2
	 */
	@Override
	public boolean animalchangeScore() {
		// TODO Auto-generated method stub
		return getlevelAnimal().changeScore();
	}
	
	@Override
	public boolean animalchangeLife() {
		// TODO Auto-generated method stub
		return getlevelAnimal().changeLife();
	}
	

	/**
	 * {@inheritDoc}, Level 2.
	 * Animal will be added into Level 2 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(10.666666*2);
		animallevel2.setLevel(getcurrentLevel());
		animallevel2.setEnd(0);
		animallevel2.setLife(5);
		add(animallevel2);

	}
	
	/** {@inheritDoc}, Level 2*/
	@Override
	public int getlevelPoints() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getPoints();
	}
	

	@Override
	public int getlevelLife() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getLife();
	}
	
	
	/**
	 * setter for {@link Level2#animallevel2}
	 * @param animal {@code Animal} to be set for Level 2
	 */
	public void setlevelAnimal(Animal animal) {
		// TODO Auto-generated method stub
		this.animallevel2=animal;
	}

	/**
	 * getter for {@link Level2#animallevel2}
	 * @return {@code Animal} object of {@code Level2}
	 */
	public Animal getlevelAnimal() {
		// TODO Auto-generated method stub
		return this.animallevel2;
	}

	/**
	 * getter for {@link Level2#currentlevel}
	 * @return current level# in int
	 */
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return this.currentlevel;
	}
	
	





	

	
}

