package froggerAnimal_Actions;


public class WaterDeath implements AnimalDeath{

	private Animal animal;
	private boolean death;
	
	WaterDeath(Animal animal, boolean waterDeath){
		this.animal=animal;
		this.death=waterDeath;
		
	}	
	
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
