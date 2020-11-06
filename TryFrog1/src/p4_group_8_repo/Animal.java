package p4_group_8_repo;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	private int points = 0;//initial points
	private int end = 0;//how many ends have been reached
	private int level;//level of animal
	private boolean second = false;//check if second frog animation image is used
	
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX;
	private int imgSize = 40;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean monsterDeath = false;
	private int carD = 0; //for animation 
	private int waterD = 0;
	private int monsterD = 0;
	
	//boolean stop = false;
	private boolean changeScore = false;
	
	private double w = 800;//for recording latest previous y position of frog
	
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/froggertextures/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/froggertextures/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/froggertextures/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/froggertextures/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/froggertextures/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/froggertextures/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/froggertextures/froggerRightJump.png", imgSize, imgSize, true, true);
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=5;
						//change to add 5 points every successful forward move
						//points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
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
		
		
		checkcarDeath(carDeath,now);
		checkwaterDeath(waterDeath,now);
		checkmonsterDeath(monsterDeath,now);
		
		/*if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/froggertextures/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/froggertextures/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/froggertextures/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;

				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
			}
			
		}*/
		
		
		/*if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				waterD++;
			}
			if (waterD==1) {
				setImage(new Image("file:src/froggertextures/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (waterD==2) {
				setImage(new Image("file:src/froggertextures/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (waterD==3) {
				setImage(new Image("file:src/froggertextures/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (waterD == 4) {
				setImage(new Image("file:src/froggertextures/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (waterD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				waterD = 0;
				setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				
				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
				
			}
			
		}*/
		
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}

		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft()) {
				if(level==1) move(-1,0);
				if(level==2 || level==4) move(-2,0);
				if (level==3 || level==5) move(-2*1.3,0);//move(xspeed,yspeed)
			}
			else {
				if(level==1) move(0.5,0);
				if(level==2 || level==4) move(.75,0);
				if (level==3 || level==5) move (.75*1.3,0);
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
			w=800;
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
			//setX(300);
			//setY(679.8+movement);
		}
		
}
	
	private void checkmonsterDeath(boolean mD, long now) {
		// TODO Auto-generated method stub
		if (mD) {
			noMove = true;
			if ((now)% 11 ==0) {
				monsterD++;
			}
			if (monsterD==1) {
				setImage(new Image("file:src/froggertextures/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (monsterD==2) {
				setImage(new Image("file:src/froggertextures/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (monsterD==3) {
				setImage(new Image("file:src/froggertextures/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (monsterD == 4) {
				setX(300);
				setY(679.8+movement);
				this.monsterDeath = false;
				carD = 0;
				setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/froggertextures/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (waterD==2) {
				setImage(new Image("file:src/froggertextures/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (waterD==3) {
				setImage(new Image("file:src/froggertextures/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (waterD == 4) {
				setImage(new Image("file:src/froggertextures/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (waterD == 5) {
				setX(300);
				setY(679.8+movement);
				this.waterDeath = false;
				waterD = 0;
				setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/froggertextures/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/froggertextures/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/froggertextures/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				this.carDeath = false;
				carD = 0;
				setImage(new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true));
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
	
	public void setPoints(int points) {
		this.points=points;
	}
	public int getPoints() {
		return points;
	}
	
	public void setLevel(int level) {
		this.level=level;
	}
	public void setmovementX(double mX) {
		this.movementX=mX;
	}
	

}
