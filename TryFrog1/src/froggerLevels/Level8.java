package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;

/**
 * <b>Level 8 of Frogger Game.<br>
 * Game settings are similar to {@link froggerLevels.Level7} but speeds up and {@link froggerActors.Monster} grows bigger.
 * </b>
 */
public class Level8 extends Level{
	
	/** level index for {@code Level8}, which is 8*/
	private int currentlevel=8;
	
	/**
	 * Create a {@code Level8} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level8} 
	 */
	public Level8(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());

	}
	

	@Override
	protected void createArena() {
		// TODO Auto-generated method stub

			add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75*1.4));
			add(new Log("file:src/froggertextures/logsbomb.png", 150, 220, 156, 0.75*1.4,true));
			add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75*1.4));
			add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2*1.4));
			add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2*1.4));
			add(new Log("file:src/froggertextures/logsbomb.png", 150, 50, 318, 0.75*1.4,true));		
			add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75*1.4));
			add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75*1.4));
		
			add(new WetTurtle(500, 376, -1*1.4, 130, 130));
			add(new WetTurtle(300, 376, -1*1.4, 130, 130));
			add(new WetTurtle(700, 376, -1*1.4, 130, 130));
			add(new WetTurtle(600, 217, -1*1.4, 130, 130));
			add(new WetTurtle(400, 217, -1*1.4, 130, 130));
			add(new WetTurtle(200, 217, -1*1.4, 130, 130));
		
			add(new Monster(55,0,430,3));
			
			//no coin End
			add(new End(13,96,false));
			add(new End(141,96,false));
			add(new End(141 + 141-13,96,false));
			add(new End(141 + 141-13+141-13+1,96,false));
			add(new End(141 + 141-13+141-13+141-13+3,96,false));
			
			
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1*1.4, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1*1.4, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1*1.4, 120, 120));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1*1.4, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1*1.4, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1*1.4, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1*1.4, 50, 50));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1*1.4, 200, 200));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1*1.4, 200, 200));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5*1.4, 50, 50));

			
	}

	
	/**{@inheritDoc}, Level 8*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level789.mp3";
	}

	
	/**
	 * {@inheritDoc}, Level 8.
	 * Animal will be added into Level 8 game Arena
	 */
	@Override
	public void activateAnimal() {
		System.out.println("Level 8 activated");
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setmovementX(10.666666*2*1.4);
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
