package p4_group_8_repo;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The base class for all game levels.<br>
 * Template Design Pattern is applied, where LevelMaster class has abstract methods to be implemented differently by its subclasses.
 * @author User
 *
 */
public abstract class LevelMaster extends World{
	
	private MediaPlayer mediaPlayer;
	
	private Stage stage;
	
	/*@Override
	public void act(long now) {
		
	}*/
	
	/**
	 * This constructor will set up the background image for the game level
	 */
	public LevelMaster() {		
		
		BackgroundImage levelbackground = new BackgroundImage("file:src/froggertextures/iKogsKW.png",613,800);
		add(levelbackground);
			
	}
	
	/**
	 * play the music of the game level
	 * @param musicFile the music file to play
	 */
	public void playMusic(String musicFile) {
		//String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * stop the music of the game level
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	/**
	 * display the index of the game level on the game scene
	 * @param level the index of the game level 
	 */
	protected void displaylevel(int level) {
		// TODO Auto-generated method stub
		Text leveldisplay = new Text("Level " + level);
		leveldisplay.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 25));
		leveldisplay.setFill(Color.WHITE);
		leveldisplay.setX(510);
		leveldisplay.setY(470);
		add(leveldisplay);
	}
	
	/**
	 * record the {@code Stage}--should add a link the game level is in
	 * 
	 * @param primaryStage the Stage
	 */
	//bring the primaryStage around
	public void setStage(Stage primaryStage) {
		this.stage=primaryStage;
		System.out.println("Done stage set");
	}
	/**
	 * retrieve the {@code Stage} of the game level
	 * 
	 * @return the Stage
	 */
	public Stage getStage() {
		System.out.println("Done get");
		return this.stage;
	}
	
	//TEMPLATE METHOD DESIGN PATTERN
	/**
	 * to set up an arena or scene for a game level
	 */
	protected abstract void createArena();//different arena for each level
	/**
	 * to generate music for a game level
	 */
	protected abstract void createMusic();//different music for each level
	/**
	 * get the points of Animal at a game level
	 * @return the points of Animal at a game level
	 */
	protected abstract int getlevelPoints();
	/**
	 * to check if a game level is completed
	 * @return true if the level has been completed by the Animal
	 */
	protected abstract boolean levelStop();//check if the level is stopped
	/**
	 * to check if the Animal at a game level has changed score
	 * @return true if the Animal has changed score
	 */
	protected abstract boolean animalchangeScore();//check if the level animal changescore
	/**
	 * to activate the Animal at a game level
	 */
	protected abstract void activateAnimal();
}
