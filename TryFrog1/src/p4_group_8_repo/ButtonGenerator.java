package p4_group_8_repo;

import javafx.scene.control.Button;

/**
 * Helps in generating buttons for a game scene/screen
 * @author User
 *
 */
public interface ButtonGenerator {

	/**
	 * create buttons for the game
	 * @param BtnImageLink The look of the Button
	 * @return a Button
	 */
	public Button createbtn(String BtnImageLink);
}
