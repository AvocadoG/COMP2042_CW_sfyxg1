package p4_group_8_repo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StartScreen implements ButtonGenerator {

	private Group start;
	private Button startbtn;
	private Button infobtn;
	private Button exitbtn;
	private TextField username;
	private VBox startscreenVBox;
	private static StartScreen startscreen = new StartScreen("file:src/froggertextures/startscreenfrogger.png");
	
	private StartScreen(){};
	
	private StartScreen(String ImageLink){
		
		/////////creating START SCREEN////////
		start = new Group();
		
		//create buttons
		startbtn = createbtn("file:src/froggertextures/startbtnfrogger.png");
		infobtn = createbtn("file:src/froggertextures/infobtnfrogger.png");
		exitbtn = createbtn("file:src/froggertextures/exitbtnfrogger.png");
		
		/*startbtn = new Button();
		startbtn.setMinSize(140,50);
		Image startbtnImg = new Image("file:src/froggertextures/startbtnfrogger.png");
		startbtn.setGraphic(new ImageView(startbtnImg));
		
		infobtn = new Button();
		infobtn.setMinSize(140,50);
		Image infobtnImg = new Image("file:src/froggertextures/infobtnfrogger.png");
		infobtn.setGraphic(new ImageView(infobtnImg));
		
		exitbtn = new Button();
		exitbtn.setMinSize(140, 50);
		Image exitbtnImg = new Image("file:src/froggertextures/exitbtnfrogger.png");
		exitbtn.setGraphic(new ImageView(exitbtnImg));*/
		
		//username input//
		username = new TextField(null);
		username.setAlignment(Pos.CENTER);
		username.setMinSize(140, 50);
		
		//add buttons to vbox
		startscreenVBox = new VBox(20,username,startbtn,infobtn,exitbtn); 
		startscreenVBox.setPrefWidth(150);
		startscreenVBox.setAlignment(Pos.BASELINE_CENTER);
		startscreenVBox.setPadding(new Insets(10));
		startscreenVBox.setTranslateX(220);
		startscreenVBox.setTranslateY(320);
		
		//add start screen image (composition)
		BackgroundImage startscreenImage = new BackgroundImage(ImageLink);
		
		//add components to Group start
		start.getChildren().addAll(startscreenImage,startscreenVBox);
	}
	
	
	public Group getStartScreen() {
		return start;
	}
	
	public Button getstartbtn() {
		//make sure the button is added into the group
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(1);
	}
	
	public Button getinfobtn() {
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	public Button getexitbtn() {
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(3);
	}
	
	public String getusername() {
		return username.getText();
	}

	@Override
	public Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
	    btn.setMinSize(140,50);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	//SINGLETON DESIGN PATTERN
	public static StartScreen getInstance() {
		return startscreen;
	}
}
