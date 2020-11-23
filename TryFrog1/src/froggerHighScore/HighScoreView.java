package froggerHighScore;

import froggerElements.BackgroundImage;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Represents how the high score pop up will look like in Frogger Game.
 *
 */
public class HighScoreView {

	/** the HighScoreView group that house all the elements appeared on the {@code HighScoreView}*/
	private Group highscoregroup;
	/** quit button in the HighScoreView to exit the game*/
	private Button quitbtn;
	/** a vertical box element to arrange the buttons and text elements in the HighScoreView vertically*/
	private VBox highscoreVBox;
	
	
	/**
	 * This constructor will create a {@code HighScoreView} object, which defines how the high score pop up will be shown in the game. 
	 * <br>
	 * It will display the score of the current player and the high score records of previous players.
	 * @param currentplayerpoints the score of the current player
	 * @param winlosestatus the game status of current player (win or lose)
	 */
	public HighScoreView(int currentplayerpoints, String winlosestatus){//String winlosestatus
		
		//create a Group as parent
		highscoregroup = new Group();
		
		//ButtonGenerator bg = new ButtonGenerator(width,height);
		//quitbtn = bg.generatebtn("");
		//create a quit button
		quitbtn = createbtn("file:src/froggertextures/quitbtnfrogger.png");

		
		//TestGenerator tg = new TextGenerator("font",size, textalignment);
		//currentplayerscore = tg.generatetxt("text");
		//create a text to display current player's score
		//("You " + winlosestatus + "\nYourScore: " + currentplayerpoints);
		Text currentplayerscore = createText("YOU " + winlosestatus + "\nYour Score: "+ currentplayerpoints,"ChickenPie",20);
		
		//create a heading for HighScore
		Text header = createText("High Score Display","ChickenPie",20);
		header.setUnderline(true);
		header.setFill(Color.DARKCYAN);
		
		//create a background image for highscore pop up
		BackgroundImage highscorebackground = new BackgroundImage("file:src/froggertextures/highscorepopupfrogger.png",400,500);
		
		//create a VBox and add in the elements
		highscoreVBox = new VBox(10,currentplayerscore,header);
		highscoreVBox.setAlignment(Pos.CENTER);
		highscoreVBox.setMinSize(400, 500);
		
		//add elements into parent Group
		highscoregroup.getChildren().add(highscorebackground);
	}
	
	
	/**
	 * Add high score record to the display of the high score pop up in the game
	 * @param rank The ranking of the high score record
	 * @param highscoreinput The high score record to be added into the high score pop up
	 */
	public void addscoretopopupview(int rank, String highscoreinput) {
		Text highscoredata = createText(rank + ".   " + highscoreinput,"Phosb___",15);
		highscoredata.setFill(Color.DARKGREEN);
		highscoreVBox.getChildren().add(highscoredata);
	}


	/**
	 * Finish up the display of the high score pop up.<br>
	 */
	public void finishup() {
		highscoreVBox.getChildren().add(quitbtn);
		highscoregroup.getChildren().add(highscoreVBox);
	}


	/**
	 * access the group that holds all the elements in the high score pop up
	 * @return {@code Group} {@link HighScoreView#highscoregroup}
	 */
	public Group gethighscorepopup() {
		return highscoregroup;
	}
	
	/**
	 * access the quit button in the high score pop up
	 * @return {@link HighScoreView#quitbtn} Button element
	 */
	public Button getquitbtn() {
		return quitbtn;
	}
	

	
	/**
	 * to create button appeared on the {@code HighScoreView}.<br>
	 * Used <b>exclusively</b> by {@code HighScoreView} object only.
	 * @param BtnImageLink the link of the image for how the button looks like on the screen
	 * @return a created {@code Button}
	 */
	private Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
		btn.setMinSize(100, 30);
		btn.setMaxSize(100, 30);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
	
		return btn;
	}

	
	/**
	 * to create text appeared on the {@code HighScoreView}.<br>
	 * Used <b>exclusively</b> by {@code HighScoreView} object only.
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


/*Text currentplayerscore = new Text ("YOU WIN!\nYour Score: "+ currentplayerpoints);
currentplayerscore.setTextAlignment(TextAlignment.CENTER);
currentplayerscore.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 20));*/

