package froggerActors;

import javafx.scene.image.Image;

/**
 * <b>Represents the logs floating on the river in Frogger Game.<br>
 * 2 types of logs : Log with bombs and Log without bombs. If Animal jumps onto logs with bombs, it will be killed, drown into the river and die.
 * {@code Log} is also an {@link froggerActors.Actor}</b>
 */
public class Log extends Actor {

	/** moving speed of {@code Log}*/
	private double speed;
	/** Image of {@code Log}*/
	private Image logImg;
	private int imagewidth,imageheight;
	/** determine if {@code Log} has bombs*/
	private boolean hasbomb;
	
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
	 * This constructor will create a {@code Log} object with bomb for the game
	 * @param imageLink the image link for how the {@code Log} object will be displayed in the game
	 * @param size the size of the {@code Log} object 
	 * @param xpos the x position of the {@code Log} object in the game scene
	 * @param ypos the y position of the {@code Log} object in the game scene
	 * @param s the moving speed of the {@code Log} object in the game
	 * @param bomb whether the {@code Log} has bombs
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s, boolean bomb) {
		
		this(imageLink,size,xpos,ypos,s);
		hasbomb=bomb;
		
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
	 * Checks if the {@code Log} object is moving towards the left.
	 * @return boolean <b>true</b> if the {@code Log} object is moving to the left.
	 */
	public boolean goingLeft() {
		return speed < 0;
	}
	
	/**
	 * Checks if the {@code Log} object has bombs
	 * @return boolean <b>true</b> if the {@code Log} object has bombs.
	 * see also {@link Log#hasbomb}
	 */
	public boolean hasbomb() {
		return hasbomb;
	}

	/** Retrieves the moving speed of {@code Log} object
	 * @return speed of {@code Log} object*/
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
