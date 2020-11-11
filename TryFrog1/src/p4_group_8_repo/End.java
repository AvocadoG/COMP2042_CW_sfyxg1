package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Represents the destination the {@link p4_group_8_repo.Animal} should reach to win the game.<br>
 * There are three types of {@code End} : an empty End, an activated End with a coin for bonus game points, an End that has been reached by the Animal.
 * @author User
 *
 */
public class End extends Actor{
	
	private Image endcoinImg, endImg, endfrogImg;
	private int imgwidth,imgheight=60;
	private double second=0;//timein seconds for animation

	/**
	 * determine if the End has been reached by the Animal.<br>
	 * <b>true</b> if it has been reached by the Animal
	 */
	private boolean activated = false;//check if END has been entered
	
	/**
	 * determine if the End has a coin<br>
	 * <b>true</b> if it has a coin
	 */
	private boolean hasCoin = false;//check if END has Coin
	
	
	/**
	 * 
	 * Defines the behavior of End in the game.The End with a coin will flash during the game. For animation purpose.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
		if(hasCoin) {
			if((now)%11==0) {
				second++;
			}
			if(second==2) {
				setImage(endImg);
				//setImage(new Image("file:src/froggertextures/End.png", 60, 60, true, true));
			}
			if(second==4) {
				setImage(endcoinImg);
				//setImage(new Image("file:src/froggertextures/EndCoin.png", 60,60,true,true));
				second=0;
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
			//setImage(new Image("file:src/froggertextures/EndCoin.png", 60,60,true,true));
			hasCoin=coin;
		}
		else {
			setImage(endImg);
			//setImage(new Image("file:src/froggertextures/End.png", 60, 60, true, true));
		}
	}
	
	/**
	 * Called when the {@code End} has been reached by the {@link p4_group_8_repo.Animal}.
	 * It will mark the End as activated. 
	 */
	public void setEnd() {
		setImage(endfrogImg);
		//setImage(new Image("file:src/froggertextures/FrogEnd.png", 60, 60, true, true));
		activated = true;
		hasCoin = false;
	}
	
	/**
	 * Called to check if the {@code End} has previously been reached by the Animal.
	 * 
	 * @return <b>true</b> if it has been reached by the Animal
	 * See also : {@link End#activated}
	 */
	public boolean isActivated() {
		return activated;
	}


	/**
	 * Called to check if the {@code End} comes with a coin.
	 * 
	 * @return <b>true</b> if the {@code End} has a coin
	 * See also : {@link End#hasCoin}
	 */
	public boolean hasCoin() {
		return hasCoin;
	}


	/**
	 * {@inheritDoc} for different types of {@code End} objects
	 */
	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}
	

}
