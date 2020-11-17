package DisplayGenerator;

import javafx.scene.image.Image;

/**
 * Helps in generating images for the game objects
 * @author User
 *
 */
public interface IHasImage{

	/**
	 * Create image
	 * @param ImageLink the link of the image to be created
	 * @return the created {@code Image}
	 */
	 Image createImage(String ImageLink);
	
	//createImage(String imagelink){
	//img = new Image("imagelink",width,height,true,true);
}
