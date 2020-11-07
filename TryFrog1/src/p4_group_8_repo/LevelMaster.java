package p4_group_8_repo;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public abstract class LevelMaster extends World{
	MediaPlayer mediaPlayer;
	
	private Stage stage;
	
	/*@Override
	public void act(long now) {
		
	}*/
	
	public LevelMaster() {		
		
		BackgroundImage levelbackground = new BackgroundImage("file:src/froggertextures/iKogsKW.png",613,800);
		add(levelbackground);
			
	}
	
	public void playMusic(String musicFile) {
		//String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public void displaylevel(int level) {
		// TODO Auto-generated method stub
		Text leveldisplay = new Text("Level " + level);
		leveldisplay.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 25));
		leveldisplay.setFill(Color.WHITE);
		leveldisplay.setX(510);
		leveldisplay.setY(470);
		add(leveldisplay);
	}
	
	//bring the primaryStage around
	public void setStage(Stage primaryStage) {
		this.stage=primaryStage;
		System.out.println("Done stage set");
	}
	public Stage getStage() {
		System.out.println("Done get");
		return this.stage;
	}
	
	//TEMPLATE METHOD DESIGN PATTERN
	protected abstract void createArena();//different arena for each level
	protected abstract void createMusic();//different music for each level
	protected abstract int getlevelPoints();
	protected abstract boolean levelStop();//check if the level is stopped
	protected abstract boolean animalchangeScore();//check if the level animal changescore
	protected abstract void activateAnimal();
}
