package p4_group_8_repo;

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
//import javafx.util.Duration;

public class Main extends Application {
	
	AnimationTimer timer;
	MyStage level1, level2, level3, level4, level5;
	Scene level1scene, level2scene, level3scene, level4scene, level5scene;
	
	//Animal animal;
	
	public String username;
	public static int currentlevelvalue=1;
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
		Scene startscreen = new Scene(start.getStartScreen(),gamescreenwidth,gamescreenheight);
		
		//GENERATE INFO SCREEN//
		//SINGLETON DESIGN PATTERN
		InfoScreen info = InfoScreen.getInstance();
		Scene infoscreen = new Scene(info.getInfoScreen(),gamescreenwidth,gamescreenheight);
		
		
		//GENERATE LEVELS FOR GAME SCREEN//
		
	    level1 = new Level1();//create an empty stage
	    level1scene  = new Scene(level1,gamescreenwidth,gamescreenheight);//set up the scene/screen 
	    level2 = new Level2();
	    level2scene = new Scene(level2,gamescreenwidth,gamescreenheight);
	    level3 = new Level3();
	    level3scene = new Scene(level3,gamescreenwidth,gamescreenheight);
	    level4 = new Level4();
	    level4scene = new Scene(level4,gamescreenwidth,gamescreenheight);
	    level5 = new Level5();
	    level5scene = new Scene(level5,gamescreenwidth,gamescreenheight);
	  		
	    
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
				primaryStage.setScene(level1scene);
				level1.start();
				level1.createMusic();
				level1.setStage(primaryStage);
				//
				if(primaryStage == level1.getStage()) System.out.println("PrimaryStage Passed for level1 -- checked");
				//
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
	  	start();  //start timer for the whole game, play music
	  		
	}
	
	
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	
            	//UPDATE SCORE OF ANIMAL AT EACH LEVEL//
            	
            	if (level1.animalchangeScore() && currentlevelvalue==1) {
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
        	 		
        	 		//highscoreflag=true; }
        	 		//if(highscoreflag){
        	 
        	 		//GENERATE HIGHSCORE POP UP//
        	 		HighScoreModel highscoremodel = new HighScoreModel(username,level5.getlevelPoints());
        			HighScoreView highscoreview = new HighScoreView(level5.getlevelPoints());
        	 		HighScoreController highscorecontroller = new HighScoreController(highscoremodel,highscoreview);
        			//HighScoreController highscorecontroller = new HighScoreController(username,level5.getcurrentlevelAnimal().getPoints(), highscoreview);
            		ArrayList<String> scorelist = highscorecontroller.retrievingHighScore();
            		int rank=1;
					for (String currenthighscore : scorelist) {
						if(rank<6) {
							//highscorepopup.addscoretopopupview(times,currentline);
							highscorecontroller.updateView(rank,currenthighscore);
							rank++;
						}
						else {
							break;
						}
					}			
					highscoreview.finishup();//finish up the HIGHSCORE view - add group()
        		
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
					
            	}
        	 
            	/*if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            		
           		*/
            	
            }
        };
    }
	
	
	
	public void start() {
		//level1.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    
    //set points display on game screen
    public void setNumber(int n, MyStage currentlevel) {
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
    	
    }
    
    public void levelUp(MyStage currentlevel, MyStage nextlevel, Scene nextlevelscene) {
		// TODO Auto-generated method stub

		Stage primaryStage = currentlevel.getStage();
		nextlevel.setStage(primaryStage);
		System.out.println("PrimaryStage passed for" + nextlevel.getClass().getSimpleName());
	 	nextlevel.setlevelPoints(currentlevel.getlevelPoints());
	 	setNumber(nextlevel.getlevelPoints(), nextlevel);
	 	
	 	//
	 	if(currentlevel.getlevelPoints()==nextlevel.getlevelPoints()) {
	 		System.out.println(nextlevel.getClass().getSimpleName() + "start with the points as " + currentlevel.getClass().getSimpleName());
	 		
	 	}
	 	//
	 	
	 	currentlevel.stopMusic();
	 	currentlevel.stop();
	 	currentlevelvalue++;
	 	primaryStage.setScene(nextlevelscene);
	 	nextlevel.start();
	 	nextlevel.createMusic();
	 	
	 	
	}
    
    
    
    
}
