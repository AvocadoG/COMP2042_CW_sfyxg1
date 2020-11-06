package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	private boolean hasCoin = false;
	private double second=0;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
		if(hasCoin) {
			if((now)%11==0) {
				second++;
			}
			if(second==2) {
				setImage(new Image("file:src/p4_group_8_repo/End.png", 60, 60, true, true));
			}
			if(second==4) {
				setImage(new Image("file:src/p4_group_8_repo/EndCoin.png", 60,60,true,true));
				second=0;
			}
		}
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
