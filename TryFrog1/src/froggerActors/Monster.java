package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the Monster in the game. It will eat Animal.
 * @author User
 *
 */
public class Monster extends Actor{

	private double speed;
	private Image monsterImg1;
	private Image monsterImg2;
	private int imgwidth,imgheight;
	
	/**
	 * Defines how {@code Monster} will act in the game.<br>
	 * Monster will move back and forth in the game, each time changing its color.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		move(speed,0);
		if(getX()>600 && speed>0) {
			setX(600);
			speed=-speed;
			setImage(monsterImg2);
		}
		if(getX()<0 && speed<0) {
			setX(0);
			speed=-speed;
			setImage(monsterImg1);
		}
	}
	
	
	/**
	 * This constructor will create a {@code Monster} object 
	 * @param size size of {@code Monster}
	 * @param posX x position of {@code Monster} in the game scene
	 * @param posY y position of {@code Monster} in the game scene
	 * @param s moving speed of {@code Monster} in the game
	 */
	public Monster(int size, int posX, int posY, double s) {

		this.imgwidth=size;
		this.imgheight=size;
		monsterImg1 = createImage("file:src/froggertextures/monster1.png");
		monsterImg2 = createImage("file:src/froggertextures/monster2.png");
		setImage(monsterImg1);
		setX(posX);
		setY(posY);
		speed=s;
		
		
	}


	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth, this.imgheight,true,true);
		return img;
	}

}
