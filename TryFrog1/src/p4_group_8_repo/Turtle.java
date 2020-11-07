package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	
	private Image turtleImg1;
	private Image turtleImg2;
	private Image turtleImg3;
	private int imagewidth, imageheight;
	private double speed;
	
	//int i = 1;
	//boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtleImg2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtleImg1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtleImg3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		
		this.imageheight=h;
		this.imagewidth=w;
		turtleImg1 = createImage("file:src/froggertextures/TurtleAnimation1.png");
		turtleImg2 = createImage("file:src/froggertextures/TurtleAnimation2.png");
		turtleImg3 = createImage("file:src/froggertextures/TurtleAnimation3.png");
		
		//turtleImg1 = new Image("file:src/froggertextures/TurtleAnimation1.png", w, h, true, true);
		//turtleImg2 = new Image("file:src/froggertextures/TurtleAnimation2.png", w, h, true, true);
		//turtleImg3 = new Image("file:src/froggertextures/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtleImg2);
	}
	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}
