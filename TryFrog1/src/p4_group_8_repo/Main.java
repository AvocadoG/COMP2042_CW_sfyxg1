package p4_group_8_repo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	StartScreen start;
	InfoScreen info;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		//GENERATE START SCREEN//
		
		start = new StartScreen("file:src/froggertextures/startscreenfrogger.png");
		Scene startscreen = new Scene(start.getStartScreen(),600,800);
		
		//GENERATE INFO SCREEN//

		info = new InfoScreen("file:src/froggertextures/infoscreenfrogger.png");
		Scene infoscreen = new Scene(info.getInfoScreen(),600,800);
		
		
		background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
	    	//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
	  		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
	  		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

	  	    //change froggerback image link
	  		BackgroundImage froggerback = new BackgroundImage("file:src/froggertextures/iKogsKW.png");
	  	    
	  		background.add(froggerback);
	  		
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75));
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 220, 166, 0.75));
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 440, 166, 0.75));
	  		//background.add(new Log("file:src/froggertextures/log3.png", 150, 0, 166, 0.75));
	  		background.add(new Log("file:src/froggertextures/logs.png", 300, 0, 276, -2));
	  		background.add(new Log("file:src/froggertextures/logs.png", 300, 400, 276, -2));
	  		//background.add(new Log("file:src/froggertextures/logs.png", 300, 800, 276, -2));
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 50, 329, 0.75));
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 270, 329, 0.75));
	  		background.add(new Log("file:src/froggertextures/log3.png", 150, 490, 329, 0.75));
	  		//background.add(new Log("file:src/froggertextures/log3.png", 150, 570, 329, 0.75));
	  		
	  		background.add(new Turtle(500, 376, -1, 130, 130));
	  		background.add(new Turtle(300, 376, -1, 130, 130));
	  		background.add(new WetTurtle(700, 376, -1, 130, 130));
	  		background.add(new WetTurtle(600, 217, -1, 130, 130));
	  		background.add(new WetTurtle(400, 217, -1, 130, 130));
	  		background.add(new WetTurtle(200, 217, -1, 130, 130));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
	  		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
	  		//End end2 = new End();
	  		//End end3 = new End();
	  		//End end4 = new End();
	  		//End end5 = new End();
	  		background.add(new End(13,96));
	  		background.add(new End(141,96));
	  		background.add(new End(141 + 141-13,96));
	  		background.add(new End(141 + 141-13+141-13+1,96));
	  		background.add(new End(141 + 141-13+141-13+141-13+3,96));
	  		animal = new Animal("file:src/froggertextures/froggerUp.png");
	  		background.add(animal);
	  		background.add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 0, 649, 1, 120, 120));
	  		background.add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 300, 649, 1, 120, 120));
	  		background.add(new Obstacle("file:src/froggertextures/truck1"+"Right.png", 600, 649, 1, 120, 120));
	  		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
	  		background.add(new Obstacle("file:src/froggertextures/car1Left.png", 100, 597, -1, 50, 50));
	  		background.add(new Obstacle("file:src/froggertextures/car1Left.png", 250, 597, -1, 50, 50));
	  		background.add(new Obstacle("file:src/froggertextures/car1Left.png", 400, 597, -1, 50, 50));
	  		background.add(new Obstacle("file:src/froggertextures/car1Left.png", 550, 597, -1, 50, 50));
	  		background.add(new Obstacle("file:src/froggertextures/truck2Right.png", 0, 540, 1, 200, 200));
	  		background.add(new Obstacle("file:src/froggertextures/truck2Right.png", 500, 540, 1, 200, 200));
	  		background.add(new Obstacle("file:src/froggertextures/car1Left.png", 500, 490, -5, 50, 50));
	  		//change score display position
	  		background.add(new Digit(0, 30, 550, 25));
	  		//background.add(obstacle);
	  		//background.add(obstacle1);
	  		//background.add(obstacle2);
	  		
	  		
	  	//set startbtn action
	  	//if startbtn is clicked
	  	//if username exists, go to maingamescreen
	  	//else alert for username input
		start.getstartbtn().setOnMouseClicked(event-> {
			if(start.getusername()!= null) {
				primaryStage.setScene(scene);
				background.start();
				//start timer for background stage -activation-
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Enter a username first!");
				alert.show();
			}
	    });
		
		
		//set infobtn action
		//if info button is clicked, switch to INFO SCREEN
		start.getinfobtn().setOnMouseClicked(event -> {
			primaryStage.setScene(infoscreen);
		});
				
		
		//set exitbtn action
		start.getexitbtn().setOnMouseClicked(event -> {
			Platform.exit();
		});
		
		
		//set backtostartbtn action
		//if backtostart button is clicked, switch to START SCREEN
		info.getbacktostartbtn().setOnMouseClicked(event -> {
			primaryStage.setScene(startscreen);
		});
		
		
		//initialize the stage with start screen
	  	primaryStage.setScene(startscreen);
	  	primaryStage.show();
	  	start();  //start timer for the whole stage
	  		
	}
	
	
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		
            		/*Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();*/
            		
            		
            		//GENERATE HIGH SCORE POP UP//
            		//controller : set, sort, get highscores-username
            		//highscorepopup view : define how the highscorepopup is viewed
            		//highscoremodel : information of username and the score 
            		
            		HighScoreController rw = new HighScoreController(start.getusername(),animal.getPoints());
            		HighScoreView highscorepopup = new HighScoreView(animal.getPoints());
            		//retrieving the scores and adding it to an ArrayList
            		ArrayList<String> scorelist = rw.retrievingHighScore(); 
            		
            		//to display only the Top 5 HighScores
            		int times=1;
					for (String currentline : scorelist) {
						if(times<6) {
							highscorepopup.addscoretopopupview(times,currentline);
							times++;
						}
						else {
							break;
						}
					}
					
					//finishing up highscoreview
					highscorepopup.updatepopupview();
            		
					//generating HighScore Scene and Stage
					Scene highscore = new Scene(highscorepopup.gethighscorepopup(),400,500);
            		Stage highscorestage = new Stage();
            		highscorestage.setTitle("Game End");
            		highscorestage.initModality(Modality.APPLICATION_MODAL);
            		//set the HighScore Scene to the Stage
            		highscorestage.setScene(highscore);
            		highscorestage.show();
            		
            		//set highscore quitbtn action
            		//if quitbtn is clicked, close the popup and exit the game
            		highscorepopup.getquitbtn().setOnMouseClicked(event -> {
            			highscorestage.close();
            			Platform.exit();
            		});
            		
            		//set highscore popup close icon action
            		//if highscore popup is closed, exit the game
            		highscorestage.setOnCloseRequest(event -> {
            			Platform.exit();
            		});
            		
            	}
            }
        };
    }
	
	
	
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    
    //set points display on game screen
    public void setNumber(int n) {
    	int shift = 0;
    	if(n<100) {//if points has 2 digits
        	while (n > 0) {
        		  int d = n / 10;
        		  int k = n - d * 10;
        		  n = d;
        		  background.add(new Digit(k, 30, 550 - shift, 25));
        		  shift+=30;
        	}
        	background.add(new Digit(0,30,550 - shift, 25));
        }
        	
        else if(n>=100) {//if points has 3digits
        	while (n > 0) {
          		  int d = n / 10;
          		  int k = n - d * 10;
          		  n = d;
          		  background.add(new Digit(k, 30, 550 - shift, 25));
          		  shift+=30;
          	}
        }
    }
}
