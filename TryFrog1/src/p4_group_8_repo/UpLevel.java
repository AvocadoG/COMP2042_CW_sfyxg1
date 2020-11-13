package p4_group_8_repo;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpLevel implements GameAction{
	
	private Level currentlevel,nextlevel;
	private Scene nextlevelscene;
	
	UpLevel(Level currentlevel,Level nextlevel,Scene nextlevelscene){
		this.currentlevel=currentlevel;
		this.nextlevel=nextlevel;
		this.nextlevelscene=nextlevelscene;
		
	}

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
