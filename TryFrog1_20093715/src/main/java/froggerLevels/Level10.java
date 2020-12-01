package froggerLevels;

import froggerActors.End;
import froggerActors.Log;
import froggerActors.Monster;
import froggerActors.Obstacle;
import froggerActors.WetTurtle;
import froggerAnimal_Actions.Animal;

/**
 * <b>Level 10 of Frogger Game, which is also the final level.<br>
 * At this level, the game speed is the highest among all the other levels. No more coin destinations for bonus points and the player shall reach all destinations to WIN the Game!</b>
 *
 */
public class Level10 extends Level{

	private int currentlevel=10;
	
	/**
	 * Create a {@code Level10} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level10} 
	 */
	public Level10(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());

	}
	
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub
		
		//add Logs to the game
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 0, 166, 0.75*1.7));
		add(new Log("file:src/main/resources/froggertextures/logsbomb.png", 150, 220, 156, 0.75*1.7,true));
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 440, 166, 0.75*1.7));
		add(new Log("file:src/main/resources/froggertextures/logs.png", 300, 0, 276, -2*1.7));
		add(new Log("file:src/main/resources/froggertextures/logs.png", 300, 400, 276, -2*1.7));

		add(new Log("file:src/main/resources/froggertextures/logsbomb.png", 150, 50, 318, 0.75*1.7,true));		

		
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 270, 329, 0.75*1.7));
		add(new Log("file:src/main/resources/froggertextures/log3.png", 150, 490, 329, 0.75*1.7));
	
		//add Wet Turtles to the game
		add(new WetTurtle(500, 376, -1*1.7, 130, 130));
		add(new WetTurtle(300, 376, -1*1.7, 130, 130));
		add(new WetTurtle(700, 376, -1*1.7, 130, 130));
		add(new WetTurtle(600, 217, -1*1.7, 130, 130));
		add(new WetTurtle(400, 217, -1*1.7, 130, 130));
		add(new WetTurtle(200, 217, -1*1.7, 130, 130));
	
		//add Monster
		add(new Monster(55,0,430,4));
		
		//add Ends with and without Coins
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		//add cars and trucks
		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 0, 649, 1*1.7, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 300, 649, 1*1.7, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/truck1"+"Right.png", 600, 649, 1*1.7, 120, 120));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 100, 597, -1*1.7, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 250, 597, -1*1.7, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 400, 597, -1*1.7, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 550, 597, -1*1.7, 50, 50));
		add(new Obstacle("file:src/main/resources/froggertextures/truck2Right.png", 0, 540, 1*1.7, 200, 200));
		add(new Obstacle("file:src/main/resources/froggertextures/truck2Right.png", 500, 540, 1*1.7, 200, 200));
		add(new Obstacle("file:src/main/resources/froggertextures/car1Left.png", 500, 490, -5*1.7, 50, 50));

	}

	/**{@inheritDoc}, Level 10*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile="src/main/resources/froggermusic/Level10_Komiku.mp3";
	}

	/**
	 * {@inheritDoc}, Level 10.
	 * Animal will be added into Level 10 game Arena
	 */
	@Override
	public void activateAnimal() {
		// TODO Auto-generated method stub
		System.out.println("Level 10 activated");
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setmovementX(10.666666*2*1.7);
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());

	}
	
	public int getcurrentLevel() {
		return this.currentlevel;
	}
	

}
