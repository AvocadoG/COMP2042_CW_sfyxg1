package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;

/**
 * <b>Level 7 of Frogger Game.<br>
 * At this level, all the turtles turn into {@link froggerActors.WetTurtle} which will sink into the river from time to time, causing player's avatar to die drowning. 
 * Level 7 is unlike the previous levels where there are still regular {@link froggerActors.DryTurtle} that always float on the river.<br>
 * There are also {@link froggerActors.Log} with <i>bombs</i> which will kill the player's avatar if it jumps on it.<br>
 *</b>
 */
public class Level7 extends Level{

	/** level index for {@code Level7}, which is 7*/
	private int currentlevel=7;
	
	/**
	 * Create a {@code Level7} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level7} 
	 */
	public Level7(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());


	}
	
	
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub

		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 0, 166, 0.75*1.3));
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 220, 166, 0.75*1.3));
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 440, 166, 0.75*1.3));
		add(new Log("file:src/main/resources/froggertextures/logs.png", 300, 0, 276, -2*1.3));
		add(new Log("file:src/main/resources/froggertextures/logs.png", 300, 400, 276, -2*1.3));
		add(new Log("file:src/main/resources/froggertextures/logsbomb.png", 150, 50, 318, 0.75*1.3,true));		
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 270, 329, 0.75*1.3));
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 490, 329, 0.75*1.3));

	
		add(new WetTurtle(500, 376, -1*1.3, 130, 130));
		add(new WetTurtle(300, 376, -1*1.3, 130, 130));
		add(new WetTurtle(700, 376, -1*1.3, 130, 130));
		add(new WetTurtle(600, 217, -1*1.3, 130, 130));
		add(new WetTurtle(400, 217, -1*1.3, 130, 130));
		add(new WetTurtle(200, 217, -1*1.3, 130, 130));
			
		//no coin End
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));


		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 0, 649, 1*1.3, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 300, 649, 1*1.3, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 600, 649, 1*1.3, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 100, 597, -1*1.3, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 250, 597, -1*1.3, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 400, 597, -1*1.3, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 550, 597, -1*1.3, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/truck2Right.png", 0, 540, 1*1.3, 200, 200));
		add(new Obstacle("file:src/main/resources/froggertextures/truck2Right.png", 500, 540, 1*1.3, 200, 200));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 500, 490, -5*1.3, 50, 50));
	}

	/**{@inheritDoc}, Level 7*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/main/resources/froggermusic/Level789.mp3";
	}


	/**
	 * {@inheritDoc}, Level 7.
	 * Animal will be added into Level 7 game Arena
	 */
	@Override
	public void activateAnimal() {
		System.out.println("Level 7 activated");
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setmovementX(10.666666*2*1.3);
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
