package froggerMaterialGenerator;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Generator for text
 *
 */
public class TextGenerator {

	public TextGenerator() {};
	
	/**
	 * generate text
	 * 
	 * @param text the text content to be generated
	 * @param font the fonttype of the text
	 * @param fontsize the fontsize of the text
	 * @param alignment the text alignment
	 * @param color the color of the text
	 * @return a new generated {@code Text}
	 */
	public Text generate(String text, String font, int fontsize, TextAlignment alignment, Color color) {
		
		Text txt = new Text(text);
	    txt.setTextAlignment(alignment);
	    txt.setFill(color);
	    txt.setFont(Font.loadFont("file:src/main/resources/froggerfonts/"+font+".ttf", fontsize));
		return txt;
	}
}
