package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Digit extends ImageView{
	int dim;
	Image im1;
	
	/*@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}*/
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/froggertextures/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
