package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the Red Turtle in Frogger Game. It floats on the river and never sinks.<br>
 * {@code Turtle} is also an {@link froggerActors.Actor}.
 *
 */
public class Turtle extends Actor{
	
	/** Image for {@code Turtle} object*/
	private Image turtleImg1,turtleImg2,turtleImg3;
	private int imagewidth, imageheight;
	private double speed;
	
	/**
	 * This constructor will create a {@code Turtle} object in the game
	 * @param xpos x position of {@code Turtle} object in the game
	 * @param ypos y position of {@code Turtle} object in the game
	 * @param s moving speed of {@code Turtle} object in the game
	 * @param w width of {@code Turtle} object in the game
	 * @param h height of {@code Turtle} object in the game
	 */
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		
		this.imageheight=h;
		this.imagewidth=w;
		turtleImg1 = createImage("file:src/froggertextures/TurtleAnimation1.png");
		turtleImg2 = createImage("file:src/froggertextures/TurtleAnimation2.png");
		turtleImg3 = createImage("file:src/froggertextures/TurtleAnimation3.png");
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtleImg2);
	}
	
	/**
	 * defines how {@code Turtle} will act in the game.<br>
	 * It will move continuously, either from left to right or from right to left with animations.
	 */
	@Override
	public void act(long now) {
	
				if (now/900000000  % 3 ==0) {
					setImage(turtleImg2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtleImg1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtleImg3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}


	/** Retrieve the moving speed of {@code Turtle}*/
	public double getSpeed() {
		return speed;
	}

	/**
	 * to create Images for {@code Turtle} object.<br>
	 * Used exclusively by {@code Turtle} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code Turtle}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}

