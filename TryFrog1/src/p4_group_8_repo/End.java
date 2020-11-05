package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	boolean hasCoin = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/froggertextures/End.png", 60, 60, true, true));
	}
	
	public End(int x, int y, boolean coin) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/froggertextures/EndCoin.png", 60,60,true,true));
		hasCoin=coin;
	}
	
	public void setEnd() {
		setImage(new Image("file:src/froggertextures/FrogEnd.png", 70, 70, true, true));
		activated = true;
		hasCoin = false;
	}
		
	public boolean isActivated() {
		return activated;
	}


	public boolean hasCoin() {
		return hasCoin;
	}
	

}
