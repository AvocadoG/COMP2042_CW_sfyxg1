package froggerLevels;

import froggerActors.*;
import froggerElements.BackgroundImage;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;




/*
 * Level1 - 0.6 speed, original , car -3
 * Level2 - original speed, original, car -5
 * Level3 - original speed, add Coin function, car -5
 * Level4 - 1.3 speed, original, car -7
 * Level5 - 1.3 speed, add Coin function, car-7
 * 
 * Level6 - original speed, add Monster(2), car -5
 * Level7 - original speed, add Monster(3), all Wet Turtles, car -5
 * Level8 - 1.3 speed, add Monster(4), all Wet Turtles, car -7
 * Level9 - 1.3 speed, add Monster(4), all Wet Turtles, add Coin, car -7
 * Level10 - 1.8 speed, add Monster(5), all Wet Turtles, car -7
 */



/**
 * The base class for all game levels.<br>
 * It is not a playable game level. It sets up a basic structure for game levels and allows functions like pausing, playing/stoping music at the level.<br>
 * {@code LevelMaster} will have no game objects ({@code Actor}) but only a background image.<br>
 * <b>Template Design Pattern</b> is applied, where {@code LevelMaster} has <i>abstract</i> methods to be implemented differently by its subclasses, which are the game levels.
 * @author User
 *
 */
public abstract class Level extends World{
	
	private MediaPlayer mediaPlayer;
	protected String musicFile;
	private Stage stage;
	
	/**determine if a game level is paused*/
	private boolean pause=true;
	
	/*@Override
	public void act(long now) {
		
	}*/
	
	
	/**This constructor will generate a {@code LevelMaster} that sets up a structure for a game level<br> */
	public Level() {		
		
		
		//add background image for the game level
		//all game levels have the same background image
		BackgroundImage levelbackground = new BackgroundImage("file:src/froggertextures/iKogsKW.png",605,800);
		add(levelbackground);
		
		//add a pause button to the game level
		//all game levels will have a pause button
		Button pausebtn = createbtn("file:src/froggertextures/pausebtnfrogger.png",40,40);
		pausebtn.setLayoutX(550);
		pausebtn.setLayoutY(60);
		add(pausebtn);
		
		//set pause button on-clicked action
		//if pause button is clicked, game is paused and music is stopped
		//clicked again, game and music are resumed
		pausebtn.setOnMouseClicked(event -> {
			if(pause) {
				this.pause(pause);
				this.stopMusic();
				pause=false;
			}
			else {
				this.pause(pause);
				this.playMusic();
				pause=true;
			}
		});
			
	}
	
	
	/**
	 * play the music of a game level
	 * @param musicFile the music to play
	 */
	public void playMusic() {
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * stop the music of a game level
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	
	/**
	 * display the level# of a game level.<br>
	 * Example: Game Level 1, # = 1
	 * @param level the # of the game level 
	 */
	//called by its subclasses only
	protected void displaylevel(int level) {
		// TODO Auto-generated method stub
		Text leveldisplay = new Text("Level "+level);
		leveldisplay.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 25));
		leveldisplay.setFill(Color.WHITE);
		leveldisplay.setX(510);
		leveldisplay.setY(470);
		add(leveldisplay);
	}
	
	
	private Button createbtn(String imagelink, int width, int height) {
		Button btn = new Button();
		btn.setMinSize(width, height);
		btn.setMaxSize(width, height);
		btn.setGraphic(new ImageView(new Image(imagelink)));
		return btn;
	}
	

	/**
	 * setter method for {@link Level#stage}<br>
	 * record the <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html">{@code Stage}</a> 
	 * a game level is in.<br>
	 * used here to pass the {@code primaryStage} of Frogger Game from one {@code Level} to another {@code Level}.
	 * @param primaryStage {@code Stage} of the game level
	 */
	public void setStage(Stage primaryStage) {
		this.stage=primaryStage;
		System.out.println("Done stage set");
	}
	
	/**
	 * getter method for {@link Level#stage}<br>
	 * retrieve the {@code Stage} of a game level is in.<br>
	 * used here to retrieve and pass the {@code Stage} from one game {@code Level} to another.<br>
	 * See : {@link Level#setStage(Stage)}
	 * @return {@code Stage}
	 */
	public Stage getStage() {
		System.out.println("Done get");
		return this.stage;
	}
	
	/**
	 * update the score displayed in the arena of a game level  
	 * @param n
	 */
	/*public void updateScore(int n) {
    	int shift = 0;
    	
    	if(n<100) {//if points has 2 digits
        	while (n > 0) {
        		  int d = n / 10;
        		  int k = n - d * 10;
        		  n = d;
        		  add(new Digit(k, 30, 550 - shift, 25));
        		  shift+=30;
        	}
        	add(new Digit(0,30,550 - shift, 25));
        }
        	
        else if(n>=100) {//if points has 3digits
        	while (n > 0) {
          		  int d = n / 10;
          		  int k = n - d * 10;
          		  n = d;
          		  add(new Digit(k, 30, 550 - shift, 25));
          		  shift+=30;
          	}
        }
    	
    }
	
	public void updateLife(int n) {
		add(new Digit(n,30,500,60));
	}*/
	
	
	
	/*////SCREENGENERATOR INTERFACE IMPLEMENTATION/////
	@Override
	public Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button(); 
		btn.setMinSize(30,30);
		btn.setMaxSize(30,30);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	@Override
	public Text createText(String text, String fonttype, int textsize) {
		// TODO Auto-generated method stub
		Text txt = new Text(text);
		txt.setFont(Font.loadFont("file:src/froggerfonts/"+fonttype+".ttf", textsize));
		txt.setFill(Color.WHITE);
		txt.setX(510);
		txt.setY(470);	
		return txt;
	}*/
	

	
	
	/////TEMPLATE METHOD DESIGN PATTERN/////
	////ABSTRACT CLASSES TO BE IMPLEMENTED BY SUBCLASSES////
	
	/**to set up an arena or scene for a game level*/
	protected abstract void createArena();//different arena for each level
	
	/**to generate music for a game level */
	public abstract void createMusic(String musicFile);//different music for each level
	
	/**
	 * to check if a game level is completed
	 * @return boolean <b>true</b> if the level has been completed by {@code Animal}
	 */
	public abstract boolean levelComplete();//main
	
	public abstract boolean levelStop();//main
	
	/**
	 * to check if {@code Animal} has changed score at a game level
	 * @return boolean <b>true</b> if the Animal has changed score at that level
	 */
	public abstract boolean animalchangeScore();//main
	public abstract boolean animalchangeLife();//main
	
	/**to activate {@code Animal} at a game level */
	public abstract void activateAnimal();//main//different activation details for each level

	/**
	 * get the points of {@link p4_group_8_repo.Animal} at a game level
	 * @return int, the points of {@code Animal} at a game level
	 */
	public abstract int getlevelPoints();//different points at each level
	public abstract int getlevelLife();

}
