package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	
	private Image endcoinImg, endImg, endfrogImg;
	private int imgwidth,imgheight=60;
	private boolean activated = false;//check if END has been entered
	private boolean hasCoin = false;//check if END has Coin
	private double second=0;//timein seconds for animation
	
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
	

	public End(int x, int y, boolean coin) {
		setX(x);
		setY(y);
		endcoinImg = createImage("file:src/froggertextures/EndCoin.png");
		endImg = createImage("file:src/froggertextures/End.png");
		endfrogImg = createImage("file:src/froggertextures/FrogEnd.png");
		
		if(coin) {
			setImage(endcoinImg);
			//setImage(new Image("file:src/froggertextures/EndCoin.png", 60,60,true,true));
			hasCoin=coin;
		}
		else {
			setImage(endImg);
			//setImage(new Image("file:src/froggertextures/End.png", 60, 60, true, true));
		}
	}
	
	public void setEnd() {
		setImage(endfrogImg);
		//setImage(new Image("file:src/froggertextures/FrogEnd.png", 60, 60, true, true));
		activated = true;
		hasCoin = false;
	}
		
	public boolean isActivated() {
		return activated;
	}


	public boolean hasCoin() {
		return hasCoin;
	}


	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}
	

}
