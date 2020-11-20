package froggerAnimal_Actions;

import froggerActors.*;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * {@code Animal} is the player's avatar in the game, which in this Frogger Game, is a frog.
 * It can move. It might get hit by the obstacles on the road or drown in the river and die.
 * Its goal is to reach the empty {@link p4_group_8_repo.End} on the other side.
 */
public class Animal extends Actor {
	
	//The first version of animations for Frog moving up, left, right, down
	 Image imgW1,imgA1, imgS1, imgD1;
	//The second version of animations for Frog moving up, left, right, down
	 Image imgW2,imgA2, imgS2, imgD2;
	
	//The animations for when Frog got hit by the Car/Trucks or by the Monster
	 Image hitImg1,hitImg2,hitImg3;
	//The animations for when Frog drown into the river
	 Image drownImg1,drownImg2,drownImg3,drownImg4;
	
	//The standard image size for all Frog animations
	 private int imgSize = 40;
	
	//To check if the second version of Frog animations are used during the last time frame.
	 private boolean secondAnimation = false;
	
	//check if Frog should move
	 boolean noMove = false;
	
	//the previous y position of frog
	private double initialYposition = 800;
	
	//Animal at which level
	private int level=0;
	
	//Animal points
	private int points = 0;
	
	/**amount of {@code End} Animal has reached*/
	private int end=0;
	
	private int coin=0;
	
	/**number of life Animal has*/
	private int life=5;
	
	/**vertical moving speed of Animal at a single move*/
	private double movementY = 13.3333333*2;
	
	/**horizontal moving speed of Animal at a single move*/
	private double movementX=0;

	/**
	 * determine Animal's car death.<br>
	 * <b>true</b> when Animal gets hit by the Trucks and Cars on the road.
	 */
	 boolean carDeath = false;
	
	/**
	 * determine Animal's water death<br>
	 * <b>true</b> when Animal die-drowning in the river.
	 */
	 boolean waterDeath = false;
	
	/**
	 * determine Animal's monster death<br>
	 * <b>true</b> when Animal gets eaten by the {@link p4_group_8_repo.Monster}.
	 */
	 boolean monsterDeath = false;
	
	/**for animations purpose during Animal's death*/
	 int carD,waterD,monsterD = 0; 
		
	/**
	 * determine if Animal's score has changed<br>
	 * <b>true</b> if Animal's score has changed
	 */
	 boolean changeScore = false;
	 /**
	  * determine if Animal's number of life has changed<br>
	  * <b>true</b> if Animal's number of life has changed
	  */
	 boolean changeLife = false;
	
	
	Animal(){};
	
