package froggerFrames;

//import java.io.File;
import java.util.ArrayList;
//import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import froggerActors.*;
import froggerAnimal_Actions.*;
import froggerElements.*;
import froggerHighScore.*;
import froggerGameActions.*;
import froggerLevels.*;



//import javafx.util.Duration;

public class Main extends Application {
	
	AnimationTimer timer;
	Level level1, level2, level3, level4, level5;
	Level level6, level7, level8, level9;
	Scene level1scene, level2scene, level3scene, level4scene, level5scene;
	Scene level6scene, level7scene, level8scene, level9scene;

	
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
		//create an animal and set it up for all levels
		Animal animal = new Animal("file:src/froggertextures/froggerUp.png");
		
		LevelFactory levelfactory = new LevelFactory();

		level1 = levelfactory.getLevel("Level1", animal);
	    //level1 = new Level1(animal);
	    level1scene  = new Scene(level1,gamescreenwidth,gamescreenheight);
	    
		level2 = levelfactory.getLevel("Level2", animal);
	    //level2 = new Level2(animal);
	    level2scene = new Scene(level2,gamescreenwidth,gamescreenheight);
	    
		level3 = levelfactory.getLevel("Level3", animal);
	    //level3 = new Level3(animal);
	    level3scene = new Scene(level3,gamescreenwidth,gamescreenheight);
	    
		level4 = levelfactory.getLevel("Level4", animal);
	    //level4 = new Level4(animal);
	    level4scene = new Scene(level4,gamescreenwidth,gamescreenheight);
	    
		level5 = levelfactory.getLevel("Level5", animal);
		//level5 = new Level5(animal);
	    level5scene = new Scene(level5,gamescreenwidth,gamescreenheight);
	    
	    level6 = levelfactory.getLevel("Level6", animal);
	    level6scene  = new Scene(level6,gamescreenwidth,gamescreenheight);
	    
		level7 = levelfactory.getLevel("Level7", animal);
	    level7scene = new Scene(level7,gamescreenwidth,gamescreenheight);
	    
		level8 = levelfactory.getLevel("Level8", animal);
	    level8scene = new Scene(level8,gamescreenwidth,gamescreenheight);
	    
		level9 = levelfactory.getLevel("Level9", animal);
	    level9scene = new Scene(level9,gamescreenwidth,gamescreenheight);
	  		
	    
	    
	    //SET ACTIONS FOR BUTTONS//
	    
	  	//if startbtn is clicked
	  	//if username exists, go to maingamescreen
	  	//else alert for username input
		start.getstartbtn().setOnMouseClicked(event-> {
			if(start.getusername()!= null) {
				username = start.getusername();
				//
				System.out.println(username + " -- Successfully get username.");
				//
				start.stopMusic();
				primaryStage.setScene(level1scene);
				level1.setStage(primaryStage);
				level1.activateAnimal();
				level1.start();
				level1.playMusic();
				currentlevelvalue=1;
				//start timer for level1 -activation-
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Enter a username first!");
				alert.show();
			}
	    });
		
		
		//if info button is clicked, switch to INFO SCREEN
		start.getinfobtn().setOnMouseClicked(event -> {
			primaryStage.setScene(infoscreen);
		});
				
		
		//if exit button is clicked, close the program
		start.getexitbtn().setOnMouseClicked(event -> {
			Platform.exit();
		});
		
		
		//if backtostart button is clicked, back to START SCREEN
		info.getbacktostartbtn().setOnMouseClicked(event -> {
			primaryStage.setScene(startscreen);
		});
		
		
		//START THE STAGE with start screen//
		
