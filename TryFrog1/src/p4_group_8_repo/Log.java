package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	private Image logImg;
	private int imagewidth,imageheight;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		
		this.imageheight=size;
		this.imagewidth=size;
		logImg = createImage(imageLink);
		setImage(logImg);
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean goingLeft() {
		return speed < 0;
	}

	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}
