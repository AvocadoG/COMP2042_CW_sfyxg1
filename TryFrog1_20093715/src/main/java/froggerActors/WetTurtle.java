package froggerActors;

import javafx.scene.image.Image;

/**
 * <b>Represents the Green Turtle in Frogger Game.
 * It will sink into the river during the game.<br>
 * {@code WetTurtle} is also an {@link froggerActors.Actor}.</b>
 *
 */
public class WetTurtle extends Actor{
	
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private double speed;
	private int imagewidth,imageheight;
	
	/**determine if {@code WetTurtle} has submerged into the river<br>
	 * <b>true</b> if it has*/
	boolean sunk = false;
	
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
		turtle1 = createImage("file:src/main/resources/froggertextures/TurtleAnimation1.png");
		turtle2 = createImage("file:src/main/resources/froggertextures/TurtleAnimation2Wet.png");
		turtle3 = createImage("file:src/main/resources/froggertextures/TurtleAnimation3Wet.png");
		turtle4 = createImage("file:src/main/resources/froggertextures/TurtleAnimation4Wet.png");
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * defines how {@code WetTurtle} will act in the game.<br>
	 * It will float and sink into the river from time to time.
	 * It will move continuously from either left to right or right to left in the game.
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
	 * checks if {@code WetTurtle} has sunk into the river.<br>
	 * See : {@link WetTurtle#sunk}
	 * @return boolean <b>true</b> if {@code WetTurtle} has sunk into the river.
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	/** Retrieve the moving speed of {@code WetTurtle}
	 *  @return speed of {@code WetTurtle} object*/
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * to create Images for {@code WetTurtle} object.<br>
	 * Used exclusively by {@code WetTurtle} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code WetTurtle}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);	
		return img;
	}
	
}