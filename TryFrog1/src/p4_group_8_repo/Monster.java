package p4_group_8_repo;

import javafx.scene.image.Image;

public class Monster extends Actor{

	private double speed;
	private Image monsterImg1;
	private Image monsterImg2;
	private int imgwidth,imgheight;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		move(speed,0);
		if(getX()>600 && speed>0) {
			setX(600);
			speed=-speed;
			setImage(monsterImg2);
			//setImage(new Image("file:src/froggertextures/monster2.png",50,50,false,true));
		}
		if(getX()<0 && speed<0) {
			setX(0);
			speed=-speed;
			setImage(monsterImg1);
			//setImage(new Image("file:src/froggertextures/monster1.png",50,50,false,true));

		}
	}
	
	public Monster(int size, int posX, int posY, double s) {

		this.imgwidth=size;
		this.imgheight=size;
		monsterImg1 = createImage("file:src/froggertextures/monster1.png");
		monsterImg2 = createImage("file:src/froggertextures/monster2.png");
		setImage(monsterImg1);
		//setImage(new Image(ImageLink,size,size,false,true));
		setX(posX);
		setY(posY);
		speed=s;
		
		
	}

	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth, this.imgheight,false,true);
		return img;
	}

}
