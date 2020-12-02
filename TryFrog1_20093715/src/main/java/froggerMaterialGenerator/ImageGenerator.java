package froggerMaterialGenerator;

import javafx.scene.image.Image;

/**
 * Generator for images
 *
 */
public class ImageGenerator {

	public ImageGenerator() {};
	
	/**
	 * generate image
	 * 
	 * @param ImageLink the link of the image to be generated
	 * @param width the width of the image
	 * @param height the height of the image
	 * @return a new generated {@code Image}
	 */
	public Image generate(String ImageLink, int width, int height) {
		Image img = new Image(ImageLink, width,height,true,true);
		return img;
	}
}
