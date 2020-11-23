package froggerFrames;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import froggerAnimal_Actions.*;
import froggerGameActions.*;
import froggerLevels.*;


public class Main extends Application {
	
	AnimationTimer timer;
	Level level1, level2, level3, level4, level5;
	Level level6, level7, level8, level9,level10;
	Scene level1scene, level2scene, level3scene, level4scene, level5scene;
	Scene level6scene, level7scene, level8scene, level9scene, level10scene;

	
	public String username;
	public static int currentlevelvalue;
	public int gamescreenwidth=600;
	public int gamescreenheight=800;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		
		//GENERATE START SCREEN//
		//SINGLETON DESIGN PATTERN
		StartScreen start = StartScreen.getInstance();
		Scene startscreen = new Scene(start.getStartScreenGroup(),gamescreenwidth,gamescreenheight);
		
		//GENERATE INFO SCREEN//
		//SINGLETON DESIGN PATTERN
		InfoScreen info = InfoScreen.getInstance();
		Scene infoscreen = new Scene(info.getInfoScreenGroup(),gamescreenwidth,gamescreenheight);
		
		
		//GENERATE LEVELS FOR GAME SCREEN//
		//FACTORY METHOD DESIGN PATTERN
		
		//create an animal and set it up for all levels
		Animal animal = new Animal("file:src/froggertextures/froggerUp.png");
		
		//create a LevelFactory
		LevelFactory levelfactory = new LevelFactory();
		
		level1 = levelfactory.getLevel("Level1", animal);
	    level1scene  = new Scene(level1,gamescreenwidth,gamescreenheight);
	    
		level2 = levelfactory.getLevel("Level2", animal);
	    level2scene = new Scene(level2,gamescreenwidth,gamescreenheight);
	    
		level3 = levelfactory.getLevel("Level3", animal);
	    level3scene = new Scene(level3,gamescreenwidth,gamescreenheight);
	    
		level4 = levelfactory.getLevel("Level4", animal);
	    level4scene = new Scene(level4,gamescreenwidth,gamescreenheight);
	    
		level5 = levelfactory.getLevel("Level5", animal);
	    level5scene = new Scene(level5,gamescreenwidth,gamescreenheight);
	    
	    level6 = levelfactory.getLevel("Level6", animal);
	    level6scene  = new Scene(level6,gamescreenwidth,gamescreenheight);
	    
		level7 = levelfactory.getLevel("Level7", animal);
	    level7scene = new Scene(level7,gamescreenwidth,gamescreenheight);
	    
		level8 = levelfactory.getLevel("Level8", animal);
	    level8scene = new Scene(level8,gamescreenwidth,gamescreenheight);
	    
		level9 = levelfactory.getLevel("Level9", animal);
	    level9scene = new Scene(level9,gamescreenwidth,gamescreenheight);
	  		
	    level10 = levelfactory.getLevel("Level10", animal);
	    level10scene = new Scene(level10,gamescreenwidth,gamescreenheight);

	    
	    
	    //SET ACTIONS FOR BUTTONS//
	    
	  	//if start button is clicked
	  	//if username exists, go to Game Level Scene
	  	//else alert for username input
		start.getstartbtn().setOnMouseClicked(event-> {
			if(start.getusername()!= null) {
				//get username of current player
				username = start.getusername();
				//
				System.out.println(username + " -- Successfully get username.");
				//
				//deactivate Start Screen
				start.stopMusic();
				//activate Level 1
				primaryStage.setScene(level1scene);
				level1.setStage(primaryStage);
				level1.activateAnimal();
				level1.start();
				level1.playMusic();
				currentlevelvalue=1;//current level = 1
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Enter a username first!");
				alert.show();
			}
	    });
		
		
		//if info button is clicked, switch to Info Screen
		start.getinfobtn().setOnMouseClicked(event -> {
			primaryStage.setScene(infoscreen);
		});
				
		
		//if exit button is clicked, close the program
		start.getexitbtn().setOnMouseClicked(event -> {
			Platform.exit();
		});
		
		
		//if backtostart button on Info Screen is clicked, back to START SCREEN
		info.getbacktostartbtn().setOnMouseClicked(event -> {
			primaryStage.setScene(startscreen);
		});
		
		
		
