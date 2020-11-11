package p4_group_8_repo;


//change scoring system, move up +5 points
//reach empty END +10 points
//reach empty END with bonus coin +20 points
//hit by the obstacles / sink into the river / monster -10points

//level1 - speed down (0.75 down 0.5, -2 down -1, turtle -1 down -0.5) add Level Digit, set animal level & mX
//level2 - original speed
//level3 - speed up *1.3, End with a Coin - if get it extra 10points
//level4 - original speed, add A monster (8seconds speed) at resting zone - if hit -10points, sent back to ori position
//level5 - speed up *1.3, monster speed up too (4seconds)

//add Level display on screen

/**
 * Level 1 of the Frogger Game. The game speed of this level is rather slow to give the Player an easier start.
 * @author User
 *
 */
public class Level1 extends LevelMaster{

	//private Stage level1stage;
	private Animal animallevel1;
	private int currentlevel=1;
	
	/**
	 * Create a Level1 object for the game with an Animal ready but not yet activated
	 * @param animal the Animal to be inserted into the Level 1
	 */
	Level1(Animal animal){
		setlevelAnimal(animal);
		createArena();
		super.displaylevel(getcurrentLevel());
	}

	/**
	 * {@inheritDoc}, Level 1.<br>
	 * relevant Actor class objects such as {@link p4_group_8_repo.Obstacle}, {@link p4_group_8_repo.Turtle},  {@link p4_group_8_repo.WetTurtle},  {@link p4_group_8_repo.Log} ,  {@link p4_group_8_repo.End} will be added to the Level1 Game Arena
	 */
	@Override
	protected void createArena() {
		// TODO Auto-generated method stub
		
		//add images of logs, turtles, cars(obstacles) and end boxes///
						
		//1st row 166, 2nd 276, 3rd 329
		//change speed 0.75 to 0.5
		add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.5));///
		add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.5));
		add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.5));
		
		
		//0.75 to 0.5, -2 to -1
		add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -1));//-2
		add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -1));
		add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.5));
		add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.5));
		add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.5));
	
		//turtle pos
		//nearer to the resting zone is 376
		//nearer to the end is 217
		//-1 to -0.5
		add(new Turtle(500, 376, -0.5, 130, 130));
		add(new Turtle(300, 376, -0.5, 130, 130));
		add(new WetTurtle(700, 376, -0.5, 130, 130));
		add(new WetTurtle(600, 217, -0.5, 130, 130));
		add(new WetTurtle(400, 217, -0.5, 130, 130));
		add(new WetTurtle(200, 217, -0.5, 130, 130));
		
	
		add(new End(13,96,false));
		add(new End(141,96,false));
		add(new End(141 + 141-13,96,false));
		add(new End(141 + 141-13+141-13+1,96,false));
		add(new End(141 + 141-13+141-13+141-13+3,96,false));
		
		/*animallevel1 = new Animal("file:src/froggertextures/froggerUp.png");
		animallevel1.setmovementX(14.222333);
		animallevel1.setLevel(getcurrentLevel());
		add(animallevel1);*/
		
		/*
		Monster monster = new Monster("file:src/p4_group_8_repo/File_001.png");
		add(monster);*/
		
		
		//CarTrucks pos
		//cloesest to the start 649
		//1 to 0.75
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 0.75, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 0.75, 120, 120));
		add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 0.75, 120, 120));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -0.75, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -0.75, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -0.75, 50, 50));
		add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -0.75, 50, 50));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 0.75, 200, 200));
		add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 0.75, 200, 200));
		//car closest to the resting zone
		add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -3, 50, 50));//-5

	
	//changes on the score position 550
		//30 is width&height dimension
		add(new Digit(0, 30, 550, 25));
		
		//level display
		
		//add(new Digit(getcurrentLevel(), 30, 550, 450));


	}


	/**
	 * setter for {@link Level1#animallevel1}
	 * @param animal Animal to be set for Level 1
	 */
	public void setlevelAnimal(Animal animal) {
		// TODO Auto-generated method stub
		this.animallevel1=animal;
	}

	/**
	 * 
	 * @return animal of Level1
	 */
	public Animal getlevelAnimal() {
		// TODO Auto-generated method stub
		return this.animallevel1;
	}

	/**
	 * getter for {@link Level1#currentlevel}
	 * @return current level index
	 */
	public int getcurrentLevel() {
		// TODO Auto-generated method stub
		return this.currentlevel;
	}
	

	/**
	 * {@inheritDoc}, Level 1
	 * 
	 */
	@Override
	public int getlevelPoints() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getPoints();
	}

	/**
	 * {@inheritDoc}
	 * @return true if Animal has completed Level 1
	 */
	@Override
	public boolean levelStop() {
		// TODO Auto-generated method stub
		return getlevelAnimal().getStop();
	}

	/**
	 * {@inheritDoc}
	 * @return true if Animal's score is changed, at Level 1
	 */
	@Override
	public boolean animalchangeScore() {
		// TODO Auto-generated method stub
		return getlevelAnimal().changeScore();
	}

	/**
	 * {@inheritDoc}, Level 1
	 */
	@Override
	public void createMusic() {
		// TODO Auto-generated method stub
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";
		super.playMusic(musicFile);
	}

	/**
	 * {@inheritDoc}, Level 1.
	 * Animal will be added into Level 1 game Arena
	 */
	@Override
	public void activateAnimal() {
		getlevelAnimal().setmovementX(14.222333);
		animallevel1.setLevel(getcurrentLevel());
		animallevel1.setEnd(0);
		add(animallevel1);

	}

	




	

	
}

