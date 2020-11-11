package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Represents the Logs in Frogger Game
 * @author User
 *
 */
public class Log extends Actor {

	private double speed;
	private Image logImg;
	private int imagewidth,imageheight;
	
	/**
	 * Defines how Log objects will behave in the game.<br>
	 * Log objects will move non-stop in the game, either from left to right or right to left.
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
	 * This constructor will create a Log object for the game
	 * @param imageLink the image link for how the Log object is displayed in the game
	 * @param size the size of the Log object 
	 * @param xpos the x position of the Log object in the game scene
	 * @param ypos the y position of the Log object in the game scene
	 * @param s the moving speed of the Log object in the game
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
	 * to check if the Log object is moving towards the left in the game
	 * @return true if the Log object is moving left.
	 */
	public boolean goingLeft() {
		return speed < 0;
	}

	/**
	 * {@inheritDoc} for the Log objects
	 */
	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}
