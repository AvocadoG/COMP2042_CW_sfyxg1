package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Represents the background images for the game.<br>
 * Used for each game level, StartScreen, InfoScreen and High Score Pop Up.<br> 
 * @author User
 *
 */
public class BackgroundImage extends ImageView{

	/*@Override
	public void act(long now) {
		
		
	}*/
	
	/**
	 * This constructor will create a Background Image for a game scene or a game screen.<br>
	 * The background image <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#preserveRatioProperty">{@code preserveRatioProperty}</a> is set to false 
	 *  and <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#smoothProperty">{@code smoothProperty}</a> is set to true.<br>
	 * @param imageLink The link to the background image to be created
	 * @param width The width of the background image
	 * @param height The height of the background image
	 */
	public BackgroundImage(String imageLink, int width, int height) {
		setImage(new Image(imageLink, width, height, false, true));

		
	}

}
