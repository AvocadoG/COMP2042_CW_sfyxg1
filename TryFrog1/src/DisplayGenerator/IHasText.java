package DisplayGenerator;

import javafx.scene.text.Text;

/**
 * Helps in generating {@code Text} for a game screen/scene
 * @author User
 *
 */
public interface IHasText {

	/**
	 * generate text
	 * @param text the text to be created
	 * @param fonttype the font type for the text
	 * @param textsize the font size for the text
	 * @return a {@code Text}
	 */
	Text createText(String text, String fonttype, int textsize);
}
