package froggerActors;

import javafx.scene.image.Image;

/**
 * <b>Represents the Monster in the game. It will eat {@link froggerAnimal_Actions.Animal}.
 * <br>
 * {@code Monster} is also an {@link froggerActors.Actor}</b>
 * 
 * @author GohXinYee
 *
 */
public class Monster extends Actor{

	private double speed;
	/** Image for {@code Monster}*/
	private Image monsterImg1,monsterImg2;
	private int imgwidth,imgheight;
	
	/**
	 * This constructor will create a {@code Monster} object with display
	 * @param size size of {@code Monster}
	 * @param posX x position of {@code Monster} in the game scene
	 * @param posY y position of {@code Monster} in the game scene
	 * @param s moving speed of {@code Monster} in the game
	 */
	public Monster(int size, int posX, int posY, double s) {

		this.imgwidth=size;
		this.imgheight=size;
		monsterImg1 = createImage("file:src/main/resources/froggertextures/monster1.png");
		monsterImg2 = createImage("file:src/main/resources/froggertextures/monster2.png");
		setImage(monsterImg1);
		setX(posX);
		setY(posY);
		speed=s;
		
		
	}


	/**
	 * Defines how {@code Monster} will act in the game.<br>
	 * Monster will move horizontally, back and forth in the game, changing its color in between.
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
	 * to create Images for {@code Monster} object.<br>
	 * Used exclusively by {@code Monster} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code Monster}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth, this.imgheight,true,true);
		return img;
	}

}
