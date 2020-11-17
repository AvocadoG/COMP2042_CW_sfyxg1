package DisplayGenerator;

import javafx.scene.image.Image;

public class ImageDisplayGenerator {

	private int imgwidth;
	private int imgheight;
	private boolean preserveratio;
	private boolean smooth;
	
	public ImageDisplayGenerator(int width, int height, boolean preserveratio, boolean smooth){
		this.imgheight=height;
		this.imgwidth=width;
		this.preserveratio=preserveratio;
		this.smooth=smooth;
	}
	
	public Image generateimg(String imagelink) {
		Image img = new Image(imagelink,imgwidth,imgheight,preserveratio,smooth);
		return img;
		
	}
}
