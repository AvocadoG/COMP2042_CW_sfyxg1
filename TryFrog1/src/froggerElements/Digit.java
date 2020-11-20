package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the game points of {@link p4_group_8_repo.Animal}
 *
 */
public class Digit extends ImageView{
		
	/*@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}*/
	
	/**
	 * This constructor will create a {@code Digit} object for the {@link p4_group_8_repo.Animal}'s game points.
	 * @param number the value of the {@code Digit} to be created
	 * @param dimension the size of the {@code Digit} to be displayed in the game scene
	 * @param xpos the x position of the {@code Digit} in the game scene
	 * @param ypos the y position of the {@code Digit} in the game scene
	 */
	public Digit(int number, int dimension, int xpos, int ypos) {
		setImage( new Image("file:src/froggertextures/"+number+".png", dimension, dimension, true, true));
		setX(xpos);
		setY(ypos);
	}
	
}