package froggerGameActions;

import froggerLevels.Level;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* Represents one of the Game Actions.<br>
* Level Up
* @author GohXinYee
*
*/
public class UpLevel implements GameAction{
	
	/** the level the player is currently at*/
	private Level currentlevel;
	/** the next level the player transits to*/
	private Level nextlevel;
	/** the scene of the next level*/
	private Scene nextlevelscene;
	
	/**
	 * This constructor will create an {@code UpLevel} object
	 * @param currentlevel value for {@link UpLevel#currentlevel}
	 * @param nextlevel value for {@link UpLevel#nextlevel}
	 * @param nextlevelscene value for {@link UpLevel#nextlevelscene}
	 */
	public UpLevel(Level currentlevel,Level nextlevel,Scene nextlevelscene){
		this.currentlevel=currentlevel;
		this.nextlevel=nextlevel;
		this.nextlevelscene=nextlevelscene;
		
	}

	/**
	 * up the level of the player.
	 */
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
		Stage primaryStage = currentlevel.getStage();
		nextlevel.setStage(primaryStage);
	 	currentlevel.stopMusic();
	 	currentlevel.stop();
	 	nextlevel.activateAnimal();
	 	//nextlevel.updateScore(nextlevel.getlevelPoints());
	 	primaryStage.setScene(nextlevelscene);
	 	nextlevel.start();//timer at World
	 	nextlevel.playMusic();//playmusic right away
	}

}
