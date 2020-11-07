package p4_group_8_repo;

import javafx.scene.image.Image;

public class Obstacle extends Actor{
	
	private double speed;
	private Image obstacleImg;
	private int imgwidth,imgheight;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		
		this.imgheight=h;
		this.imgwidth=w;
		obstacleImg = createImage(imageLink);
		//obstacleImg = createImage("");
		//this.w=w;this.h=h;
		//setImage(obstacleImg);
		setImage(obstacleImg);
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgwidth,this.imgheight,true,true);
		return img;
	}

}
