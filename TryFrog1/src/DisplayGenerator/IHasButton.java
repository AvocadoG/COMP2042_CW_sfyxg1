package DisplayGenerator;

import javafx.scene.control.Button;

/**
 * Helps in generating buttons for a game scene/screen
 * @author User
 *
 */
public interface IHasButton {

	/**
	 * create button
	 * @param BtnImageLink The look of the button
	 * @return a {@code Button}
	 */
	public Button createbtn(String BtnImageLink);
}
