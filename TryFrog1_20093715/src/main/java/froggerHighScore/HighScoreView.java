package froggerHighScore;

import froggerElements.BackgroundImage;
import froggerMaterialGenerator.ButtonGenerator;
import froggerMaterialGenerator.TextGenerator;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * <b>Represents how the high score pop up will look like in Frogger Game.</b>
 *
 */
public class HighScoreView {

	/** the HighScoreView group that house all the elements appeared on the {@code HighScoreView}*/
	private Group highscoregroup;
	/** quit button in the HighScoreView to exit the game*/
	private Button quitbtn;
	private Text currentplayerscore;
	/** a vertical box element to arrange the buttons and text elements in the HighScoreView vertically*/
	private VBox highscoreVBox;
	/** background image for HighScoreView*/
	private BackgroundImage highscorebackground;
	
	
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
		
		//create button
		ButtonGenerator btngenerator = new ButtonGenerator();
		quitbtn = btngenerator.generate("file:src/main/resources/froggertextures/quitbtnfrogger.png",100,30);
		
		//create text
		TextGenerator txtgenerator = new TextGenerator();
		currentplayerscore = txtgenerator.generate("YOU " + winlosestatus + "! Your Score: "+ currentplayerpoints,"ChickenPie",25, TextAlignment.CENTER, Color.DARKGOLDENROD);
		Text header = txtgenerator.generate("High Score Display","ChickenPie",25,TextAlignment.CENTER, Color.DARKCYAN);
		
		//create a background image for highscore pop up
		highscorebackground = new BackgroundImage("file:src/main/resources/froggertextures/highscorepopupfrogger.png",400,500);
		
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
		TextGenerator txtgenerator = new TextGenerator();
		Text highscoredata = txtgenerator.generate(rank + ".   " + highscoreinput,"Phosb___",20,TextAlignment.CENTER,Color.CHOCOLATE);
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
	
	/** retrieve current player's score record
	 * @return {@code Text} current player's score record*/
	public Text getcurrentplayerscorerecord() {
		return currentplayerscore;
	}
	
	/** retrieve high score vbox element that arranges text and button elements appear on high score pop up
	 * @return {@code VBox} highscore vbox element */
	public VBox gethighscorevbox() {
		return highscoreVBox;
	}
	
}


