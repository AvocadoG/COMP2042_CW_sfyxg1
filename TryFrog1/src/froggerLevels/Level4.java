package froggerLevels;


import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;

/**
 * Level 4 of Frogger Game. <br>
 * At this level, the game further speeds up, faster than the previous Level 1,2,3.
 * @author User
 *
 */
public class Level4 extends Level{

	/** level index for {@code Level4}, which is 4*/
	private int currentlevel=4;
	

	/**
	 * Create a {@code Level4} for the game.
	 * @param animal the {@code Animal} to be inserted into {@code Level4} 
	 */
	public Level4(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());
	}
	
	/**
	 * {@inheritDoc}, Level 4.<br>
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub

			add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75*1.3));
			add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2*1.3));
			add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75*1.3));
		
			add(new Turtle(500, 376, -1*1.3, 130, 130));
			add(new Turtle(300, 376, -1*1.3, 130, 130));
			add(new Turtle(700, 376, -1*1.3, 130, 130));
			add(new WetTurtle(600, 217, -1*1.3, 130, 130));
			add(new WetTurtle(400, 217, -1*1.3, 130, 130));
			add(new WetTurtle(200, 217, -1*1.3, 130, 130));

			//no coin End
			add(new End(13,96,false));
			add(new End(141,96,false));
			add(new End(141 + 141-13,96,false));
			add(new End(141 + 141-13+141-13+1,96,false));
			add(new End(141 + 141-13+141-13+141-13+3,96,false));

			
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1*1.3, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1*1.3, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1*1.3, 120, 120));

			add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1*1.3, 200, 200));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1*1.3, 200, 200));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5*1.3, 50, 50));

			add(new Life(5,30,500,60));
			add(new Digit(0, 30, 550, 25));

	}


	/**{@inheritDoc}, Level 4*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level456.mp3";
	}

	/**
	 * {@inheritDoc}, Level 4.
	 * Animal will be added into Level 4 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(10.666666*2*1.3);
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());

	}

	/**
	 * getter for {@link Level4#currentlevel}
	 * @return current level# in int
	 */
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}
	

}
