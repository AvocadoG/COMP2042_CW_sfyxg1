package froggerFrames;

import java.io.File;
import froggerElements.BackgroundImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Represents the Start Screen of Frogger Game.<br>
 * <b>Singleton Design Pattern</b> is applied to this class, so there is only <b>one</b> {@code StartScreen} instance throughout the game.
 * @author GohXinYee
 *
 */
public class StartScreen {
	
	/** the StartScreen group that house all the elements appeared on the {@code StartScreen}*/
	private Group startgroup;
	/**the start button to start the game*/
	private Button startbtn;
	/**the info button to view the {@link froggerFrames.InfoScreen}*/
	private Button infobtn;
	/**the exit button to quit the game*/
	private Button exitbtn;
	/**the text area for player's username input*/
	private TextField username;
	/** a vertical box element in {@code StartScreen} to arrange the text and buttons elements vertically*/
	private VBox startscreenVBox;
	private BackgroundImage startscreenbackground;
	/**music player for startscreen*/
	private MediaPlayer mediaPlayer;
	/** the {@code StartScreen} instance.<br>
	 * declared as <i>static</i> to make sure there is only 1 {@code StartScreen} throughout the game*/
	private static StartScreen startscreen;
	

	
	/**
	 * This constructor will create a {@code StartScreen} for the game.<br>
	 * It has a username input area, start button, info button and an exit button.<br>
	 * The constructor is declared private to ensure that no other classes can create another {@code StartScreen} instance.
     * 
	 * @param ImageLink the link of the background image of {@code StartScreen} 
	 */
	private StartScreen(String ImageLink){
		
		
		//generate a background image
		startscreenbackground = new BackgroundImage(ImageLink,613,800);
		
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
		
		//create a VBox, add all elements into the VBox
		startscreenVBox = new VBox(20,username,startbtn,infobtn,exitbtn,watermark); 
		startscreenVBox.setPrefWidth(150);
		startscreenVBox.setAlignment(Pos.BASELINE_CENTER);
		startscreenVBox.setPadding(new Insets(10));
		startscreenVBox.setTranslateX(220);
		startscreenVBox.setTranslateY(320);
		
		//create a Group as parent		
		startgroup = new Group();
		
		//add elements to parent Group 
		startgroup.getChildren().addAll(startscreenbackground,startscreenVBox);
	}
	
	
	/**
	 * to retrieve the {@code StartScreen} instance<br>
	 * declared as <i>static</i> so that it can be called without an {@code StartScreen} object having to be created beforehand.
	 * @return {@code StartScreen} StartScreen instance
	 */
	public static StartScreen getInstance() {
		if(startscreen == null) {
			startscreen  = new StartScreen("file:src/froggertextures/startscreenfrogger.png");
		}
		return startscreen;
	}
	
	/**to play the music of StartScreen*/
	public void playMusic() {
		
		Media sound = new Media(new File("src/froggermusic/StartScreenMusic_KomikuQuietSaturday.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**to stop the music of StartScreen*/
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	

	/**
	 * To access the group that holds all the elements of an {@code StartScreen} 
	 * @return {@code Group} {@link StartScreen#startgroup}
	 */
	public Group getStartScreenGroup() {
		return startgroup;
	}
	
	/**
	 * retrieve the start button on {@code StartScreen}
	 * @return {@link StartScreen#startbtn} {@code Button} element
	 */
	public Button getstartbtn() {
		//make sure the button is added into the group
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(1);
	}
	
	/**
	 * retrieve the info button on {@code StartScreen}
	 * @return {@link StartScreen#infobtn} {@code Button} element
	 */
	public Button getinfobtn() {
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	/**
	 * retrieve the exit button on {@code StartScreen}
	 * @return {@link StartScreen#exitbtn} {@code Button} element
	 */
	public Button getexitbtn() {
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(3);
	}
	
	/**
	 * retrieve the username entered by the player
	 * @return the {@link StartScreen#username} entered by the player in String format
	 */
	public String getusername() {
		return username.getText();
	}
	
	/**
	 * to create button appeared on the {@code StartScreen}.<br>
	 * Used <b>exclusively</b> by {@code StartScreen} object only.
	 * @param BtnImageLink the link of the image for how the button looks like on the screen
	 * @return a created {@code Button}
	 */
	private Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
	    btn.setMinSize(140,50);
	    btn.setMaxSize(140,50);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	/**
	 * to create text appeared on the {@code StartScreen}.<br>
	 * Used <b>exclusively</b> by {@code StartScreen} object only.
	 * @param text the text to be generated
	 * @param fonttype the font type of the text 
	 * @param textsize the font size of the text
	 * @return a created {@code Text}
	 */
	private Text createText(String text, String fonttype, int textsize) {
		// TODO Auto-generated method stub
		Text txt = new Text(text);
		txt.setTextAlignment(TextAlignment.CENTER);
	    txt.setFont(Font.loadFont("file:src/froggerfonts/"+fonttype+".ttf", textsize));
		return txt;
	}
}

