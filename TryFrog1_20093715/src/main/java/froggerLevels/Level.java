package froggerLevels;

import froggerAnimal_Actions.*;
import froggerElements.BackgroundImage;
import froggerElements.Digit;
import froggerElements.Life;
import froggerMaterialGenerator.ButtonGenerator;
import froggerMaterialGenerator.TextGenerator;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * <b>The base class for all game levels.<br>
 * It is not a ready game level. It sets up a basic structure for the real game levels and allows functions like level display, checking if the game level has been completed or stopped, checking if the {@link froggerAnimal_Actions.Animal} at the game level has changed score or life etc.<br>
 * {@code Level} will have no game objects other than an {@code Animal} and a background image for the level. It will also have the initial score and life ready.<br>
 * Template Design Pattern is applied, where {@code Level} has <i>abstract</i> methods to be implemented differently by its subclasses, which are the <i>real and concrete</i> game levels.</b>
 *
 */
public abstract class Level extends World{
	
	/**pause button to pause the game*/
	private Button pausebtn;
	/**quit button to quit the game*/
	private Button quitbtn;
	/**determine if a game level can be paused<br><b>true</b> if the level can be paused.*/
	private boolean pause=true;
	
	/** the {@code Stage} the game level scene is at*/
	private Stage stage;
	/**the {@link froggerAnimal_Actions.Animal} object at the game level*/
	private Animal levelanimal;
	/**background image of level*/
	private BackgroundImage levelbackground;
	/**default initial amount of life at a level*/
	private Life initiallife;
	/**default initial game points at a level*/
	private Digit initialscore;
	
	
	/**This constructor will generate a {@code Level} that sets up a structure for a game level<br> */
	public Level() {		
		
		
		//add background image for the game level
		//all game levels have the same background image
		levelbackground = new BackgroundImage("file:src/main/resources/froggertextures/iKogsKW.png",605,800);
		initiallife = new Life(5,40,450,60);
		initialscore = new Digit(0,30,550,25);
		
		add(levelbackground);//background
		add(initiallife);//Life
		add(initialscore);//add score display
		
		//create pause and quit buttons to the game level
		//all game levels will have a pause and a quit button
		ButtonGenerator btngenerator = new ButtonGenerator();
		pausebtn = btngenerator.generate("file:src/main/resources/froggertextures/pausebtnfrogger.png",40,40);
		pausebtn.setLayoutX(550);
		pausebtn.setLayoutY(58);
		add(pausebtn);
		quitbtn = btngenerator.generate("file:src/main/resources/froggertextures/quitcrossbtnfrogger.png",40,40);
		quitbtn.setLayoutX(500);
		quitbtn.setLayoutY(58);
		add(quitbtn);
		setbuttonAction();
		
		
			
	}


	/**
	 * display the level index of a game level.<br>
	 * Example: Game Level 1, index is 1
	 * @param level the index of the game level to be displayed
	 */
	//called in its subclasses only
	protected void displaylevel(int level) {
		// TODO Auto-generated method stub
		TextGenerator txtgenerator = new TextGenerator();
		Text leveldisplay = txtgenerator.generate("Level "+level,"ChickenPie",25,TextAlignment.JUSTIFY,Color.ANTIQUEWHITE);
		leveldisplay.setX(508);
		leveldisplay.setY(470);
		add(leveldisplay);
	}

	/**
	 * Check if a game level is completed
	 * @return boolean <b>true</b> if the level has been completed by {@code Animal}
	 */
	public boolean levelComplete() {
		return this.levelanimal.getStop();//end = 5
	}

	/**
	 * Check if a game level is stopped
	 * @return boolean <b>true</b> if the level has been stopped
	 */
	public boolean levelStop() {
		return this.levelanimal.noLife();//life = 0
	}

	/**
	 * Check if {@code Animal} has changed score at the level
	 * @return boolean <b>true</b> if the Animal has changed score at that level
	 */
	public boolean animalchangeScore() {
		// TODO Auto-generated method stub
		return this.levelanimal.changeScore();
	}

	/**
	 * Check if {@code Animal} amount of life has changed at the level
	 * @return boolean <b>true</b> if the Animal amount of life has changed
	 */
	public boolean animalchangeLife() {
		// TODO Auto-generated method stub
		return this.levelanimal.changeLife();
	}

	/**
	 * get the points of Animal at the level
	 * @return int, the points of Animal at that level
	 */
	public int getlevelPoints() {
		// TODO Auto-generated method stub
		return this.levelanimal.getPoints();
	}

	/**
	 * get the amount of life of {@code Animal} at the level
	 * @return int, the amount of life of {@code Animal} at a game level
	 */
	public int getlevelLife() {
		// TODO Auto-generated method stub
		return this.levelanimal.getLife();
	}

	
	
	/**setter method for {@link Level#levelanimal}
	 * @param animal animal to set to*/
	public void setlevelAnimal(Animal animal) {
		this.levelanimal=animal;
	}
	/** getter mthod for {@link Level#levelanimal}
	 * @return {@link Level#levelanimal} */
	public Animal getlevelAnimal() {
		return this.levelanimal;
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
	}
	
	/**
	 * getter method for {@link Level#stage}<br>
	 * retrieve the {@code Stage} of a game level is in.<br>
	 * used here to retrieve and pass the {@code primaryStage} from one game {@code Level} to another.<br>
	 * See : {@link Level#setStage(Stage)}
	 * @return {@code Stage} of the game level
	 */
	public Stage getStage() {
		return this.stage;
	}
	
	
	/**
	 * to set up the action of the buttons appear in the game level scene.<br>
	 * used <b>exclusively</b> by Level only
	 */
	private void setbuttonAction() {
		
		//set pause button on-clicked action
		//if pause button is clicked, game is paused and music is stopped
		//clicked again, game and music are resumed
		pausebtn.setOnMouseClicked(event -> {
			if(pause) {
				this.pause(pause);//pause game
				this.stopMusic();
				pause=false;
			}
			else {
				this.pause(pause);//resume game
				this.playMusic();
				pause=true;
			}
		});
		
		quitbtn.setOnMouseClicked(event -> {
			Platform.exit();
		});
	}


	/**to set up an arena or scene for a game level*/
	protected abstract void createArena();//different arena for each level
	
	/**to generate music for a game level */
	protected abstract void createMusic();//different music for each level
	
	/**to activate {@code Animal} at a game level */
	public abstract void activateAnimal();//main//different activation details for each level
}
