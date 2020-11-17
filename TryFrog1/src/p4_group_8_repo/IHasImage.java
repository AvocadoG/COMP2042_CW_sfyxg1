package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Helps in generating images for the game objects {@link p4_group_8_repo.Actor}
 * @author User
 *
 */
public interface ImageGenerator{

	/**
	 * Create images
	 * @param ImageLink the link of the image to be created
	 * @return The created Image
	 */
	Image createImage(String ImageLink);
	
	//createImage(String imagelink){
	//img = new Image("imagelink",width,height,true,true);
}
