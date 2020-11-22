package froggerLevels;
import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;
/**
 * Level 3 of Frogger Game.<br>
 * At this level, there are <i>coins</i> at some of the {@link froggerActors.End} destinations. If player manages to collect all the coins continuously, the player can proceed to the next level right away and gain extra bonus points.
 * @author User
 *
 */
public class Level3 extends Level{

	/** level index for {@code Level3}, which is 3*/
	private int currentlevel=3;
	
	/**
	 * Create a {@code Level3} for the game.
	 * @param animal the {@code Animal} to be inserted into {@code Level3} 
	 */
	public Level3(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());


	}

	/**
	 * {@inheritDoc}, Level 3.<br>
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub
		

		//add images of logs, turtles, cars(obstacles) and end boxes///
						
		//HOW TO REMOVE
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
	
		//coin End
		add(new End(13,96,true));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,true));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,true));
	
		
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


	}

	

	
	/**{@inheritDoc}, Level 3*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level123_KomikuTraveltotheHorizon.mp3";
	}


	/**
	 * {@inheritDoc}, Level 3.
	 * Animal will be added into Level 3 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setmovementX(10.666666*2);
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());
	}

	/**
	 * getter for {@link Level3#currentlevel}
	 * @return current level# in int
	 */
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return this.currentlevel;
	}
	
	
}
