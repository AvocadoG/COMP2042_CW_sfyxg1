package froggerLevels;

import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;

/**
 * Level 5 of Frogger Game. <br>
 * At this level, the game speed is increased. The {@link p4_group_8_repo.Monster} is moving even faster than Level 4.
 * It is a combination of Level 3 and Level 4 to challenge the player.
 * @author User
 *
 */
public class Level5 extends Level{

	private Animal animallevel5;
	private int currentlevel=5;
	
	/**
	 * Create a {@code Level5} for the game with an {@link p4_group_8_repo.Animal} ready but not yet activated.
	 * Game arena for {@code Level5} will be set up, the level# will be displayed.
	 * @param animal the {@code Animal} to be inserted into the {@code Level5} 
	 */
	public Level5(Animal animal){
		setlevelAnimal(animal);
		createArena();
		createMusic("src/froggermusic/Level456.mp3");
		super.displaylevel(getcurrentLevel());


	}
	
	/**
	 * {@inheritDoc}, Level 5.<br>
	 * relevant {@link p4_group_8_repo.Actor}s such as {@link p4_group_8_repo.Obstacle}, {@link p4_group_8_repo.Turtle},  {@link p4_group_8_repo.WetTurtle},  {@link p4_group_8_repo.Log} ,  {@link p4_group_8_repo.End} will be added to the {@code Level5} Game Arena
	 * <br>Different from Level 1,2,3,4, {@code Level5} all game objects move even faster, there is a Monster added and all WetTurtles only. The End destinations come with coins. 
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub

		//add images of logs, turtles, cars(obstacles) and end boxes///
							
			//HOW TO REMOVE
			add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75*1.3));
			add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75*1.3));

			//redundant
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
			
			/*animallevel5 = new Animal("file:src/froggertextures/froggerUp.png");
			animallevel5.setLevel(getcurrentLevel());
			animallevel5.setmovementX(10.666666*2*1.3);*/
			//add(animallevel5);
			
			/*Monster monsterlevel5 = new Monster(50,0,430,3);
			add(monsterlevel5);*/
			
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
		//changes on the score position 550
			//add(new Digit(0, 30, 550, 25));
		//add level display	
			//add(new Digit(getcurrentLevel(),30,550,450));
			//add level text display
	}


	@Override
	public void createMusic(String musicFile) {
		// TODO Auto-generated method stub
		super.musicFile= musicFile;
	}

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
	

	@Override
	public void activateAnimal() {
		getlevelAnimal().setLevel(getcurrentLevel());
		animallevel5.setmovementX(10.666666*2*1.3);
		animallevel5.setEnd(0);
		animallevel5.setLife(5);
		animallevel5.setCoin(0);
		add(animallevel5);

	}
	
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


	
	public void setlevelAnimal(Animal animal) {
		// TODO Auto-generated method stub
		this.animallevel5=animal;
	}


	public Animal getlevelAnimal() {
		// TODO Auto-generated method stub
		return animallevel5;
	}


	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}

}
