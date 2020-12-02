package froggerActors;

import froggerMaterialGenerator.ImageGenerator;
import javafx.scene.image.Image;

/**
 * <b>Represents the Red Turtle in Frogger Game. It floats on the river and never sinks.<br>
 * {@code Turtle} is also an {@link froggerActors.Actor}.</b>
 *
 */
public class Turtle extends Actor{
	
	/** Image for {@code Turtle} object*/
	private Image turtleImg1,turtleImg2,turtleImg3;
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
		
		ImageGenerator imggenerator = new ImageGenerator();
		turtleImg1 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation1.png",w,h);
		turtleImg2 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation2.png",w,h);
		turtleImg3 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation3.png",w,h);
		
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


	/** Retrieve the moving speed of {@code Turtle}
	 * @return speed of {@code Turtle} object */
	public double getSpeed() {
		return speed;
	}
}