	/**
	 * This constructor will create an {@code Animal} object with its initial position in the game set.<br>
	 * The {@code Animal} can now move up (W key) down (S key) left (A key) and right (D key) with different animations.
	 * This is done by implementing 
	 * <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setOnKeyPressed-javafx.event.EventHandler-">{@code setOnKeyPressed}</a>
	 *  and 
	 *  <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setOnKeyReleased-javafx.event.EventHandler-">{@code setOnKeyReleased}</a>
	 *  to detect and handle the keyboard inputs.
	 *  
	 * @param imageLink The image link for how the Animal is displayed in the game
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		
		//set up default position in game scene
		setX(300);
		setY(679.8+movementY);
	
		//set up all necessary animal animations and images
		animalAnimationSetUp();
		
		//detect and handle key events
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				
				if (noMove) {}
				
				else {
					
					if (secondAnimation) {
						
						if (event.getCode() == KeyCode.W) {	  
							move(0, -movementY);
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
							move(0, movementY);
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
						move(0, -movementY);
						setImage(imgW2);
						secondAnimation = true;
					}
					else if (event.getCode() == KeyCode.A) {	            	
						move(-movementX, 0);
						setImage(imgA2);
						secondAnimation = true;
					}
					else if (event.getCode() == KeyCode.S) {	            	
						move(0, movementY);
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
							
							//usual moving forward/jumping will give 5 points
							//if jumping into an End, no extra 5 points
							if (getIntersectingObjects(End.class).size()<=0) {
								changeScore = true;
								initialYposition = getY();
								points+=5;
							}
						}
						
						move(0, -movementY);
						setImage(imgW1);
						secondAnimation = false;
					}
					
					else if (event.getCode() == KeyCode.A) {	            	
						move(-movementX, 0);
						setImage(imgA1);
						secondAnimation = false;
					}
					else if (event.getCode() == KeyCode.S) {	            	
						move(0, movementY);
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


	
	/**
	 * {@inheritDoc}<br>
	 * Defines how Animal will behave in the game.<br>
	 * Animal can collide with other game objects and move along with them.
	 * Should the Animal experience any car death, water death or monster death. Animal will perform relevant actions upon its death.<br>
	 * Deaths are determined upon calling methods :{@link Animal#checkcarDeath(boolean, long)} {@link Animal#checkwaterDeath(boolean, long)}, {@link Animal#checkmonsterDeath(boolean, long)}<br>
	 * Should the Animal successfully reach the destinations, Animal will get points.
	 * <br>
	 * If Animal is moves out of the game scene, Animal will be moved back.
	 */
	public void act(long now) {
		
		//to make sure frog doesn't get out of screen
		//up is 0, down is 734
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movementY);
		}
		
		if (getX()<0) {
			move(movementY*2, 0);
		}
		if (getX()>600) {
			move(-movementY*2, 0);
		}
		
	
		//if intersect with an Obstacle object, car death
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}

		//if on a Log, move along with the Log
		/*else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
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
		}*/
		
		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			Log log = getIntersectingObjects(Log.class).get(0);
			move(log.getSpeed(),0);
		}
		
		//if on a Turtle, move along with the Turtle
		/*else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			if (level==1) move(-0.5,0);//
			if (level==2 || level==4) move(-1,0);
			if (level==3 || level==5) move(-1*1.3,0);
		}*/
		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			Turtle turtle = getIntersectingObjects(Turtle.class).get(0);
			move(turtle.getSpeed(),0);
		}
		
		//if on a Wet Turtle
		//if the Wet Turtle sinks, water death
		//else, move along with the Wet Turtle
		/*else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				if(level==1) move(-0.5,0);//-1
				if(level==2 || level==4) move(-1,0);
				if (level==3 || level==5) move(-1*1.3,0);
			}
		}*/
		
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			WetTurtle wetturtle = getIntersectingObjects(WetTurtle.class).get(0);
			if(wetturtle.isSunk()) {
				waterDeath=true;
			}
			else {
			move(wetturtle.getSpeed(),0);
			}
		}
		
		//if into an End destination
		//if the End is empty, +10 points, if the End is empty and has coin, +20 points, else no points
		//Animal back to default position after reaching one destination
		else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=10;
			}
			else if (getIntersectingObjects(End.class).get(0).hasCoin()) {
				coin++;//coin chain
				//points+=10;//
			}
			else {
				coin=0;//coin chain break
			}
			System.out.println("Coin chain has " + coin + " coins");
			points+=10;
			changeScore = true;
			initialYposition=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movementY);
			
			//if get coin End continuously for 3 times
			if(coin==3) {
				System.out.println("3 coins in a row");
				points+=50;
				end=5;//level up right away
			}
		}
		
		//if eaten by Monster, monster death
		else if(getIntersectingObjects(Monster.class).size() >= 1) {
			monsterDeath = true;

		}
		
		else if (getY()<413){
			waterDeath = true;
	
		}
		
		
		//run every frame
		AnimalDeathContext context;
		context=new AnimalDeathContext(new CarDeath(this,carDeath));
		context.executeAction(now);
		context=new AnimalDeathContext(new WaterDeath(this,waterDeath));
		context.executeAction(now);
		context=new AnimalDeathContext(new MonsterDeath(this,monsterDeath));
		context.executeAction(now);
		
		
		
		//checking for each type of death and perform actions
		//carDeath(carDeath,now);
		//waterDeath(waterDeath,now);
		//monsterDeath(monsterDeath,now);
		
		
}
	
	
	/**
	 * Checks if Animal gets eaten by the {@link p4_group_8_repo.Monster} and performs relevant actions.<br>
	 * Should the Animal experience a <i>monster death</i>, Animal will be deducted 10points.
	 * @param mD {@link Animal#monsterDeath}
	 * @param now current time frame in nanoseconds
	 */
	/*
	public void monsterDeath(boolean mD, long now) {
		// TODO Auto-generated method stub
		if (mD) {
			noMove = true;
			//animations purpose
			if ((now)% 11 ==0) {
				monsterD++;
			}
			if (monsterD==1) {		
				setImage(hitImg1);
			}
			if (monsterD==2) {
				setImage(hitImg2);
			}
			if (monsterD==3) {
				setImage(hitImg3);
			}
			if (monsterD == 4) {
				setX(300);
				setY(679.8+movement);
				this.monsterDeath = false;
				monsterD = 0;
				setImage(imgW1);
				noMove = false;

				//change points
				if(points>10) {
					points-=10;
					changeScore=true;
				}
				
				life--;
				changeLife=true;
				
			}
			
		}
	}
*/
	
	
	/**
	 * Checks if {@code Animal} gets drown into the river and performs relevant game actions<br>
	 * Should the Animal experience a <i>water death</i>, Animal will be deducted 10points.
	 * @param wD {@link Animal#waterDeath}
	 * @param now current time frame in nanoseconds
	 */
	/*public void waterDeath(boolean wD, long now) {
		// TODO Auto-generated method stub
		if (wD) {
			noMove = true;
			if ((now)% 11 ==0) {
				waterD++;
			}
			if (waterD==1) {
				setImage(drownImg1);
			}
			if (waterD==2) {
				setImage(drownImg2);
			}
			if (waterD==3) {
				setImage(drownImg3);
			}
			if (waterD == 4) {
				setImage(drownImg4);
			}
			if (waterD == 5) {
				setX(300);
				setY(679.8+movement);
				this.waterDeath = false;
				waterD = 0;
				setImage(imgW1);
				noMove = false;
				
				//change
				if(points>10) {
					points-=10;
					changeScore=true;
				}
				
				life--;
				changeLife=true;
				
			}
			
		}
	}
*/
	
	/**
	 * Checks if {@code Animal} score has changed.<br>
	 * 
	 * @return boolean <b>true</b> if there is a change in the Animal's score<br>
	 * see {@link Animal#changeScore}
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}

	public boolean changeLife() {
		if(changeLife) {
			changeLife=false;
			return true;
		}
		return false;
	}

	public boolean noLife(){
	  	return life==0;
	 }

	/**
	 * Checks if {@code Animal} is stopped in the game.<br>
	 * If Animal has reached all the 5 Empty {@link p4_group_8_repo.End} in a single level, Animal will get stopped at that level.
	 * 
	 * @return boolean <b>true</b> if Animal {@link Animal#end} is 5
	 */
	public boolean getStop() {
		return end==5;
	}
	
	
	
	/**
	 * Sets the game {@link Animal#points} of {@code Animal}.
	 * @param points the points to be assigned to the {@code Animal}.
	 */
	public void setPoints(int points) {
		this.points=points;
	}
	
	/**
	 * Gets the game {@link Animal#points} of {@code Animal}.
	 * @return the current {@link Animal#points} of {@code Animal} in int
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the {@link Animal#level} of the {@code Animal} currently at.
	 * @param level the game level
	 */
	//level for movement along logs and turtles used
	public void setLevel(int level) {
		this.level=level;
	}
	public int getLevel() {
			return level;
	}
	
	/**
	 * Sets the {@link Animal#movementX} of {@code Animal} at each move.<br>
	 * {@code movementX} is the horizontal moving speed of {@code Animal}.
	 * @param mX the value for {@link Animal#movementX} to be assigned with
	 */
	public void setmovementX(double mX) {
		this.movementX=mX;
	}
	
	public double getmovementX() {
		return this.movementX;
	}
	
	public void setmovementY(double mY) {
		this.movementY=mY;
	}
	
	public double getmovementY() {
		return this.movementY;
	}

	
	/**
	 * Sets the number of {@link Animal#end} Animal has reached.
	 * @param end value for {@link Animal#end}
	 */
	public void setEnd(int end) {
		// TODO Auto-generated method stub
		this.end=end;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setLife(int life) {
		this.life=life;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setCoin(int coin) {
		this.coin=coin;
	}

	

	
	
	/**
		 * Checks if Animal gets eaten by the {@link p4_group_8_repo.Monster} and performs relevant actions.<br>
		 * Should the Animal experience a <i>monster death</i>, Animal will be deducted 10points.
		 * @param mD {@link Animal#monsterDeath}
		 * @param now current time frame in nanoseconds
		 */
		/*
		public void monsterDeath(boolean mD, long now) {
			// TODO Auto-generated method stub
			if (mD) {
				noMove = true;
				//animations purpose
				if ((now)% 11 ==0) {
					monsterD++;
				}
				if (monsterD==1) {		
					setImage(hitImg1);
				}
				if (monsterD==2) {
					setImage(hitImg2);
				}
				if (monsterD==3) {
					setImage(hitImg3);
				}
				if (monsterD == 4) {
					setX(300);
					setY(679.8+movement);
					this.monsterDeath = false;
					monsterD = 0;
					setImage(imgW1);
					noMove = false;
	
					//change points
					if(points>10) {
						points-=10;
						changeScore=true;
					}
					
					life--;
					changeLife=true;
					
				}
				
			}
		}
	*/
		
		
		/**
		 * Checks if {@code Animal} gets drown into the river and performs relevant game actions<br>
		 * Should the Animal experience a <i>water death</i>, Animal will be deducted 10points.
		 * @param wD {@link Animal#waterDeath}
		 * @param now current time frame in nanoseconds
		 */
		/*public void waterDeath(boolean wD, long now) {
			// TODO Auto-generated method stub
			if (wD) {
				noMove = true;
				if ((now)% 11 ==0) {
					waterD++;
				}
				if (waterD==1) {
					setImage(drownImg1);
				}
				if (waterD==2) {
					setImage(drownImg2);
				}
				if (waterD==3) {
					setImage(drownImg3);
				}
				if (waterD == 4) {
					setImage(drownImg4);
				}
				if (waterD == 5) {
					setX(300);
					setY(679.8+movement);
					this.waterDeath = false;
					waterD = 0;
					setImage(imgW1);
					noMove = false;
					
					//change
					if(points>10) {
						points-=10;
						changeScore=true;
					}
					
					life--;
					changeLife=true;
					
				}
				
			}
		}
	*/
		
		/**
		 * Checks if {@code Animal} gets hit by a Car/Truck (See : {@link p4_group_8_repo.Obstacle}) and perform relevant actions.<br>
		 * Should the Animal experience a <i>car/truck death</i>, Animal will be deducted 10points.
		 * @param cD {@link Animal#carDeath}
		 * @param now current time frame in nanoseconds
		 */
		/*public void carDeath(boolean cD, long now) {
			// TODO Auto-generated method stub
			if (cD) {
				noMove = true;
				if ((now)% 11 ==0) {
					carD++;
				}
				if (carD==1) {
					setImage(hitImg1);
				}
				if (carD==2) {
					setImage(hitImg2);
				}
				if (carD==3) {
					setImage(hitImg3);
				}
				if (carD == 4) {
					setX(300);
					setY(679.8+movement);
					this.carDeath = false;
					carD = 0;
					setImage(imgW1);
					noMove = false;
	
					//change
					if(points>10) {
						points-=10;
						changeScore=true;
					}
					life--;
					changeLife=true;
				}
				
			}
			
		}
	*/
		/**
		 * Sets up all the necessary animations and looks for {@code Animal}.<br>
		 * Images for the animations are set up by calling {@link Animal#createImage(String)} method
		 */
	//used in Animal class only
		private void animalAnimationSetUp() {
			// TODO Auto-generated method stub
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
		}

		//use in Animal class only
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgSize,this.imgSize,true,true);
		return img;
	}
	

}

//interface Image Generator
		/*imgW1 = new Image("file:src/froggertextures/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/froggertextures/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/froggertextures/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/froggertextures/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/froggertextures/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/froggertextures/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/froggertextures/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/froggertextures/froggerRightJump.png", imgSize, imgSize, true, true);*/
		