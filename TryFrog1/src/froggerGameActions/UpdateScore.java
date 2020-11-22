package froggerGameActions;

import froggerElements.Digit;
import froggerLevels.Level;
import javafx.scene.image.Image;

/**
 * Represents one of the Game Actions.<br>
 * Update the latest scores (via {@link froggerElements.Digit}) of {@link froggerAnimal_Actions.Animal}.
 * @author GohXinYee
 *
 */
public class UpdateScore implements GameAction{
	
	/** the target game {@link froggerLevels.Level} to show the latest score*/
	private Level level;
	
	/**
	 * This constructor will create an {@code UpdateScore} object
	 * @param level value for {@link UpdateScore#level}
	 */
	public UpdateScore(Level level){
		this.level=level;
	}
	
	
	/**
	 * update the latest score of Animal in the target game level scene
	 */
	@Override
	public void doAction() {
		
		int points=level.getlevelPoints();
		
		// TODO Auto-generated method stub
		int shift = 0;
    	
    	if(points<100) {//if points has 2 digits
        	while (points > 0) {
        		  int d = points / 10;
        		  int k = points - d * 10;
        		  points = d;
        		  level.add(new Digit(k, 30, 550 - shift, 25));
        		  shift+=30;
        	}
        	level.add(new Digit(0,30,550 - shift, 25));
        }
        	
        else if(points>=100) {//if points has 3digits
        	while (points > 0) {
          		  int d = points / 10;
          		  int k = points - d * 10;
          		  points = d;
          		  level.add(new Digit(k, 30, 550 - shift, 25));
          		  shift+=30;
          	}
        }
	}
	

	
	

}
