package p4_group_8_repo;

public class Level4 extends MyStage{

	private Animal animallevel4;
	private int currentlevel=4;
	
	Level4(){
		createArena();
	}
	
	@Override
	public void createArena() {
		// TODO Auto-generated method stub
		
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
			
			animallevel4 = new Animal("file:src/froggertextures/froggerUp.png");
			animallevel4.setmovementX(10.666666*2);
			animallevel4.setLevel(getcurrentLevel());
			add(animallevel4);
			
			
			Monster monsterlevel4 = new Monster("file:src/froggertextures/monster1.png",50,0,430,2);
			add(monsterlevel4);
			
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
			
			add(new Digit(getcurrentLevel(),30,550,450));
	}

	@Override
	public void setcurrentlevelPoints(int points) {
		// TODO Auto-generated method stub
		getcurrentlevelAnimal().setPoints(points);
	}

	@Override
	public Animal getcurrentlevelAnimal() {
		// TODO Auto-generated method stub
		return animallevel4;
	}

	@Override
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}

}