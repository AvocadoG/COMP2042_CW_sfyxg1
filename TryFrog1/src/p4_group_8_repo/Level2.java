package p4_group_8_repo;

//level 2 - speed up *1.3

public class Level2 extends MyStage{

	//private Stage level1stage;
	private Animal animal;
	private int level=2;
	
	Level2(){
		createArena();
	}

	@Override
	public void createArena() {
		// TODO Auto-generated method stub
		
	//changes on the image link
    //composition relationship
	    BackgroundImage froggerback = new BackgroundImage("file:src/froggertextures/iKogsKW.png");//
	    //add background image to the background stage
		add(froggerback);


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
		add(new WetTurtle(700, 376, -1, 130, 130));
		add(new WetTurtle(600, 217, -1, 130, 130));
		add(new WetTurtle(400, 217, -1, 130, 130));
		add(new WetTurtle(200, 217, -1, 130, 130));

		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		
		animal = new Animal("file:src/froggertextures/froggerUp.png");
		animal.movementX=10.666666*2;
		animal.level=getLevel();
		add(animal);
		
		
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

	
	//changes on the score position 550
		add(new Digit(0, 30, 550, 25));
		
		add(new Digit(getLevel(),30,550,450));


	}


	
	//initialize points for the level
	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		getAnimal().points=points;
	}

	@Override
	public Animal getAnimal() {
		// TODO Auto-generated method stub
		return this.animal;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}

	




	

	
}

