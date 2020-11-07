package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Digit extends ImageView{
		
	/*@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}*/
	
	public Digit(int number, int dimension, int xpos, int ypos) {
		setImage( new Image("file:src/froggertextures/"+number+".png", dimension, dimension, true, true));
		setX(xpos);
		setY(ypos);
	}
	
}
