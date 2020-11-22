package froggerAnimal_Actions;

/**
 * Represents a type of Animal Death.<br>
 * Particularly for when {@link froggerAnimal_Actions.Animal} get eaten by the Monster in the game
 *
 */
public class MonsterDeath implements AnimalDeath{

	/** target {@link froggerAnimal_Actions.Animal}*/	
	private Animal animal;
	/** determine if there is a monster death*/
	private boolean death;

	/**This constructor will create a {@code MonsterDeath} object
	 * @param animal the target {@link froggerAnimal_Actions.Animal} object to do action upon
	 * @param monsterDeath boolean, whether the target Animal has eaten by a monster
	 */
	MonsterDeath(Animal animal, boolean monsterDeath){
		this.animal=animal;
		this.death=monsterDeath;
		
	}
	
	/**
	 * To do an action upon the target Animal's monster death.
	 * @param now do an action right now 
	 */
	@Override
	public void doAction(long now) {
		// TODO Auto-generated method stub
		if (death) {
			animal.noMove = true;
			//animations purpose
			if ((now)% 11 ==0) {
				animal.monsterD++;
			}
			if (animal.monsterD==1) {		
				animal.setImage(animal.hitImg1);
			}
			if (animal.monsterD==2) {
				animal.setImage(animal.hitImg2);
			}
			if (animal.monsterD==3) {
				animal.setImage(animal.hitImg3);
			}
			if (animal.monsterD == 4) {
				animal.setX(300);
				animal.setY(679.8+animal.getmovementY());
				animal.monsterDeath = false;
				animal.monsterD = 0;
				animal.setImage(animal.imgW1);
				animal.noMove = false;

				//change points
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
