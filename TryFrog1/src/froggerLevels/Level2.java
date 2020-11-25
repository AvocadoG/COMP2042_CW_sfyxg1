package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;

//level 2 - speed up *1.3

/**
 * Level 2 of Frogger Game. The game speed at Level 2 is higher than Level 1.<br>
 * There are still {@link froggerActors.Obstacle}, {@link froggerActors.Turtle},  {@link froggerActors.WetTurtle},  {@link froggerActors.Log} ,  {@link froggerActors.End} at Level 2.
 * @author User
 *
 */
public class Level2 extends Level{
	
	/** level index for {@code Level2}, which is 2*/
	private int currentlevel=2;
	

	/**
	 * Create a {@code Level2} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level2} 
	 */
	public Level2(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());

	}

	/**
	 * {@inheritDoc}, Level 2.<br>
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub
		
						
		add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75));
		add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75));		
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

	}

	
	
	/**{@inheritDoc}, Level 2*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level123_KomikuTraveltotheHorizon.mp3" ;
		
	}

	/**
	 * {@inheritDoc}, Level 2.
	 * Animal will be added into Level 2 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(10.666666*2);
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());

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

