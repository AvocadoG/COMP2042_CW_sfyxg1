package froggerActors;

import froggerMaterialGenerator.ImageGenerator;
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
	
	/**
	 * This constructor will create a {@code Monster} object with display
	 * @param size size of {@code Monster}
	 * @param posX x position of {@code Monster} in the game scene
	 * @param posY y position of {@code Monster} in the game scene
	 * @param s moving speed of {@code Monster} in the game
	 */
	public Monster(int size, int posX, int posY, double s) {

		
		ImageGenerator imggenerator = new ImageGenerator();
		monsterImg1 = imggenerator.generate("file:src/main/resources/froggertextures/monster1.png",size,size);
		monsterImg2 = imggenerator.generate("file:src/main/resources/froggertextures/monster2.png",size,size);
		
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


}
