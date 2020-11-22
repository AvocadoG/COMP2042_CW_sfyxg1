package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the logs floating on the river in Frogger Game.<br>
 * {@code Log} is also an {@link froggerActors.Actor}
 */
public class Log extends Actor {

	/** moving speed of {@code Log}*/
	private double speed;
	/** Image of {@code Log}*/
	private Image logImg;
	private int imagewidth,imageheight;
	
	/**
	 * This constructor will create a {@code Log} object for the game
	 * @param imageLink the image link for how the {@code Log} object will be displayed in the game
	 * @param size the size of the {@code Log} object 
	 * @param xpos the x position of the {@code Log} object in the game scene
	 * @param ypos the y position of the {@code Log} object in the game scene
	 * @param s the moving speed of the {@code Log} object in the game
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		
		this.imageheight=size;
		this.imagewidth=size;
		logImg = createImage(imageLink);
		setImage(logImg);
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * Defines how {@code Log} object will behave in the game.<br>
	 * {@code Log} object will move continuously in the game, either from left to right or from right to left.
	 * 
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
	 * to check if the {@code Log} object is moving towards the left.
	 * @return boolean <b>true</b> if the {@code Log} object is moving to the left.
	 */
	public boolean goingLeft() {
		return speed < 0;
	}

	/** to retrieve the moving speed of {@code Log} object*/
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * to create Images for {@code Log} object with display.<br>
	 * Used exclusively by {@code Log} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code Log}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}
