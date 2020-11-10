package p4_group_8_repo;

import javafx.scene.image.Image;

public interface ImageGenerator{

	/**
	 * Called when generating images
	 * @param ImageLink the link of the images to be created
	 * @return The created Image
	 */
	Image createImage(String ImageLink);
	
	//createImage(String imagelink){
	//img = new Image("imagelink",width,height,true,true);
}
