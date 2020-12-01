package froggerAnimal_Actions;

/**
 * <b>This class will refer and execute the action of a type of {@link froggerAnimal_Actions.AnimalDeath}</b>
 * .<br><i>Strategy Design Pattern</i> is applied here
 * @author GohXinYee
 *
 */
public class AnimalDeathContext {

	/**target {@link froggerAnimal_Actions.AnimalDeath}*/
	private AnimalDeath animaldeath;
	
	/**
	 * This constructor will create an {@code AnimalDeathContext} object that sets up the type of {@link froggerAnimal_Actions.AnimalDeath} to be executed.
	 * @param animaldeath the target animal death type to be executed
	 */
	public AnimalDeathContext(AnimalDeath animaldeath){
		this.animaldeath=animaldeath;
	}
	
	/**
	 * execute the action of the target {@link froggerAnimal_Actions.AnimalDeath}
	 * @param now execute at current time frame
	 */
	public void executeAction( long now) {
		 animaldeath.doAction(now);
	}
}
