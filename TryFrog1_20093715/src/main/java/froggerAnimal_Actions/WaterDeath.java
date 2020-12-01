package froggerAnimal_Actions;

/**
 * <b>Represents a type of Animal Death.<br>
 * Particularly for when {@link froggerAnimal_Actions.Animal} drown into the river and die.</b>
 *
 */
public class WaterDeath implements AnimalDeath{

	/** target {@link froggerAnimal_Actions.Animal}*/
	private Animal animal;
	/** determine if Animal dies*/
	private boolean death;
	
	
	/**This constructor will create a {@code WaterDeath} object
	 * @param animal the target {@link froggerAnimal_Actions.Animal} object to do action upon
	 * @param waterDeath boolean, whether the target Animal has drown into the river die
	 */
	public WaterDeath(Animal animal, boolean waterDeath){
		this.animal=animal;
		this.death=waterDeath;
		
	}	
	
	/**
	 * To do an action upon the target Animal's water death.
	 * @param now do an action right now 
	 */
	@Override
	public void doAction(long now) {
		// TODO Auto-generated method stub
		if (death) {
			animal.noMove = true;
			if ((now)% 11 ==0) {
				animal.waterD++;
			}
			if (animal.waterD==1) {
				animal.setImage(animal.drownImg1);
			}
			if (animal.waterD==2) {
				animal.setImage(animal.drownImg2);
			}
			if (animal.waterD==3) {
				animal.setImage(animal.drownImg3);
			}
			if (animal.waterD == 4) {
				animal.setImage(animal.drownImg4);
			}
			if (animal.waterD == 5) {
				animal.setX(300);
				animal.setY(679.8+animal.getmovementY());
				animal.waterDeath = false;
				animal.waterD = 0;
				animal.setImage(animal.imgW1);
				animal.noMove = false;
				
				//change
				if(animal.getPoints()>10) {
					animal.setPoints(animal.getPoints()-10);
					animal.changeScore=true;
				}
				
				animal.setLife(animal.getLife()-1);
				animal.changeLife=true;
				
			}
			
		}
	}

}
