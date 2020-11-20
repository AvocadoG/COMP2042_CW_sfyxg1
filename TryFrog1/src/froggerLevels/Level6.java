package froggerLevels;


import froggerActors.*;
import froggerAnimal_Actions.Animal;
import froggerElements.*;

public class Level6 extends Level{

	private Animal animallevel6;
	private int currentlevel=6;
	
	public Level6(Animal animal){
		setlevelAnimal(animal);
		createArena();
		createMusic("src/froggermusic/Level456.mp3");
		super.displaylevel(getcurrentLevel());


	}
	
	
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
	
		add(new Monster(50,0,430,2));
		
		//no coin End
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		/*animallevel3 = new Animal("file:src/froggertextures/froggerUp.png");
		animallevel3.setLevel(getcurrentLevel());
		animallevel3.setmovementX(10.666666*2*1.3);*/
		//add(animallevel3);
		
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
		animallevel6.setmovementX(10.666666*2);
		animallevel6.setEnd(0);
		animallevel6.setLife(5);
		animallevel6.setCoin(0);
		add(animallevel6);
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
		this.animallevel6=animal;
	}


	public Animal getlevelAnimal() {
		// TODO Auto-generated method stub
		return animallevel6;
	}


	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}

}