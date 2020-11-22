package froggerAnimal_Actions;

/**
 * Represents a type of Animal Death.<br>
 * Particularly for when {@link froggerAnimal_Actions.Animal} get hit by the Cars/Trucks in the game
 *
 */
public class CarDeath implements AnimalDeath{

	/** target {@link froggerAnimal_Actions.Animal}*/
	private Animal animal;
	/** determine if there is a car death*/
	private boolean death;
	
	/**This constructor will create a {@code CarDeath} object
	 * @param animal the target {@link froggerAnimal_Actions.Animal} object to do action upon.
	 * @param carDeath boolean, whether the target Animal has hit by the cars/trucks
	 */
	CarDeath(Animal animal, boolean carDeath){
		this.animal=animal;
		this.death=carDeath;	
	}
	
	/**
	 * To do an action upon the target Animal's car death.
	 * @param now do an action right now 
	 */
	@Override
	public void doAction(long now) {
		
		// TODO Auto-generated method stub
		if(death) {
			animal.noMove = true;
			
			if ((now)% 11 ==0) {
				animal.carD++;
			}
			if (animal.carD==1) {
				animal.setImage(animal.hitImg1);
			}
			if (animal.carD==2) {
				animal.setImage(animal.hitImg2);
			}
			if (animal.carD==3) {
				animal.setImage(animal.hitImg3);
			}
			if (animal.carD == 4) {
				animal.setX(300);
				animal.setY(679.8+ (animal.getmovementY()));
				animal.carDeath = false;
				animal.carD = 0;
				animal.setImage(animal.imgW1);
				animal.noMove = false;

				//change
				if(animal.getPoints()>10) {
					animal.setPoints((animal.getPoints())-10);
					animal.changeScore=true;
				}
				animal.setLife((animal.getLife())-1);
				animal.changeLife=true;
			}
			
		
		}
		
	}

}
