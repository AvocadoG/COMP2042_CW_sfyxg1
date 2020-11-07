package p4_group_8_repo;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	
	private Image imgW1,imgA1, imgS1, imgD1;
	private Image imgW2,imgA2, imgS2, imgD2;
	private Image hitImg1,hitImg2,hitImg3;
	private Image drownImg1,drownImg2,drownImg3,drownImg4;
	private int imgSize = 40;//size of frog animation images

	private boolean secondAnimation = false;//check if second frog animation image is used
	
	private int level;//level of animal --- done setter
	private int points = 0;//initial points --- done setter getter
	private int end = 0;//how many ends have been reached

	private boolean noMove = false;//check if frog should move
	private double movement = 13.3333333*2;//set vertical movement
	private double movementX;//set horizontal movement --- done setter
	
	//check if following deaths happen on frog
	//check death methods created
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean monsterDeath = false;
	private int carD = 0; //for animation 
	private int waterD = 0;
	private int monsterD = 0;
	
	//boolean stop = false;
	private boolean changeScore = false;//check if frog updates scores
	
	//for recording latest previous y position of frog
	private double initialYposition = 800;
	
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		
		//interface Image Generator
		/*imgW1 = new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/froggertextures/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/froggertextures/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/froggertextures/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/froggertextures/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/froggertextures/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/froggertextures/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/froggertextures/froggerRightJump.png", imgSize, imgSize, true, true);*/
		
		imgW1 = createImage("file:src/froggertextures/froggerUp.png");
		imgA1 = createImage("file:src/froggertextures/froggerLeft.png");
		imgS1 = createImage("file:src/froggertextures/froggerDown.png");
		imgD1 = createImage("file:src/froggertextures/froggerRight.png");
		imgW2 = createImage("file:src/froggertextures/froggerUpJump.png");
		imgA2 = createImage("file:src/froggertextures/froggerLeftJump.png");
		imgS2 = createImage("file:src/froggertextures/froggerDownJump.png");
		imgD2 = createImage("file:src/froggertextures/froggerRightJump.png");
		hitImg1 = createImage("file:src/froggertextures/cardeath1.png");
		hitImg2 = createImage("file:src/froggertextures/cardeath2.png");
		hitImg2 = createImage("file:src/froggertextures/cardeath3.png");
		drownImg1 = createImage("file:src/froggertextures/waterdeath1.png");
		drownImg2 = createImage("file:src/froggertextures/waterdeath2.png");
		drownImg3 = createImage("file:src/froggertextures/waterdeath3.png");
		drownImg4 = createImage("file:src/froggertextures/waterdeath4.png");
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (secondAnimation) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                secondAnimation = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 secondAnimation = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 secondAnimation = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 secondAnimation = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                secondAnimation = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 secondAnimation = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 secondAnimation = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 secondAnimation = true;
	            }
				}
			}
		});	
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	 
					if (getY() < initialYposition) {
						//if upwards movement is not entering an End, +5points
						//if it is an End no extra +5points
						if (getIntersectingObjects(End.class).size()<=0) {
						changeScore = true;
						initialYposition = getY();
						points+=5;
						//change to add 5 points every successful forward move
						
						}
					}
	                move(0, -movement);
	                setImage(imgW1);
	                secondAnimation = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 secondAnimation = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 secondAnimation = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 secondAnimation = false;
	            }
	        }
			}
			
		});
	}
	
	public void act(long now) {
		
		//to make sure frog doesn't get out of screen
		//up is 0, down is 734
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
		
	
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}

		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).goingLeft()) {
				if(level==1) move(-1,0);
				if(level==2 || level==4) move(-2,0);
				if(level==3 || level==5) move(-2*1.3,0);//move(xspeed,yspeed)
			}
			else {
				if(level==1) move(0.5,0);
				if(level==2 || level==4) move(.75,0);
				if(level==3 || level==5) move (.75*1.3,0);
			}
		}
		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			if (level==1) move(-0.5,0);//
			if (level==2 || level==4) move(-1,0);
			if (level==3 || level==5) move(-1*1.3,0);
		}
		
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				if(level==1) move(-0.5,0);//-1
				if(level==2 || level==4) move(-1,0);
				if (level==3 || level==5) move(-1*1.3,0);
			}
		}
		
		else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=10;
			}
			else if (getIntersectingObjects(End.class).get(0).hasCoin()) {
				points+=10;
			}
			points+=10;
			changeScore = true;
			initialYposition=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		
		else if(getIntersectingObjects(Monster.class).size() >= 1) {
			monsterDeath = true;
		}
		
		else if (getY()<413){
			waterDeath = true;
		}
		
		
		checkcarDeath(carDeath,now);
		checkwaterDeath(waterDeath,now);
		checkmonsterDeath(monsterDeath,now);
		
		
}
	
	
	//private checking, methods should only be called within the animal act 
	private void checkmonsterDeath(boolean mD, long now) {
		// TODO Auto-generated method stub
		if (mD) {
			noMove = true;
			if ((now)% 11 ==0) {
				monsterD++;
			}
			if (monsterD==1) {		
				setImage(hitImg1);
				//setImage(new Image("file:src/froggertextures/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (monsterD==2) {
				setImage(hitImg2);
				//setImage(new Image("file:src/froggertextures/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (monsterD==3) {
				setImage(hitImg3);
				//setImage(new Image("file:src/froggertextures/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (monsterD == 4) {
				setX(300);
				setY(679.8+movement);
				this.monsterDeath = false;
				monsterD = 0;
				setImage(imgW1);
				//setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;

				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
			}
			
		}
	}

	private void checkwaterDeath(boolean wD, long now) {
		// TODO Auto-generated method stub
		if (wD) {
			noMove = true;
			if ((now)% 11 ==0) {
				waterD++;
			}
			if (waterD==1) {
				setImage(drownImg1);
				//setImage(new Image("file:src/froggertextures/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (waterD==2) {
				setImage(drownImg2);
				//setImage(new Image("file:src/froggertextures/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (waterD==3) {
				setImage(drownImg3);
				//setImage(new Image("file:src/froggertextures/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (waterD == 4) {
				setImage(drownImg4);
				//setImage(new Image("file:src/froggertextures/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (waterD == 5) {
				setX(300);
				setY(679.8+movement);
				this.waterDeath = false;
				waterD = 0;
				setImage(imgW1);
				//setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				
				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
				
			}
			
		}
	}

	private void checkcarDeath(boolean cD, long now) {
		// TODO Auto-generated method stub
		if (cD) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(hitImg1);
				//setImage(new Image("file:src/froggertextures/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(hitImg2);
				//setImage(new Image("file:src/froggertextures/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(hitImg3);
				//setImage(new Image("file:src/froggertextures/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				this.carDeath = false;
				carD = 0;
				setImage(imgW1);
				//setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;

				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
			}
			
		}
		
	}

	public boolean getStop() {
		return end==2;
	}
	
	
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	//points for animals
	public void setPoints(int points) {
		this.points=points;
	}
	public int getPoints() {
		return points;
	}
	
	//level for movement along logs and turtles used
	public void setLevel(int level) {
		this.level=level;
	}
	
	public void setmovementX(double mX) {
		this.movementX=mX;
	}

	public void setEnd(int end) {
		// TODO Auto-generated method stub
		this.end=end;
	}

	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgSize,this.imgSize,true,true);
		return img;
	}
	

}
