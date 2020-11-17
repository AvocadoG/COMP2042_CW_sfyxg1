package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the destination {@link p4_group_8_repo.Animal} should reach to win the game.<br>
 * There are 3 types of {@code End} : an <i>empty</i> End, an End with a <i>coin</i>, an <i>activated</i> End that has been reached by {@link p4_group_8_repo.Animal}.
 *
 */
public class End extends Actor{
	
	private Image endcoinImg, endImg, endfrogImg;
	private int imgwidth,imgheight=60;
	private double flash=0;//time in seconds for animation

	/**
	 * determine if the {@code End} has been reached by the {@link p4_group_8_repo.Animal}.<br>
	 * <b>true</b> if it has been reached by the Animal
	 */
	private boolean activated = false;//check if END has been entered
	
	/**
	 * determine if the {@code End} has a coin<br>
	 * <b>true</b> if it has a coin
	 */
	private boolean hasCoin = false;//check if END has Coin
	
	
	/**
	 * {@inheritDoc}<br>
	 * Defines the behavior of {@code End} in the game.The {@code End} with a <i>coin</i> will flash during the game. For animation purpose.
	 */
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
	 * This constructor will create an End object. 
	 * @param x the x position of the {@code End} in the game scene
	 * @param y the y position of the {@code End} in the game scene
	 * @param coin if the {@code End} should have a coin
	 */
	public End(int x, int y, boolean coin) {
		setX(x);
		setY(y);
		endcoinImg = createImage("file:src/froggertextures/EndCoin.png");
		endImg = createImage("file:src/froggertextures/End.png");
		endfrogImg = createImage("file:src/froggertextures/FrogEnd.png");
		
		if(coin==true) {
			setImage(endcoinImg);
			hasCoin=coin;
		}
		else {
			setImage(endImg);
		}
	}
	
	
	/**
	 * Called when {@code End} has been reached by {@link p4_group_8_repo.Animal}.
	 * It will mark the {@code End} as <i>activated</i> 
	 */
	public void setEnd() {
		setImage(endfrogImg);
		activated = true;
		hasCoin = false;
	}
	
	
	/**
	 * Called to check if the {@code End} has been reached by the Animal.
	 * 
	 * @return boolean <b>true</b> if it has been reached by the Animal<br>
	 * See also : {@link End#activated}
	 */
	public boolean isActivated() {
		return activated;
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
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}
	

}