	  	primaryStage.setScene(startscreen);
	  	primaryStage.show();
	  	start();  //start timer for the whole application
	  	start.playMusic();//start music for startscreen
	  		
}
	
	
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	//highscorepopup yes or no?
            	//boolean highscorepop=false;
            	
                if(currentlevelvalue==1) {
                	
                	checkGameAction(level1,level2,level2scene);
                	
                	/*if (level1.animalchangeScore()) {
                		level1.updateScore(level1.getlevelPoints());
                		//setTotalScore(level1.getlevelPoints(), level1);
                	}
                	if (level1.animalchangeLife()) {
                		level1.updateLife(level1.getlevelLife());
                	}
                	if (level1.levelStop()){
                		loseGame(level1); 
                	}
                	if(level1.levelComplete()) {
              		  levelUp(level1,level2,level2scene); 
                	}*/
                }
                if(currentlevelvalue==2) {
                	
                	checkGameAction(level2,level3,level3scene);
                	
                	/*if (level2.animalchangeScore()){
                		level2.updateScore(level2.getlevelPoints());
                		//setTotalScore(level2.getlevelPoints(), level2);
                    }
                	if (level2.animalchangeLife()) {
                		level2.updateLife(level2.getlevelLife());
                	}
                	if (level2.levelStop()){
                		loseGame(level2); 
                	}
                	 if(level2.levelComplete()){
                		 levelUp(level2,level3,level3scene);
                	 }*/
                }
                if(currentlevelvalue==3) {
                	
                	checkGameAction(level3,level4,level4scene);
                	
                	/*if(level3.animalchangeScore()){
                		level3.updateScore(level3.getlevelPoints());
                		//setTotalScore(level3.getlevelPoints(), level3);
                	}
                	if (level3.animalchangeLife()) {
                		level3.updateLife(level3.getlevelLife());
                	}
                	if (level3.levelStop()){
                		loseGame(level3); 
                	}
                	if(level3.levelComplete()) {
                		levelUp(level3,level4,level4scene);
                	}*/
                }
                if(currentlevelvalue==4) {	
                	
                	checkGameAction(level4,level5,level5scene);
                	
                	/*if(level4.animalchangeScore()){
                		level4.updateScore(level4.getlevelPoints());
                		//setTotalScore(level4.getlevelPoints(), level4);
                	}
                	if (level4.animalchangeLife()) {
                		level4.updateLife(level4.getlevelLife());
                	}
                	if (level4.levelStop()){
                		loseGame(level4); 
                	}
                	if(level4.levelComplete()){
               		 	levelUp(level4,level5,level5scene);
               	 	}*/
                }
                if(currentlevelvalue==5) {
                	
                	checkGameAction(level5,level6,level6scene);
                	
                /*	if(level5.animalchangeScore()){
                		level5.updateScore(level5.getlevelPoints());
                		//setTotalScore(level5.getlevelPoints(), level5);
                	}
                	if (level5.animalchangeLife()) {
                		level5.updateLife(level5.getlevelLife());
                	}
                	if (level5.levelStop()){
                		loseGame(level5); 
                	}
                	if(level5.levelComplete()) {
                		winGame(level5);
                	}*/
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
                	
                	checkGameAction(level9,level9,level9scene);
                }
            	
                
            }
        };
    }
	
	
	
	//STRATEGY DESIGN PATTERN//
	//each GameAction will be reused by each level
	 public void checkGameAction(Level currentlevel, Level nextlevel, Scene nextlevelscene){
	
	 		GameActionContext context;
	
	 		if (currentlevel.animalchangeScore()) {
	  			context = new GameActionContext(new UpdateScore(currentlevel));
	  			context.executeAction();
	 		}
	            	
	        if (currentlevel.animalchangeLife()) {
	            context = new GameActionContext(new UpdateLife(currentlevel));
	           	context.executeAction();
	        }
	            	
	        if (currentlevel.levelStop()){
	           	endGame(currentlevel);
	          	context = new GameActionContext(new PopHighScore("LOSE",username,currentlevel));
	           	context.executeAction();
	      	}
	            	
	            	
	        if(currentlevel.levelComplete()) {
	            	
	           	if(currentlevel != nextlevel){
	          		  context = new GameActionContext(new UpLevel(currentlevel,nextlevel,nextlevelscene));
	          		  context.executeAction(); 
	          		  context = new GameActionContext(new UpdateScore(nextlevel));
	          		  context.executeAction();
	          		  currentlevelvalue++;
	           	}
	            else if(currentlevel == nextlevel){
	            	endGame(currentlevel);
	            	context= new GameActionContext(new PopHighScore("WIN", username, currentlevel));
	            	context.executeAction();
	            }
	        }
	
	 }

	public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    
    /*
    public void levelUp(Level currentlevel, Level nextlevel, Scene nextlevelscene) {
		// TODO Auto-generated method stub

		Stage primaryStage = currentlevel.getStage();
		nextlevel.setStage(primaryStage);
		//System.out.println("PrimaryStage passed for" + nextlevel.getClass().getSimpleName());
	 	//nextlevel.setlevelPoints(currentlevel.getlevelPoints());
	 	currentlevel.stopMusic();
	 	currentlevel.stop();
	 	nextlevel.activateAnimal();
	 	//nextlevel.updateScore(nextlevel.getlevelPoints());
	 	//setTotalScore(nextlevel.getlevelPoints(), nextlevel);
	 	currentlevelvalue++;
	 	primaryStage.setScene(nextlevelscene);
	 	nextlevel.start();//timer at World
	 	nextlevel.playMusic();//playmusic right away
	 	
	}
    
    */
    
    public void winGame(Level level) {
    	System.out.println("WINNN");
    	level.stopMusic();
    	level.stop();
    	stop();
    	//popHighScore(level,"WIN");
    }
    
	public void loseGame(Level level){
	  	System.out.println("LOSEEE");
	  	level.stopMusic();
	 	level.stop();
	  	stop();
	 	//popHighScore(level,"LOSE");//username
	
	}
	
    
    public void endGame(Level level) {
    	System.out.println("GAME END");
    	level.stopMusic();
    	level.stop();
    	stop();
    	
    }

    
	/*public void popHighScore(Level level, String winlosestatus) {
		// TODO Auto-generated method stub
		
		//GENERATE HIGHSCORE POP UP//
    	//MVC PATTERN//
 		HighScoreModel highscoremodel = new HighScoreModel(username,level.getlevelPoints());
		HighScoreView highscoreview = new HighScoreView(level.getlevelPoints(), winlosestatus);
 		HighScoreController highscorecontroller = new HighScoreController(highscoremodel,highscoreview);
 		
 		//retrieving high score records from file and add it to an ArrayList
		ArrayList<String> scorelist = highscorecontroller.retrievingHighScore();
		
		//display up to top 5 of high score
		int rank=1;
		for (String currenthighscore : scorelist) {
			if(rank<6) {
				highscorecontroller.updateView(rank,currenthighscore);
				rank++;
			}
			else {
				break;
			}
		}
		//finish up the high score pop up
		highscoreview.finishup();
		
	
		//create Scene and Stage for HighScore pop up
		Scene highscorescene = new Scene(highscoreview.gethighscorepopup(),400,500);
		Stage highscorestage = new Stage();
		highscorestage.setTitle("Game End");
		highscorestage.initModality(Modality.APPLICATION_MODAL);
		highscorestage.setScene(highscorescene);
		highscorestage.show();
		
		//SET HIGHSCORE POP UP BUTTON ACTIONS//
		highscoreview.getquitbtn().setOnMouseClicked(event -> {
		highscorestage.close();
		Platform.exit();
	
		});
	
		highscorestage.setOnCloseRequest(event -> {
		Platform.exit();
		});
		
	}*/
	
	
	/*
	public void levelUp(Level currentlevel, Level nextlevel, Scene nextlevelscene) {
		// TODO Auto-generated method stub
	
		Stage primaryStage = currentlevel.getStage();
		nextlevel.setStage(primaryStage);
		//System.out.println("PrimaryStage passed for" + nextlevel.getClass().getSimpleName());
	 	//nextlevel.setlevelPoints(currentlevel.getlevelPoints());
	 	currentlevel.stopMusic();
	 	currentlevel.stop();
	 	nextlevel.activateAnimal();
	 	//nextlevel.updateScore(nextlevel.getlevelPoints());
	 	//setTotalScore(nextlevel.getlevelPoints(), nextlevel);
	 	currentlevelvalue++;
	 	primaryStage.setScene(nextlevelscene);
	 	nextlevel.start();//timer at World
	 	nextlevel.playMusic();//playmusic right away
	 	
	}
	
	*/
	

	 
	
	
    
}


