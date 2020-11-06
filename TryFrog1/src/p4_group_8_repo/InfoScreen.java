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
	
	private static InfoScreen infoscreen = new InfoScreen("file:src/froggertextures/infoscreenfrogger.png");
	
	private InfoScreen () {};
	
	private InfoScreen (String ImageLink){
		
		info = new Group();
		
		backtostart = createbtn("file:src/froggertextures/backtostartbtnfrogger.png");
				
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
				"The goals are sending Frogger to all the 5 empty ENDS on the other side. " +
				"Purple zones are the resting zones. Frogger has to avoid any trucks/cars/monsters on the way and cross the river by jumping onto Logs/Turtles.\n" +
				"Green turtles will submerge into the river from time to time. Red turtles will turn into Green turtles too! " +
				"When Frogger jumps onto the green turtle and the green turtle submerges, Frogger will sink into the river and die."+
				"\n\n10points for reaching each Empty End.\n5points for each successful forward movement.\n" +
				"MINUS 10points for getting hit by the Trucks/Cars/Monsters, sinking into the River, knocking on the grass block.\n" +
				"5 Levels in total, Level Up upon reaching all Ends at each Level.The speed of the game will increase as Frogger levels up."+
				"Level 4 & 5 are when the Monster comes!";
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
	
	public static InfoScreen getInstance() {
		return infoscreen;
	}
	
	
}
