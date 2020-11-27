package froggerGameActions;

import java.util.ArrayList;

import froggerHighScore.*;
import froggerLevels.Level;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <b>Represents one of the Game Actions.<br>
 * Retrieves and Pops the High Score of Frogger Game.</b>
 * @author GohXinYee
 *
 */
public class PopHighScore implements GameAction{

	/** the level of the current player when high score is popped*/
	private Level level;
	/** username of the current player*/
	private String currentplayerUsername;
	/** the game status of the current player (win or lose)*/
	private String winlosestatus;
	
	/**
	 * This constructor will create a {@code PopHighScore} object.
	 * @param winlosestatus value for {@link PopHighScore#winlosestatus}
	 * @param currentplayerUsername value for {@link PopHighScore#currentplayerUsername}
	 * @param level value for {@link PopHighScore#level}
	 */
	public PopHighScore(String winlosestatus, String currentplayerUsername, Level level){
		this.level=level;
		this.currentplayerUsername=currentplayerUsername;
		this.winlosestatus=winlosestatus;
	}
	
	/**
	 * pop the HighScore that shows <b>the Top5 high score records</b> and the current player's score record
	 */
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
		//GENERATE HIGHSCORE POP UP//
    	//MVC PATTERN//
 		HighScoreModel highscoremodel = new HighScoreModel(currentplayerUsername,level.getlevelPoints());
		HighScoreView highscoreview = new HighScoreView(level.getlevelPoints(), winlosestatus);
 		HighScoreController highscorecontroller = new HighScoreController(highscoremodel,highscoreview);
 		
 		//retrieving high score records from file and add it to an ArrayList
		ArrayList<String> scorelist = highscorecontroller.retrievingHighScore();
		
		//display up to top 5 of high score
		int rank=1;
		for (String currenthighscore : scorelist) {
			if(rank<6) {
				highscorecontroller.updateView(rank,currenthighscore);
				rank++;
			}
			else {
				break;
			}
		}
		//finish up the high score pop up
		highscoreview.finishup();
		
	
		//create Scene and Stage for HighScore pop up
		Scene highscorescene = new Scene(highscoreview.gethighscorepopup(),400,500);
		Stage highscorestage = new Stage();
		highscorestage.setTitle("Game End");
		highscorestage.initModality(Modality.APPLICATION_MODAL);
		highscorestage.setScene(highscorescene);
		highscorestage.show();
		
		//SET HIGHSCORE POP UP BUTTON ACTIONS//
		highscoreview.getquitbtn().setOnMouseClicked(event -> {
		highscorestage.close();
		Platform.exit();
	
		});
	
		highscorestage.setOnCloseRequest(event -> {
		Platform.exit();
		});
	}
	
	

}
