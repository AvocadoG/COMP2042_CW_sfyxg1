package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundImage extends ImageView{

	/*@Override
	public void act(long now) {
		
		
	}*/
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 613, 800, false, true));
		
	}

}
