package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the Green Turtle in Frogger Game.<br>
 * Green Turtle / {@code WetTurtle} will sink into the river during the game.
 *
 */
public class WetTurtle extends Actor{
	
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private double speed;
	private int imagewidth,imageheight;
	
	/**determine if {@code WetTurtle} has submerged into the river*/
	boolean sunk = false;
	
	/**
	 * defines how {@code WetTurtle} will act in the game.<br>
	 * It will initially float on the river, and then slowly sink into the river.
	 * It will move from either left to right / right to left in the game.
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * This constructor will create a {@code WetTurtle} object in the game.
	 * @param xpos x position of {@code WetTurtle} object in the game
	 * @param ypos y position of {@code WetTurtle} object in the game
	 * @param s moving speed of {@code WetTurtle} object in the game
	 * @param w width of {@code WetTurtle} object in the game
	 * @param h height of {@code WetTurtle} object in the game
	 */
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		
		this.imagewidth=w;
		this.imageheight=h;
		turtle1 = createImage("file:src/froggertextures/TurtleAnimation1.png");
		turtle2 = createImage("file:src/froggertextures/TurtleAnimation2Wet.png");
		turtle3 = createImage("file:src/froggertextures/TurtleAnimation3Wet.png");
		turtle4 = createImage("file:src/froggertextures/TurtleAnimation4Wet.png");
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * checks if {@code WetTurtle} has sunk into the river.<br>
	 * See : {@link WetTurtle#sunk}
	 * @return boolean <b>true</b> if {@code WetTurtle} has sunk into the river.
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	
	public double getSpeed() {
		return speed;
	}

	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);	
		return img;
	}
	
}

//turtle1 = new Image("file:src/froggertextures/TurtleAnimation1.png", w, h, true, true);
		//turtle2 = new Image("file:src/froggertextures/TurtleAnimation2Wet.png", w, h, true, true);
		//turtle3 = new Image("file:src/froggertextures/TurtleAnimation3Wet.png", w, h, true, true);
		//turtle4 = new Image("file:src/froggertextures/TurtleAnimation4Wet.png", w, h, true, true);