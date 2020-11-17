package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Life extends ImageView{
	
	public Life(int life, int dimension, int xpos, int ypos) {
		setImage( new Image("file:src/froggertextures/life"+life+".png", dimension, dimension, true, true));
		setX(xpos);
		setY(ypos);
	}
}
