package p4_group_8_repo;

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
 * Represents how high score pop up will look like in the game.
 * @author User
 *
 */
public class HighScoreView implements ButtonGenerator{

	private Button quitbtn;
	private Group highscoregroup;
	private VBox highscoreVBox;
	
	//HighScoreView(){ };
	
	/**
	 * This constructor will create a HighScoreView object, which defines how the high score pop up will be shown in the game. 
	 * It will display the score of the current player and the high score records of previous players.
	 * @param currentplayerpoints the score of the current player
	 */
	HighScoreView(int currentplayerpoints){
		
		highscoregroup = new Group();
		Text currentplayerscore = new Text ("YOU WIN!\nYour Score: "+ currentplayerpoints);
		currentplayerscore.setTextAlignment(TextAlignment.CENTER);
		currentplayerscore.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 20));
		Text header = new Text ("High Score Display:");
		header.setTextAlignment(TextAlignment.CENTER);
		header.setUnderline(true);
		header.setFill(Color.DARKCYAN);
		header.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 20));
		highscoreVBox = new VBox(10,currentplayerscore,header);//header
		highscoreVBox.setAlignment(Pos.CENTER);
		highscoreVBox.setMinSize(400, 500);//scene size 400x500
		
		BackgroundImage highscorebackground = new BackgroundImage("file:src/froggertextures/highscorepopupfrogger.png",400,500);
		//ImageView highscoreimgView = new ImageView();
		//highscoreimgView.setImage(highscoreimg);
		/*highscoreimgView.setFitWidth(400);
		highscoreimgView.setFitHeight(500);
		highscoreimgView.setPreserveRatio(false);
		highscoreimgView.setSmooth(true);*/
		//group
		highscoregroup.getChildren().add(highscorebackground);
	}
	
	/**
	 * access the parent {@code Group} element of the high score pop up
	 * @return {@code Group} element of high score pop up
	 */
	public Group gethighscorepopup() {
		return highscoregroup;
	}
	
	/**
	 * access the quit Button in the high score pop up
	 * @return quit Button element
	 */
	public Button getquitbtn() {
		return quitbtn;
	}
	
	/**
	 * Input high score record to the high score pop up for display
	 * @param rank The ranking of the high score record
	 * @param highscoreinput The high score record to be added into the high score pop up
	 */
	public void addscoretopopupview(int rank, String highscoreinput) {
		Text highscoredata = new Text(rank + ".   " + highscoreinput);
		highscoredata.setTextAlignment(TextAlignment.LEFT);
		highscoredata.setFill(Color.DARKGREEN);
		highscoredata.setFont(Font.loadFont("file:src/froggerfonts/Phosb___.ttf", 15));
		highscoreVBox.getChildren().add(highscoredata);
	}
	
	/**
	 * To finish up the display of the high score pop up by adding a quit button and put all elements into the parent Group element
	 */
	public void finishup() {
		quitbtn = createbtn("file:src/froggertextures/quitbtnfrogger.png");
		highscoreVBox.getChildren().add(quitbtn);
		highscoregroup.getChildren().add(highscoreVBox);
	}
	
	/**
	 * {@inheritDoc} for the high score pop up
	 * 
	 */
	@Override
	public Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
		btn.setMinSize(100, 30);
		btn.setMaxSize(100, 30);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	
}