		//START the Application with Start Screen//
	  	primaryStage.setScene(startscreen);
	  	primaryStage.show();
	  	start();  //start timer for the application
	  	start.playMusic();//play music for Start Screen
	  		
}
	
	
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
                if(currentlevelvalue==1) {
                	
                	checkGameAction(level1,level2,level2scene);
                }
                if(currentlevelvalue==2) {
                	
                	checkGameAction(level2,level3,level3scene);
                }
                if(currentlevelvalue==3) {
                	
                	checkGameAction(level3,level4,level4scene);
                }
                if(currentlevelvalue==4) {	
                	
                	checkGameAction(level4,level5,level5scene);
                }
                if(currentlevelvalue==5) {
                	
                	checkGameAction(level5,level6,level6scene);
                }
                if(currentlevelvalue==6) {
                	
                	checkGameAction(level6,level7,level7scene);
                }
                if(currentlevelvalue==7) {
                	
                	checkGameAction(level7,level8,level8scene);
                }
                if(currentlevelvalue==8) {
                	
                	checkGameAction(level8,level9,level9scene);
                }
                if(currentlevelvalue==9) {
                	
                	checkGameAction(level9,level10,level10scene);
                }
                if(currentlevelvalue==10) {
                	
                	checkGameAction(level10,level10,level10scene);
                }
            	
                
            }
        };
    }
	
	
	
	//STRATEGY DESIGN PATTERN//
	//each GameAction will be reused by each level
	/**
	 * check for appropriate Game Action to execute and execute the Game Action.<br>
	 * See also : {@link froggerGameActions.GameAction}, {@link froggerGameActions.UpdateScore}, {@link froggerGameActions.UpdateLife}, 
	 * {@link froggerGameActions.PopHighScore}, {@link froggerGameActions.UpLevel} and {@link froggerGameActions.GameActionContext}.
	 * @param currentlevel current level of player
	 * @param nextlevel next level player shall proceed to
	 * @param nextlevelscene the scene of the next level player shall proceed to
	 */
	public void checkGameAction(Level currentlevel, Level nextlevel, Scene nextlevelscene){
	
	 		GameActionContext context;
	
	 		//if animal score changes, execute update score action
	 		if (currentlevel.animalchangeScore()) {
	  			context = new GameActionContext(new UpdateScore(currentlevel));
	  			context.executeAction();
	 		}
	            	
	 		//if animal life changes, execute update life action
	        if (currentlevel.animalchangeLife()) {
	            context = new GameActionContext(new UpdateLife(currentlevel));
	           	context.executeAction();
	        }
	           
	        //if level is stopped, end the game with a lose and execute pop high score action
	        if (currentlevel.levelStop()){
	           	endGame(currentlevel);
	          	context = new GameActionContext(new PopHighScore("LOSE",username,currentlevel));
	           	context.executeAction();
	      	}
	            	
	        //if level is completed   	
	        if(currentlevel.levelComplete()) {
	            
	        	//if current level is not the final level, level up
	           	if(currentlevel != nextlevel){
	          		  context = new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
	          		  context.executeAction(); 
	          		  context = new GameActionContext(new UpdateScore(nextlevel));
	          		  context.executeAction();
	          		  currentlevelvalue++;
	           	}
	           	//if current level is the final level, end the game with a win and execute pop high score action
	            else if(currentlevel == nextlevel){
	            	endGame(currentlevel);
	            	context= new GameActionContext(new PopHighScore("WIN", username, currentlevel));
	            	context.executeAction();
	            }
	        }
	
	 }

	/**to start the application*/
	public void start() {
    	createTimer();
        timer.start();
    }

	/**to stop the application*/
    public void stop() {
        timer.stop();
    }
    
    
    public void winGame(Level level) {
    	System.out.println("WINNN");
    	level.stopMusic();
    	level.stop();
    	stop();
    }
    
	public void loseGame(Level level){
	  	System.out.println("LOSEEE");
	  	level.stopMusic();
	 	level.stop();
	  	stop();
	
	}
	
    /**called to end the game*/
    public void endGame(Level level) {
    	System.out.println("GAME END");
    	level.stopMusic();
    	level.stop();
    	stop();
    	
    }
    
}


