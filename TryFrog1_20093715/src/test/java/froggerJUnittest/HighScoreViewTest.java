package froggerJUnittest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import froggerHighScore.HighScoreView;
import javafx.embed.swing.JFXPanel;
import javafx.scene.text.Text;

/** Test {@link froggerHighScore.HighScoreView} class*/
public class HighScoreViewTest {

	HighScoreView highscoreview;
	int score;
	String winlosestatus;
	JFXPanel jfxpanel = new JFXPanel();
	
	@Before
	public void setUp() throws Exception {
		score=900;
		winlosestatus = "LOSE";
		highscoreview = new HighScoreView(score,winlosestatus);
	}

	
	/** Test that HighScoreView will display the score and win/lose status of current player*/
	@Test
	public void test_HighScoreView_display_currentplayerscore() {

		String display = "YOU LOSE!" + " Your Score: 900";
		assertEquals(highscoreview.getcurrentplayerscorerecord().getText(), display);
	}
	
	/** Test that score record can be added to HighScoreView */
	@Test
	public void test_HighScoreView_addscoretopopupview() {
		
		highscoreview.addscoretopopupview(1, "player 1 --- 60");
		Text fromhighscoreview = (Text) highscoreview.gethighscorevbox().getChildren().get(2);
		
		assertEquals(fromhighscoreview.getText(),"1.   player 1 --- 60");
		
	}

}

