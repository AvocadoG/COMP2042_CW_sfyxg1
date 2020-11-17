package DisplayGenerator;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonDisplayGenerator implements DisplayGenerator{

	private int btnwidth,btnheight;
	
	public ButtonDisplayGenerator(int btnwidth, int btnheight){
		this.btnwidth=btnwidth;
		this.btnheight=btnheight;
	}
	
	public Button generatebtn(String imagelink) {
		
		Button btn = new Button();
		btn.setMinSize(btnwidth, btnheight);
		btn.setMaxSize(btnwidth, btnheight);
		Image btnimg = new Image(imagelink);
		btn.setGraphic(new ImageView(btnimg));
		return btn;
		
	}
}
