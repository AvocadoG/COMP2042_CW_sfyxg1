package p4_group_8_repo;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public abstract class MyStage extends World{
	MediaPlayer mediaPlayer;
	
	private Stage stage;
	
	/*@Override
	public void act(long now) {
		
	}*/
	
	public MyStage() {

//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
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
	protected abstract void createMusic();
	protected abstract void setlevelPoints(int points);//set different start points of each level
	protected abstract int getlevelPoints();
	//protected abstract Animal getlevelAnimal();
	//protected abstract int getcurrentLevel();
	protected abstract boolean levelStop();//check if the level is stopped
	protected abstract boolean animalchangeScore();//check if the level animal changescore
	
}
