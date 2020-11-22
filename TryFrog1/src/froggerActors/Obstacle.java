package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the Obstacles, which are the cars and the trucks on the road, in Frogger Game.<br>
 * {@code Obstacle} is also an {@link froggerActors.Actor}.
 *
 */
public class Obstacle extends Actor{
	
	private double speed;
	/** Image of the {@code Obstacle}*/
	private Image obstacleImg;
	private int imgwidth,imgheight;
	
	
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
		
		this.imgheight=h;
		this.imgwidth=w;
		obstacleImg = createImage(imageLink);
		
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

	/**
	 * to create Images for {@code Obstacle} object.<br>
	 * Used exclusively by {@code Obstacle} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code Obstacle}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}

}
