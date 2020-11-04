package p4_group_8_repo;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InfoScreen implements ButtonGenerator{

	private Group info;
	private Button backtostart;
	private VBox infoscreenVBox;
	
	InfoScreen (String ImageLink){
		
		info = new Group();
		
		backtostart = createbtn("file:src/froggertextures/backtostartbtnfrogger.png");
		/*backtostart = new Button();
		backtostart.setMinSize(140,50);
		backtostart.setMaxSize(140,50);
		Image backtostartImg = new Image("file:src/froggertextures/backtostartbtnfrogger.png");
		backtostart.setGraphic(new ImageView(backtostartImg));*/
		
		//add instructions text 
		Text subheading = new Text("How To Play??");
		subheading.setFont(Font.loadFont("file:src/froggerfonts/ChickenPie.ttf", 20));
		Text instructions = new Text(setinstructions());
	    instructions.setWrappingWidth(500);
	    instructions.setTextAlignment(TextAlignment.JUSTIFY);
	    instructions.setLineSpacing(3);
	    instructions.setFont(Font.loadFont("file:src/froggerfonts/Phosb___.ttf", 15));
	    
	    infoscreenVBox = new VBox(15,subheading,instructions,backtostart);
	    infoscreenVBox.setMinSize(600,800);
	    infoscreenVBox.setMaxSize(600, 800);
	    infoscreenVBox.setAlignment(Pos.CENTER);
	    
	    BackgroundImage infobackground = new BackgroundImage(ImageLink);
	    
	    //append to Group info
		info.getChildren().addAll(infobackground,infoscreenVBox);
	}
	
	public Group getInfoScreen() {
		return info;
	}
	
	public Button getbacktostartbtn() {
		VBox vbox = (VBox) info.getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	String setinstructions() {
		return  "A key to move Frogger to the left\n" +
				"D key to move Frogger to the right\n" +
				"S key to move Frogger back\n" +
				"W key to make Frogger jump\n\n" +				                                                                     
				"RULES\n" +
				"The goals are sending Frogger to all the 5 empty boxes on the other side. " +
				"Purple zones are the resting zones. During the game, Frogger has to cross the road by avoiding any trucks and cars on the way. After that, Frogger has to cross the river by jumping onto Logs or Turtles.\n" +
				"There are two types of turtles, the red turtles are the regular ones while the green turtles will submerge into the river from time to time. Red turtles will turn into Green turtles too! " +
				"When Frogger jumps onto the green turtle and the green turtle submerges, Frogger will sink into the river and die."+
				"\n\n50points for reaching each Empty End.\n10points for each successful forward movement.\n" +
				"MINUS 50points for getting hit by the Trucks/Cars, sinking into the River, knocking on the grass block.\n" +
				"Game ends after ALL 5 Ends are reached.";
	}

	@Override
	public Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
	    btn.setMinSize(140,50);
	    btn.setMaxSize(140, 50);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	
}
