package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * <b>Represents the background images appeared in the game.<br>
 * Used in each game level {@link froggerLevels.Level}, {@link froggerFrames.StartScreen}, {@link froggerFrames.InfoScreen} and {@link froggerHighScore.HighScoreView}.<br></b> 
 *
 */
public class BackgroundImage extends ImageView{
	
	/**
	 * This constructor will create a {@code BackgroundImage} object for a game scene or a game screen.<br>
	 *
	 * @param imageLink The image link of the background image to be created
	 * @param width The width of the background image
	 * @param height The height of the background image
	 */
	public BackgroundImage(String imageLink, double width, double height) {
		setImage(new Image(imageLink, width, height, false, true));

		
	}

}
