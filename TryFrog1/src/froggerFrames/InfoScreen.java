package froggerFrames;

import DisplayGenerator.*;
import froggerElements.BackgroundImage;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Represents the Information Screen of the game.<br>
 * <b>Singleton Design Pattern</b> is applied to this class, so there is only <b>one</b> {@code InfoScreen} instance throughout the game.
 * @author GohXinYee
 *
 */
public class InfoScreen {

	private Group infogroup;
	private Button backtostart;
	private VBox infoscreenVBox;
	private ButtonDisplayGenerator bgenerator;
	private TextDisplayGenerator tgenerator;
	
	
	private static InfoScreen infoscreen;
	
	
	/**private default constructor*/
	private InfoScreen () {};
	
	/**
	 * This constructor will create an {@code InfoScreen} object, with instructions to play the game.<br>
	 * The constructor is declared private to ensure that no other classes can create another {@code InfoScreen} instance.
	 * @param ImageLink the link of the background image of {@code InfoScreen}
	 */
	private InfoScreen (String ImageLink){
		
		/*bgenerator = new ButtonDisplayGenerator(140,50);
		backtostart = bgenerator.generatebtn("file:src/froggertextures/backtostartbtnfrogger.png");
		
		tgenerator = new TextDisplayGenerator("ChickenPie",20,TextAlignment.CENTER);
		Text subheading = tgenerator.generatetxt("How to Play??");
		tgenerator = new TextDisplayGenerator("Phosb___",15,TextAlignment.JUSTIFY);
		Text instructions = tgenerator.generatetxt(getinstructions());*/
		
		//generate a background image
	    BackgroundImage infobackground = new BackgroundImage(ImageLink,613,800);
	    
		//create a back-to-start button
		backtostart = createbtn("file:src/froggertextures/backtostartbtnfrogger.png");
		
		//create subheading and instructions text
		Text subheading = createText("How to Play??", "ChickenPie",20);
		Text instructions = createText(getinstructions(),"Phosb___",15);
	    
	    //set up a VBox to add in the elements
		infoscreenVBox = new VBox(15,subheading,instructions,backtostart);
	    infoscreenVBox.setMinSize(600,800);
	    infoscreenVBox.setMaxSize(600, 800);
	    infoscreenVBox.setAlignment(Pos.CENTER);
	    

	    //create a Group as parent
	    //add the elements to a parent Group
	  	infogroup = new Group();
		infogroup.getChildren().addAll(infobackground,infoscreenVBox);
	}
	
	
	


	/**
	 * to retrieve the {@code InfoScreen} instance
	 * @return {@code InfoScreen} instance
	 */
	public static InfoScreen getInstance() {
		
		if(infoscreen==null) {
			infoscreen = new InfoScreen("file:src/froggertextures/infoscreenfrogger.png");
		}
		return infoscreen;
	}

	
	/**
	 * access the parent of all the elements in an {@code InfoScreen} 
	 * @return {@code Group} the parent element
	 */
	public Group getInfoScreenGroup() {
		return infogroup;
	}
	
	/**
	 * retrieve the back-to-start button on {@code InfoScreen}
	 * @return {@link InfoScreen#backtostart} {@code Button} element
	 */
	public Button getbacktostartbtn() {
		VBox vbox = (VBox) getInfoScreenGroup().getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	/**
	 * Retrieve game instructions
	 * @return the game instructions in String format
	 */
	public String getinstructions() {
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
				"MINUS 10points for getting hit by the Trucks/Cars/Monsters and sinking into the River. MINUS 5points for bumping into the grass block.\n" +
				"5 Levels in total, Level Up upon reaching all Ends at each Level.The speed of the game will increase as Frogger levels up."+
				"Level 4 & 5 are when the Monster comes!";
	}

	
	
	
	///SCREENGENERATOR INTERFACE IMPLEMENTATION////
	/**{@inheritDoc} for {@code InfoScreen}*/

	private Button createbtn(String BtnImageLink) {
		// TODO Auto-generated method stub
		Button btn = new Button();
	    btn.setMinSize(140,50);
	    btn.setMaxSize(140,50);
		Image btnImg = new Image(BtnImageLink);
		btn.setGraphic(new ImageView(btnImg));
		return btn;
	}
	
	/** {@inheritDoc} for {@code InfoScreen} */
	
	private Text createText(String text, String fonttype, int textsize) {
		// TODO Auto-generated method stub
		Text txt = new Text(text);
	    txt.setWrappingWidth(500);
	    txt.setTextAlignment(TextAlignment.JUSTIFY);
	    txt.setLineSpacing(3);
	    txt.setFont(Font.loadFont("file:src/froggerfonts/"+fonttype+".ttf", textsize));
		return txt;
	}
	
	
	
	
	
}
