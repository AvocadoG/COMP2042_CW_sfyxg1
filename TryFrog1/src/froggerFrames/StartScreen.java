package froggerFrames;

import froggerElements.BackgroundImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Represents the Start Screen of the game.<br>
 * <b>Singleton Design Pattern</b> is applied to this class, so there is only <b>one</b> {@code StartScreen} instance throughout the game.
 * @author GohXinYee
 *
 */
public class StartScreen {

	private Group start;
	private Button startbtn;
	private Button infobtn;
	private Button exitbtn;
	private TextField username;
	private VBox startscreenVBox;
	private static StartScreen startscreen;
	
	
	/**default constructor*/
	private StartScreen(){};
	
	/**
	 * This constructor will create a {@code StartScreen} for the game.
	 * The {@code StartScreen} has a username input area, start button, info button and an exit button.
	 * @param ImageLink the link of the background image of {@code StartScreen} 
	 */
	private StartScreen(String ImageLink){
		
		//create a Group as parent
		start = new Group();
		
		//create buttons
		startbtn = createbtn("file:src/froggertextures/startbtnfrogger.png");
		infobtn = createbtn("file:src/froggertextures/infobtnfrogger.png");
		exitbtn = createbtn("file:src/froggertextures/exitbtnfrogger.png");
		
		//create watermark for the game 
		Text watermark = createText("Frogger Game 2020","Phosb___",15);

		//create a TextField to input username
		username = new TextField(null);
		username.setAlignment(Pos.CENTER);
		username.setMinSize(130, 40);
		
		//generate a background image
		BackgroundImage startscreenImage = new BackgroundImage(ImageLink,613,800);
		
		//create a VBox, add all elements into the VBox
		startscreenVBox = new VBox(20,username,startbtn,infobtn,exitbtn,watermark); 
		startscreenVBox.setPrefWidth(150);
		startscreenVBox.setAlignment(Pos.BASELINE_CENTER);
		startscreenVBox.setPadding(new Insets(10));
		startscreenVBox.setTranslateX(220);
		startscreenVBox.setTranslateY(320);
		
		//add elements to parent Group 
		start.getChildren().addAll(startscreenImage,startscreenVBox);
	}
	
	
	/**
	 * to retrieve the {@code StartScreen} instance
	 * @return {@code StartScreen} instance
	 */
	public static StartScreen getInstance() {
		if(startscreen == null) {
			startscreen  = new StartScreen("file:src/froggertextures/startscreenfrogger.png");
		}
		return startscreen;
	}
	
	
	/**
	 * access the parent of all the elements in {@code StartScreen} 
	 * @return {@code Group} the parent element
	 */
	public Group getStartScreenGroup() {
		return start;
	}
	
	/**
	 * retrieve the start button on {@code StartScreen}
	 * @return {@link StartScreen#startbtn} {@code Button} element
	 */
	public Button getstartbtn() {
		//make sure the button is added into the group
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(1);
	}
	
	/**
	 * retrieve the info button on {@code StartScreen}
	 * @return {@link StartScreen#infobtn} {@code Button} element
	 */
	public Button getinfobtn() {
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	/**
	 * retrieve the exit button on {@code StartScreen}
	 * @return {@link StartScreen#exitbtn} {@code Button} element
	 */
	public Button getexitbtn() {
		VBox vbox = (VBox) start.getChildren().get(1);
		return (Button) vbox.getChildren().get(3);
	}
	
	/**
	 * retrieve the username entered by the player
	 * @return the username entered by the player in String format
	 */
	public String getusername() {
		return username.getText();
	}
	
	

	////SCREENGENERATOR INTERFACE IMPLEMENTATION/////
	
	
	private Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
	    btn.setMinSize(140,50);
	    btn.setMaxSize(140,50);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	
	private Text createText(String text, String fonttype, int textsize) {
		// TODO Auto-generated method stub
		Text txt = new Text(text);
		txt.setTextAlignment(TextAlignment.CENTER);
	    txt.setFont(Font.loadFont("file:src/froggerfonts/"+fonttype+".ttf", textsize));
		return txt;
	}
}



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
