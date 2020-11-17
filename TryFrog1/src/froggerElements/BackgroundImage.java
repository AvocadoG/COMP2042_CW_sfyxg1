package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Represents the background images appeared in the game.<br>
 * Used in each game level, {@link p4_group_8_repo.StartScreen}, {@link p4_group_8_repo.InfoScreen} and High Score Pop Up ({@link p4_group_8_repo.HighScoreView}).<br> 
 *
 */
public class BackgroundImage extends ImageView{

	/*@Override
	public void act(long now) {
		
		
	}*/
	
	/**
	 * This constructor will create a {@code BackgroundImage} object for a game scene or a game screen.<br>
	 * The background image <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#preserveRatioProperty">{@code preserveRatioProperty}</a> is set to false 
	 *  and <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#smoothProperty">{@code smoothProperty}</a> is set to true.<br>
	 * @param imageLink The link to the background image to be created
	 * @param width The width of the background image
	 * @param height The height of the background image
	 */
	public BackgroundImage(String imageLink, double width, double height) {
		setImage(new Image(imageLink, width, height, false, true));

		
	}

}
