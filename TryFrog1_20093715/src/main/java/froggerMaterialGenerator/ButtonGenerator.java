package froggerMaterialGenerator;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Generator for buttons
 *
 */
public class ButtonGenerator {
	
	public ButtonGenerator() {};
	
	/** generate buttons
	 * 
	 * @param ImageLink the link of the image of the button
	 * @param width the width of the button
	 * @param height the height of the button
	 * @return a new generated {@code Button}
	 */
	public Button generate(String ImageLink, int width, int height) {
		Button btn = new Button();
		btn.setMinSize(width, height);
		btn.setMaxSize(width, height);
		Image img = new Image(ImageLink);
		btn.setGraphic(new ImageView(img));
		return btn;
	}

}
