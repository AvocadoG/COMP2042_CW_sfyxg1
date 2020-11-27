package froggerElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <b>Represents the Life of {@link froggerAnimal_Actions.Animal} in Frogger Game.</b>
 * @author User
 *
 */
public class Life extends ImageView{
	
	/**
	 * This constructor will create a {@code Life} object for the {@link froggerAnimal_Actions.Animal}'s life.
	 * @param life the number of {@code Life}
	 * @param dimension the size of the {@code Life} to be displayed in the game scene
	 * @param xpos the x position of the {@code Life} in the game scene
	 * @param ypos the y position of the {@code Life} in the game scene
	 */
	public Life(int life, int dimension, int xpos, int ypos) {
		setImage( new Image("file:src/froggertextures/life"+life+".png", dimension, dimension, true, true));
		setX(xpos);
		setY(ypos);
	}
}