/* //set points display on game screen
public void setTotalScore(int n, LevelMaster currentlevel) {
	int shift = 0;
	
	if(n<100) {//if points has 2 digits
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  currentlevel.add(new Digit(k, 30, 550 - shift, 25));
    		  shift+=30;
    	}
    	currentlevel.add(new Digit(0,30,550 - shift, 25));
    }
    	
    else if(n>=100) {//if points has 3digits
    	while (n > 0) {
      		  int d = n / 10;
      		  int k = n - d * 10;
      		  n = d;
      		  currentlevel.add(new Digit(k, 30, 550 - shift, 25));
      		  shift+=30;
      	}
    }
	
}*/

//UPDATE SCORE OF ANIMAL AT EACH LEVEL//

/*if (level1.animalchangeScore() && currentlevelvalue==1) {
	setNumber(level1.getlevelPoints(), level1);
}

if (level2.animalchangeScore() && currentlevelvalue==2){
		setNumber(level2.getlevelPoints(), level2);
}

if(level3.animalchangeScore() && currentlevelvalue==3){
  		setNumber(level3.getlevelPoints(), level3);
}

if(level4.animalchangeScore()&& currentlevelvalue==4){
		setNumber(level4.getlevelPoints(), level4);
}

if(level5.animalchangeScore()&& currentlevelvalue==5){
		setNumber(level5.getlevelPoints(), level5);
}


//LEVEL TRANSITION TILL END OF GAME//

if(level1.levelStop() && currentlevelvalue==1 ){
	
	levelUp(level1,level2,level2scene); 
}

if(level2.levelStop()  && currentlevelvalue==2){
		
	levelUp(level2,level3,level3scene);

}

if(level3.levelStop()  && currentlevelvalue==3){
	
	levelUp(level3,level4,level4scene);
}

if(level4.levelStop() && currentlevelvalue==4) {
	
	levelUp(level4,level5,level5scene);
}

if(level5.levelStop() && currentlevelvalue==5) {
	
		System.out.println("STOPPPP");
		level5.stopMusic();
		level5.stop();
		stop(); //stop timer for whole game
*/	
		//highscoreflag=true; }
		//if(highscoreflag){






