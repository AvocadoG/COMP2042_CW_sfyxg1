package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;


/**
 *<b> Level 5 of Frogger Game. <br>
 * Similar to {@link froggerLevels.Level3}, some {@link froggerActors.End} destinations come with bonus coins at Level 5, except this time, the game further speeds up.
 * </b>
 *
 */
public class Level5 extends Level{

	/** level index for {@code Level5}, which is 5*/
	private int currentlevel=5;
	
	/**
	 * Create a {@code Level5} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level5} 
	 */
	public Level5(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());


	}
	
	/**
	 * {@inheritDoc}, Level 5.<br>
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
		
			//coin End
			add(new End(13,96,true));//coin
			add(new End(141,96,false));
			add(new End(141 + 141-13,96,true));
			add(new End(141 + 141-13+141-13+1,96,false));
			add(new End(141 + 141-13+141-13+141-13+3,96,true));

			
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

	
	}

	
	/**{@inheritDoc}, Level 5*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level456.mp3";
	}

	/**
	 * {@inheritDoc}, Level 5.
	 * Animal will be added into Level 5 game Arena
	 */
	@Override
	public void activateAnimal() {
		System.out.println("Level 5 activated");
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
