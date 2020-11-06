package p4_group_8_repo;

public class Level5 extends MyStage{

	private Animal animallevel5;
	private int currentlevel=5;
	
	Level5(){
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
			add(new WetTurtle(700, 376, -1*1.3, 130, 130));
			add(new WetTurtle(600, 217, -1*1.3, 130, 130));
			add(new WetTurtle(400, 217, -1*1.3, 130, 130));
			add(new WetTurtle(200, 217, -1*1.3, 130, 130));
		
			//add(new End(13,96));
			add(new End(13,96,true));//coin
			add(new End(141,96));
			//add(new End(141 + 141-13,96));
			add(new End(141 + 141-13,96,true));
			add(new End(141 + 141-13+141-13+1,96));
			//add(new End(141 + 141-13+141-13+141-13+3,96));
			add(new End(141 + 141-13+141-13+141-13+3,96,true));
			
			animallevel5 = new Animal("file:src/froggertextures/froggerUp.png");
			animallevel5.setLevel(getcurrentLevel());
			animallevel5.setmovementX(10.666666*2*1.3);
			add(animallevel5);
			
			Monster monsterlevel5 = new Monster("file:src/froggertextures/monster1.png",50,0,430,3);
			add(monsterlevel5);
			
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1*1.3, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1*1.3, 120, 120));
			add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1*1.3, 120, 120));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1*1.3, 50, 50));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1*1.3, 200, 200));
			add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1*1.3, 200, 200));
			add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5, 50, 50));

		
		//changes on the score position 550
			add(new Digit(0, 30, 550, 25));
		//add level display	
			add(new Digit(getcurrentLevel(),30,550,450));
			//add level text display
	}

	@Override
	public void setcurrentlevelPoints(int points) {
		// TODO Auto-generated method stub
		getcurrentlevelAnimal().setPoints(points);
	}

	@Override
	public Animal getcurrentlevelAnimal() {
		// TODO Auto-generated method stub
		return animallevel5;
	}

	@Override
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return currentlevel;
	}

}