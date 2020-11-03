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

public class HighScoreView {

	private Button quitbtn;
	private Group highscore;
	private VBox highscoreVBox;
	
	HighScoreView(){ };
	HighScoreView(int points){
		
		highscore = new Group();
		Text currentplayerscore = new Text ("YOU WIN!\nYour Score: "+ points);
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
		
		Image highscoreimg = new Image("file:src/froggertextures/highscorepopupfrogger.png");
		ImageView highscoreimgView = new ImageView();
		highscoreimgView.setImage(highscoreimg);
		highscoreimgView.setFitWidth(400);
		highscoreimgView.setFitHeight(500);
		highscoreimgView.setPreserveRatio(false);
		highscoreimgView.setSmooth(true);
		//group
		highscore.getChildren().add(highscoreimgView);
	}
	
	public Group gethighscorepopup() {
		return highscore;
	}
	
	public Button getquitbtn() {
		return quitbtn;
	}
	
	public void addscoretopopupview(int times, String highscoreinput) {
		Text highscoredata = new Text(times + ".   " + highscoreinput);
		highscoredata.setTextAlignment(TextAlignment.LEFT);
		highscoredata.setFill(Color.DARKGREEN);
		highscoredata.setFont(Font.loadFont("file:src/froggerfonts/Phosb___.ttf", 15));
		highscoreVBox.getChildren().add(highscoredata);
	}
	
	public void updatepopupview() {
		quitbtn = createbtn("file:src/froggertextures/quitbtnfrogger.png");
		highscoreVBox.getChildren().add(quitbtn);
		highscore.getChildren().add(highscoreVBox);
	}
	
	//interface method
	public Button createbtn(String BtnImageLink) { 
		Button btn = new Button();
		btn.setMinSize(100, 30);
		btn.setMaxSize(100, 30);
		Image quitbtnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(quitbtnImg));
		return btn;
	}
}
