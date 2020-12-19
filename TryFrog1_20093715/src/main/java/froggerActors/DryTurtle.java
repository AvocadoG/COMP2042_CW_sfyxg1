package froggerActors;

import froggerMaterialGenerator.ImageGenerator;
import javafx.scene.image.Image;

/**
 * <b>Represents the Red Turtle in Frogger Game. It floats on the river and never sinks.<br>
 *</b>
 *
 */
public class DryTurtle extends Turtle{
	
	/** Image for {@code DryTurtle} object*/
	private Image turtleImg1,turtleImg2,turtleImg3;
	
	/**
	 * This constructor will create a {@code DryTurtle} object in the game
	 * @param xpos x position of {@code DryTurtle} object in the game
	 * @param ypos y position of {@code DryTurtle} object in the game
	 * @param s moving speed of {@code DryTurtle} object in the game
	 * @param w width of {@code DryTurtle} object in the game
	 * @param h height of {@code DryTurtle} object in the game
	 */
	public DryTurtle(int xpos, int ypos, double s, int w, int h) {
		
		super(xpos,ypos,s);
		ImageGenerator imggenerator = new ImageGenerator();
		turtleImg1 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation1.png",w,h);
		turtleImg2 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation2.png",w,h);
		turtleImg3 = imggenerator.generate("file:src/main/resources/froggertextures/TurtleAnimation3.png",w,h);

		setImage(turtleImg2);
	}
	
	/**
	 * defines how {@code DryTurtle} will act in the game.<br>
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

}

