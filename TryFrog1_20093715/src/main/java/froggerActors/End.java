package froggerActors;

import javafx.scene.image.Image;

/**
 * <b>Represents the destination {@link froggerAnimal_Actions.Animal} should reach to win the game.<br>
 * There are 3 types of {@code End} : an <i>empty</i> End, an End with a <i>coin</i>, an <i>occupied</i> End that has been reached by {@link froggerAnimal_Actions.Animal}.
 * <br>
 * {@code End} is also an {@link froggerActors.Actor}</b>
 */
public class End extends Actor{
	
	/** Image for an empty End with a coin*/
	private Image endcoinImg;
	/** Image for an Empty End without coin*/
	private Image endImg;
	/** Image for an occupied End by the Frog*/
	private Image endfrogImg;
	private int imgwidth,imgheight=60;
	/** for flash animation effect of End*/
	private double flash=0;

	
	/**
	 * determine if {@code End} object has been occupied by {@link froggerAnimal_Actions.Animal}.<br>
	 * <b>true</b> if it has been occupied by the Animal
	 */
	private boolean occupied = false;//check if END has been entered
	
	/**
	 * determine if {@code End} object has a coin<br>
	 * <b>true</b> if it has a coin
	 */
	private boolean hasCoin = false;//check if END has Coin
	
	
	/**
	 * This constructor will create an {@code End} object with a display.
	 * @param x the x position of {@code End} object in the game scene
	 * @param y the y position of {@code End} object in the game scene
	 * @param coin whether the {@code End} should have a coin
	 */
	public End(int x, int y, boolean coin) {
		setX(x);
		setY(y);
		//setting up images//
		endcoinImg = createImage("file:src/main/resources/froggertextures/EndCoin.png");
		endImg = createImage("file:src/main/resources/froggertextures/End.png");
		endfrogImg = createImage("file:src/main/resources/froggertextures/FrogEnd.png");
		
		if(coin==true) {
			setImage(endcoinImg);
			hasCoin=coin;
		}
		else {
			setImage(endImg);
		}
	}
	
	
	/**Defines the behavior of {@code End} in the game.The {@code End} with a <i>coin</i> will flash during the game. For animation purpose. */
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
		if(hasCoin) {
			if((now)%11==0) {
				flash++;
			}
			if(flash==2) {
				setImage(endImg);
			}
			if(flash==4) {
				setImage(endcoinImg);
				flash=0;
			}
		}
	}


	/**
	 * 
	 * Set the {@code End} as <i>occupied</i> and with no <i>coin</i><br>
	 * This is for when {@code End} has been reached by {@link froggerAnimal_Actions.Animal}.
	 */
	public void setEndOccupied() {
		setImage(endfrogImg);
		occupied = true;
		hasCoin = false;
	}
	
	
	/**
	 * Check if the {@code End} has been occupied by the {@link froggerAnimal_Actions.Animal} (Frog).
	 * 
	 * @return boolean <b>true</b> if it has been occupied by the {@link froggerAnimal_Actions.Animal}<br>
	 * See also : {@link End#occupied}
	 */
	public boolean isOccupied() {
		return occupied;
	}


	/**
	 * Called to check if the {@code End} comes with a <i>coin</i>
	 * 
	 * @return boolean <b>true</b> if the {@code End} has a coin<br>
	 * See also : {@link End#hasCoin}
	 */
	public boolean hasCoin() {
		return hasCoin;
	}


	//used in End class only
	/**
	 * to create Images for {@code End} object.<br>
	 * Used exclusively by {@code End} object only.
	 * @param ImageLink the link of the image to be created
	 * @return {@code Image} a created image for {@code End}
	 */
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}
	

}
