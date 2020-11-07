package p4_group_8_repo;

//level 2 - speed up *1.3

public class Level2 extends LevelMaster{

	//private Stage level1stage;
	private Animal animallevel2;
	private int currentlevel=2;
	
	Level2(Animal animal){
		setlevelAnimal(animal);
		createArena();
		super.displaylevel(getcurrentLevel());

	}

	@Override
	public void createArena() {
		// TODO Auto-generated method stub
		
		//add images of logs, turtles, cars(obstacles) and end boxes///
						
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

		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		/*animallevel2 = new Animal("file:src/froggertextures/froggerUp.png");
		animallevel2.setmovementX(10.666666*2);
		animallevel2.setLevel(getcurrentLevel());
		add(animallevel2);*/
		
		
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
		
		//add(new Digit(getcurrentLevel(),30,550,450));


	}

	public void setlevelAnimal(Animal animal) {
		// TODO Auto-generated method stub
		this.animallevel2=animal;
	}

	private Animal getlevelAnimal() {
		// TODO Auto-generated method stub
		return this.animallevel2;
	}

	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return this.currentlevel;
	}
	


	@Override
	public int getlevelPoints() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getPoints();
	}

	@Override
	public boolean levelStop() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getStop();
	}

	@Override
	public boolean animalchangeScore() {
		// TODO Auto-generated method stub
		return getlevelAnimal().changeScore();
	}
	
	@Override
	public void createMusic() {
		// TODO Auto-generated method stub
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";
		super.playMusic(musicFile);
	}

	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(10.666666*2);
		animallevel2.setLevel(getcurrentLevel());
		animallevel2.setEnd(0);
		add(animallevel2);

	}
	




	

	
}

