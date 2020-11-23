package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;

/**
 * Level 9 of Frogger Game.<br>
 * With coin destinations, Monster and all sinking turtles, at Level 9, all game objects are moving even faster than all previous levels.
 * @author User
 *
 */
public class Level9 extends Level{
	
	/** level index for {@code Level9}, which is 9*/
	private int currentlevel=9;
	
	/**
	 * Create a {@code Level9} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level9} 
	 */
	public Level9(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());

	}
	

	@Override
	protected void createArena() {
		// TODO Auto-generated method stub

							
			add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75*1.5));
			add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75*1.5));
			add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75*1.5));
			add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2*1.5));
			add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2*1.5));
			add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.75*1.5));
			add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75*1.5));
			add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75*1.5));
		
			add(new WetTurtle(500, 376, -1*1.5, 130, 130));
			add(new WetTurtle(300, 376, -1*1.5, 130, 130));
			add(new WetTurtle(700, 376, -1*1.5, 130, 130));
			add(new WetTurtle(600, 217, -1*1.5, 130, 130));
			add(new WetTurtle(400, 217, -1*1.5, 130, 130));
			add(new WetTurtle(200, 217, -1*1.5, 130, 130));
		
			add(new Monster(55,0,430,4));

			
			//coin End
			add(new End(13,96,true));//coin
			add(new End(141,96,false));
			add(new End(141 + 141-13,96,true));
			add(new End(141 + 141-13+141-13+1,96,false));
			add(new End(141 + 141-13+141-13+141-13+3,96,true));
			
			
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1*1.5, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1*1.5, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1*1.5, 120, 120));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1*1.5, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1*1.5, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1*1.5, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1*1.5, 50, 50));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1*1.5, 200, 200));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1*1.5, 200, 200));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5*1.5, 50, 50));

			add(new Life(5,30,500,60));
			add(new Digit(0, 30, 550, 25));

	}
	
	
	/**{@inheritDoc}, Level 9*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level789.mp3";
	}

	/**
	 * {@inheritDoc}, Level 9.
	 * Animal will be added into Level 9 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setmovementX(10.666666*2*1.5);
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());

	}
	
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}

}
