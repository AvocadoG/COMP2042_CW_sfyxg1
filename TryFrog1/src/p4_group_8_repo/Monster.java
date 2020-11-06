package p4_group_8_repo;

import javafx.scene.image.Image;

public class Monster extends Actor{

	private double speed;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		move(speed,0);
		if(getX()>600 && speed>0) {
			setX(600);
			speed=-speed;
			setImage(new Image("file:src/froggertextures/monster2.png",50,50,false,true));
		}
		if(getX()<0 && speed<0) {
			setX(0);
			speed=-speed;
			setImage(new Image("file:src/froggertextures/monster1.png",50,50,false,true));

		}
	}
	
	public Monster(String ImageLink, int size, int posX, int posY, double s) {
		setImage(new Image(ImageLink,size,size,false,true));
		setX(posX);
		setY(posY);
		speed=s;
		
		
	}

}
