package DisplayGenerator;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextDisplayGenerator implements DisplayGenerator{

	private String font;
	private int size;
	private TextAlignment alignment;
	
	public TextDisplayGenerator(String font, int size, TextAlignment alignment){
		this.font=font;
		this.size=size;
		this.alignment=alignment;
	}
	
	public Text generatetxt(String txt) {
		Text text = new Text(txt);
	    text.setFont(Font.loadFont("file:src/froggerfonts/"+font+".ttf", size));
	    text.setTextAlignment(alignment);
		return text;		
	}
}
