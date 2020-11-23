package froggerLevels;

import froggerAnimal_Actions.*;
import froggerElements.BackgroundImage;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/*
 * Level1 - 0.7 speed, original , //car -3
 * Level2 - original speed, original, //car -5
 * Level3 - original speed, add Coin function, //car -5
 * Level4 - 1.3 speed, original, //car -7
 * Level5 - 1.3 speed, add Coin function, //car-7
 * 
 * Level6 - original speed, add Monster(2), car -5
 * Level7 - 1.3 speed, add Monster(3), all Wet Turtles, car -5
 * Level8 - 1.4 speed, add Monster(4), all Wet Turtles, car -7
 * Level9 - 1.5 speed, add Monster(4), all Wet Turtles, add Coin, car -7
 * Level10 - 1.7 speed, add Monster(5), all Wet Turtles, car -7
 */



/**
 * The base class for all game levels.<br>
 * It is not a ready game level. It sets up a basic structure for the <b>real game levels</b> and allows functions like level display, checking if the game level has been completed or stopped, checking if the {@link froggerAnimal_Actions.Animal} at the game level has changed score or life etc.<br>
 * {@code Level} will have no game objects other than an {@code Animal} and a background image for the level.<br>
 * <b>Template Design Pattern</b> is applied, where {@code Level} has <b><i>abstract</i> methods</b> to be implemented differently by its subclasses, which are the <b><i>real and concrete</i> game levels</b>.
 *
 */
public abstract class Level extends World{
	
	private Button pausebtn;
	/**determine if a game level can be paused, <b>true</b> if the level can be paused.*/
	private boolean pause=true;
	
	/** the {@code Stage} the game level scene is at*/
	private Stage stage;
	/**the {@link froggerAnimal_Actions.Animal} object at the game level*/
	private Animal levelanimal;
	
	/**This constructor will generate a {@code Level} that sets up a structure for a game level<br> */
	public Level() {		
		
		
		//add background image for the game level
		//all game levels have the same background image
		BackgroundImage levelbackground = new BackgroundImage("file:src/froggertextures/iKogsKW.png",605,800);
		add(levelbackground);
		
		//add a pause button to the game level
		//all game levels will have a pause button
		pausebtn = createbtn("file:src/froggertextures/pausebtnfrogger.png",40,40);
		pausebtn.setLayoutX(550);
		pausebtn.setLayoutY(60);
		add(pausebtn);
		
		setbuttonAction();
		
		
			
	}


	/**
	 * display the level# of a game level.<br>
	 * Example: Game Level 1, # is 1
	 * @param level the # of the game level to be displayed
	 */
	//called in its subclasses only
	protected void displaylevel(int level) {
		// TODO Auto-generated method stub
		Text leveldisplay = new Text("Level "+level);
		leveldisplay.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 25));
		leveldisplay.setFill(Color.WHITE);
		leveldisplay.setX(510);
		leveldisplay.setY(470);
		add(leveldisplay);
	}

	/**
	 * to check if a game level is completed
	 * @return boolean <b>true</b> if the level has been completed by {@code Animal}
	 */
	public boolean levelComplete() {
		return this.levelanimal.getStop();//end = 5
	}

	/**
	 * to check if a game level is stopped
	 * @return boolean <b>true</b> if the level has been stopped
	 */
	//public abstract boolean levelStop();//main
	public boolean levelStop() {
		return this.levelanimal.noLife();//life = 0
	}

	/**
	 * to check if {@code Animal} has changed score at a game level
	 * @return boolean <b>true</b> if the Animal has changed score at that level
	 */
	public boolean animalchangeScore() {
		// TODO Auto-generated method stub
		return this.levelanimal.changeScore();
	}

	/**
	 * to check if {@code Animal} amount of life has changed at a game level
	 * @return boolean <b>true</b> if the Animal amount of life has changed
	 */
	public boolean animalchangeLife() {
		// TODO Auto-generated method stub
		return this.levelanimal.changeLife();
	}

	/**
	 * get the points of {@code Animal} at a game level
	 * @return int, the points of {@code Animal} at a game level
	 */
	public int getlevelPoints() {
		// TODO Auto-generated method stub
		return this.levelanimal.getPoints();
	}

	/**
	 * get the amount of life of {@code Animal} at a game level
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
		System.out.println("Done stage set");
	}
	
	/**
	 * getter method for {@link Level#stage}<br>
	 * retrieve the {@code Stage} of a game level is in.<br>
	 * used here to retrieve and pass the {@code primaryStage} from one game {@code Level} to another.<br>
	 * See : {@link Level#setStage(Stage)}
	 * @return {@code Stage} of the game level
	 */
	public Stage getStage() {
		System.out.println("Done get");
		return this.stage;
	}
	
	
	/**
	 * to create button appeared on the game level scene.<br>
	 * Used <b>exclusively</b> by Level only.
	 * @param imagelink the link of the image for how the button on the level scene looks like
	 * @param width the width of the button
	 * @param height the height of the button
	 * @return a created {@code Button}
	 */
	private Button createbtn(String imagelink, int width, int height) {
		Button btn = new Button();
		btn.setMinSize(width, height);
		btn.setMaxSize(width, height);
		btn.setGraphic(new ImageView(new Image(imagelink)));
		return btn;
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
		
		
	}


	/**to set up an arena or scene for a game level*/
	protected abstract void createArena();//different arena for each level
	
	/**to generate music for a game level */
	protected abstract void createMusic();//different music for each level
	
	/**to activate {@code Animal} at a game level */
	public abstract void activateAnimal();//main//different activation details for each level
}
