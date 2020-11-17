package froggerAnimal_Actions;

public class AnimalDeathContext {

	private AnimalDeath animaldeath;
	
	AnimalDeathContext(AnimalDeath animaldeath){
		this.animaldeath=animaldeath;
	}
	
	public void executeAction( long now) {
		 animaldeath.doAction(now);
	}
}
