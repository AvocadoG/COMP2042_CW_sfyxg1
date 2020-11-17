package froggerActors;

import javafx.scene.image.Image;

/**
 * Represents the Red Turtle in Frogger Game.
 * @author User
 *
 */
public class Turtle extends Actor{
	
	private Image turtleImg1;
	private Image turtleImg2;
	private Image turtleImg3;
	private int imagewidth, imageheight;
	private double speed;
	
	/**
	 * defines how {@code Turtle} will act in the game.
	 * Turtle will move either from left to right or right to left with animations.
	 */
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
	
	
	/**
	 * This constructor will create a {@code Turtle} object in the game
	 * @param xpos x position of {@code Turtle} object in the game
	 * @param ypos y position of {@code Turtle} object in the game
	 * @param s moving speed of {@code Turtle} object in the game
	 * @param w width of {@code Turtle} object in the game
	 * @param h height of {@code Turtle} object in the game
	 */
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		
		this.imageheight=h;
		this.imagewidth=w;
		turtleImg1 = createImage("file:src/froggertextures/TurtleAnimation1.png");
		turtleImg2 = createImage("file:src/froggertextures/TurtleAnimation2.png");
		turtleImg3 = createImage("file:src/froggertextures/TurtleAnimation3.png");
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtleImg2);
	}
	
	
	public double getSpeed() {
		return speed;
	}


	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imagewidth,this.imageheight,true,true);
		return img;
	}
}

//turtleImg1 = new Image("file:src/froggertextures/TurtleAnimation1.png", w, h, true, true);
		//turtleImg2 = new Image("file:src/froggertextures/TurtleAnimation2.png", w, h, true, true);
		//turtleImg3 = new Image("file:src/froggertextures/TurtleAnimation3.png", w, h, true, true);