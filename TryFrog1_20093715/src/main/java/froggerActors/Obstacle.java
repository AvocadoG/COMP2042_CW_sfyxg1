package froggerActors;

import froggerMaterialGenerator.ImageGenerator;
import javafx.scene.image.Image;

/**
 * <b>Represents the Obstacles, which are the cars and the trucks on the road, in Frogger Game.<br>
 * {@code Obstacle} is also an {@link froggerActors.Actor}.</b>
 *
 */
public class Obstacle extends Actor{
	
	private double speed;
	/** Image of the {@code Obstacle}*/
	private Image obstacleImg;
	
	
	/**
	 * This constructor will create an {@code Obstacle} object in the game.
	 * @param imageLink the image link for how {@code Obstacle} object looks like in the game
	 * @param xpos x position of {@code Obstacle} object in the game
	 * @param ypos y position of {@code Obstacle} object in the game
	 * @param s moving speed of {@code Obstacle} object in the game
	 * @param w width of {@code Obstacle}
	 * @param h height of {@code Obstacle}
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		
		ImageGenerator imggenerator = new ImageGenerator();
		obstacleImg = imggenerator.generate(imageLink,w,h);
		
		setImage(obstacleImg);
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	
	/**
	 * Defines how {@code Obstacle} behaves in the game.<br>
	 * It will move continuously in the game, either from left to right or from right to left.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

}
