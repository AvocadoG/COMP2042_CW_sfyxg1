package froggerGameActions;

import java.util.ArrayList;

import froggerHighScore.*;
import froggerLevels.Level;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopHighScore implements GameAction{

	private Level level;
	private String currentplayerUsername;
	private String winlosestatus;
	
	public PopHighScore(String winlosestatus, String currentplayerUsername, Level level){
		this.level=level;
		this.currentplayerUsername=currentplayerUsername;
		this.winlosestatus=winlosestatus;
	}
	
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
