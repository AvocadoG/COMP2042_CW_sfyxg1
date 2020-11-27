package froggerGameActions;

import froggerElements.Life;
import froggerLevels.Level;

/**
 * <b>Represents one of the Game Actions.<br>
 * Update the latest amount of {@link froggerElements.Life} {@link froggerAnimal_Actions.Animal} has.</b>
 * @author GohXinYee
 *
 */
public class UpdateLife implements GameAction{

	/** the target game {@link froggerLevels.Level} to show the latest life amount*/
	private Level level;
	
	/**
	 * This constructor will create an {@code UpdateLife} object
	 * @param level value for {@link UpdateLife#level}
	 */
	public UpdateLife(Level level){
		this.level=level;
	}
	
	/**
	 * update the latest amount of life Animal has in the target game level scene
	 */
	@Override
	public void doAction() {
		int life=level.getlevelLife();
		// TODO Auto-generated method stub
		level.add(new Life(life,40,500,60));

	}

}
