package froggerAnimal_Actions;


public class MonsterDeath implements AnimalDeath{

	
	private Animal animal;
	private boolean death;

	MonsterDeath(Animal animal, boolean monsterDeath){
		this.animal=animal;
		this.death=monsterDeath;
		
	}
	
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
