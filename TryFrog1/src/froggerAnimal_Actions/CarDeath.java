package froggerAnimal_Actions;

public class CarDeath implements AnimalDeath{

	
	private Animal animal;
	private boolean death;
	
	CarDeath(Animal animal, boolean carDeath){
		this.animal=animal;
		this.death=carDeath;
		
	}
	
	
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
