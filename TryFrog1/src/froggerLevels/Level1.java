package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

//change scoring system, move up +5 points
//reach empty END +10 points
//reach empty END with bonus coin +20 points
//hit by the obstacles / sink into the river / monster -10points

//level1 - speed down (0.75 down 0.5, -2 down -1, turtle -1 down -0.5) add Level Digit, set animal level & mX
//level2 - original speed
//level3 - speed up *1.3, End with a Coin - if get it extra 10points, +1 WT
//level4 - original speed, all WT, add A monster (2 speed) at resting zone - if hit -10points, sent back to ori position
//level5 - speed up *1.3, all WT, monster speed up too (3 speed)

//add Level display on screen
//speed scale down by 0.7

/**
 * Level 1 of Frogger Game. 
 * The game speed of this level is rather slow for an easy start.<br>
 * There are {@link froggerActors.Obstacle}, {@link froggerActors.Turtle},  {@link froggerActors.WetTurtle},  {@link froggerActors.Log} ,  {@link froggerActors.End} and Level 1.
 * @author User
 *
 */
public class Level1 extends Level{

	/** level index for {@code Level1}, which is 1*/
	private int currentlevel=1;
	
	
	/**
	 * Create a {@code Level1} for the game.
	 * @param animal the {@code Animal} to be inserted into the {@code Level1} 
	 */
	public Level1(Animal animal){
		super.setlevelAnimal(animal);
		createArena();
		createMusic();
		super.displaylevel(getcurrentLevel());	
	}

	/**
	 * {@inheritDoc}, Level 1.<br> Relevant game objects will be added into the game arena.
	 */
	@Override
	protected void createArena() {
		
		// TODO Auto-generated method stub
		
		//add images of logs, turtles, cars(obstacles) and end boxes///
						
		//1st row 166, 2nd 276, 3rd 329
		//change speed 0.75 to 0.5
		add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75*0.7));///
		add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75*0.7));
		add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75*0.7));
		
		
		//0.75 to 0.5, -2 to -1
		add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2*0.7));//-2
		add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2*0.7));
		add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.75*0.7));
		add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75*0.7));
		add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75*0.7));
	
		//turtle pos
		//nearer to the resting zone is 376
		//nearer to the end is 217
		//-1 to -0.5
		add(new Turtle(500, 376, -1*0.7, 130, 130));
		add(new Turtle(300, 376, -1*0.7, 130, 130));
		add(new Turtle(700, 376, -1*0.7, 130, 130));
		add(new WetTurtle(600, 217, -1*0.7, 130, 130));
		add(new WetTurtle(400, 217, -1*0.7, 130, 130));
		add(new WetTurtle(200, 217, -1*0.7, 130, 130));
		
		//no coin End
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		
		//CarTrucks pos
		//cloesest to the start 649
		//1 to 0.75
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1*0.7, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1*0.7, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1*0.7, 120, 120));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1*0.7, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1*0.7, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1*0.7, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1*0.7, 50, 50));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1*0.7, 200, 200));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1*0.7, 200, 200));
		//car closest to the resting zone
		add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5*0.7, 50, 50));//-5

	
	//changes on the score position 550
		//30 is width&height dimension
		
		
		add(new Life(5,40,500,60));//Life
		add(new Digit(0, 30, 550, 25));
		
		//level display
		
		//add(new Digit(getcurrentLevel(), 30, 550, 450));


	}



	
	/** {@inheritDoc}, Level 1*/
	@Override
	protected void createMusic() {
		// TODO Auto-generated method stub
		super.musicFile= "src/froggermusic/Level123_KomikuTraveltotheHorizon.mp3";

	}

	


	/**
	 * {@inheritDoc}, Level 1.
	 * Animal will be added into Level 1 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(10.666666*2*0.7);
		getlevelAnimal().setLevel(getcurrentLevel());
		getlevelAnimal().setEnd(0);
		getlevelAnimal().setLife(5);
		getlevelAnimal().setCoin(0);
		add(getlevelAnimal());

	}
	
	/**
	 * getter for {@link Level1#currentlevel}
	 * @return current level index in int
	 */
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return this.currentlevel;
	}


	



	

	

	




	

	
}

