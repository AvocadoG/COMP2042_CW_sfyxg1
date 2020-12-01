package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <b>Represents the game points of {@link froggerAnimal_Actions.Animal} in Frogger Game.</b>
 *
 */
public class Digit extends ImageView{
		
	
	/**
	 * This constructor will create a {@code Digit} object for the {@link froggerAnimal_Actions.Animal}'s game points.
	 * @param number the value of the {@code Digit} to be created
	 * @param dimension the size of the {@code Digit} to be displayed in the game scene
	 * @param xpos the x position of the {@code Digit} in the game scene
	 * @param ypos the y position of the {@code Digit} in the game scene
	 */
	public Digit(int number, int dimension, int xpos, int ypos) {
		setImage( new Image("file:src/main/resources/froggertextures/"+number+".png", dimension, dimension, true, true));
		setX(xpos);
		setY(ypos);
	}
	
}