//highscorepopup(LevelMaster level, String winlose)
//HighScoreView(level.getlevelPoints(),"Win","LOSE");
/* if(highscorepop==true) {
	
		//GENERATE HIGHSCORE POP UP//
	//MVC PATTERN//
		HighScoreModel highscoremodel = new HighScoreModel(username,level5.getlevelPoints());
	HighScoreView highscoreview = new HighScoreView(level5.getlevelPoints());
		HighScoreController highscorecontroller = new HighScoreController(highscoremodel,highscoreview);
		
		//retrieving high score records from file and add it to an ArrayList
	ArrayList<String> scorelist = highscorecontroller.retrievingHighScore();
	
	//display up to top 5 of high score
	int rank=1;
	for (String currenthighscore : scorelist) {
		if(rank<6) {
			highscorecontroller.updateView(rank,currenthighscore);
			rank++;
		}
		else {
			break;
		}
	}
	//finish up the high score pop up
	highscoreview.finishup();
	

	//create Scene and Stage for HighScore pop up
	Scene highscorescene = new Scene(highscoreview.gethighscorepopup(),400,500);
	Stage highscorestage = new Stage();
	highscorestage.setTitle("Game End");
	highscorestage.initModality(Modality.APPLICATION_MODAL);
	highscorestage.setScene(highscorescene);
	highscorestage.show();
	
	//SET HIGHSCORE POP UP BUTTON ACTIONS//
	highscoreview.getquitbtn().setOnMouseClicked(event -> {
	highscorestage.close();
	Platform.exit();

	});

	highscorestage.setOnCloseRequest(event -> {
	Platform.exit();
	});
	
}   */         	
