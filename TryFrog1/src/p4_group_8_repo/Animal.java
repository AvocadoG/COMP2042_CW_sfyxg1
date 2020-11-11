package p4_group_8_repo;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * <p>Animal is the player's Avatar in the game, which in this case is the Frog.</p>
 * Animal is also an Actor.
 * <p>It can move. It might get hit by the obstacles on the road or drown in the river and die.</p>
 * <p>Its goal is to reach the empty {@link p4_group_8_repo.End} on the other side.</p>
 * 
 * @author User
 *
 */
public class Animal extends Actor {
	
	//The first version of animations for Frog moving up, left, right, down
	private Image imgW1,imgA1, imgS1, imgD1;
	//The second version of animations for Frog moving up, left, right, down
	private Image imgW2,imgA2, imgS2, imgD2;
	
	//The animations for when Frog got hit by the Car/Trucks or by the Monster
	private Image hitImg1,hitImg2,hitImg3;
	//The animations for when Frog drown into the river
	private Image drownImg1,drownImg2,drownImg3,drownImg4;
	
	//The standard image size for all Frog animations
	private int imgSize = 40;
	
	//To check if the second version of Frog animations are used during the last time frame.
	private boolean secondAnimation = false;
	
	/**
	 * which game level the Animal is in
	 */
	private int level;//game level of Frog  --- done setter
	
	/**
	 * Animal's game points
	 */
	private int points = 0;//initial points of Frog --- done setter getter
	
	/**
	 * amount of {@code End} Animal has reached
	 */
	private int end = 0;//how many ends have been reached by Frog

	private boolean noMove = false;//check if Frog should move
	
	/**
	 * vertical moving speed of Animal at a single move
	 */
	private double movement = 13.3333333*2;//vertical movement of Frog
	
	/**
	 * horizontal moving speed of Animal at a single move
	 */
	private double movementX;//set horizontal movement --- done setter
	

	/**
	 * determine Animal's car death.<br>
	 * <b>true</b> when Animal gets hit by the Trucks and Cars on the road.
	 */
	private boolean carDeath = false;
	/**
	 * determine Animal's water death<br>
	 * <b>true</b> when Animal die-drowning in the river.
	 */
	private boolean waterDeath = false;
	/**
	 * determine Animal's monster death<br>
	 * <b>true</b> when Animal gets eaten by the game {@link p4_group_8_repo.Monster}.
	 */
	private boolean monsterDeath = false;
	
	//for animations display during Frog death
	private int carD = 0; 
	private int waterD = 0;
	private int monsterD = 0;
	
	//boolean stop = false;
	
	private boolean changeScore = false;//check if Frog score has to be updated
	
	//the previous y position of frog
	private double initialYposition = 800;
	
	
	/**
	 * This constructor will create an Animal object. Its initial position in the game is set.<br>
	 * The Animal can now move up (W key) down (S key) left (A key) and right (D key) with different animations.
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
		
		animalAnimationSetUp();
		
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
	
	
	/**
	 * Sets up all the necessary animations and looks for the Animal.<br>
	 * Images for the animations are set up by calling {@link Animal#createImage(String)} method
	 */
	public void animalAnimationSetUp() {
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
	
	
	/**
	 * Checks if Animal gets eaten by the {@link p4_group_8_repo.Monster} and performs relevant actions.<br>
	 * Should the Animal experience a <i>monster death</i>, Animal will be deducted 10points.
	 * @param mD {@link Animal#monsterDeath}
	 * @param now current time frame in nanoseconds
	 */
	//private checking, methods should only be called within the animal act 
	public void checkmonsterDeath(boolean mD, long now) {
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

	
	/**
	 * Checks if Animal gets drown into the river and performs relevant game actions<br>
	 * Should the Animal experience a <i>water death</i>, Animal will be deducted 10points.
	 * @param wD {@link Animal#waterDeath}
	 * @param now current time frame in nanoseconds
	 */
	public void checkwaterDeath(boolean wD, long now) {
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

	
	/**
	 * Checks if Animal gets hit by a Car/Truck(See : {@link p4_group_8_repo.Obstacle}) and perform relevant actions.<br>
	 * Should the Animal experience a <i>car/truck death</i>, Animal will be deducted 10points.
	 * @param cD {@link Animal#carDeath}
	 * @param now current time frame in nanoseconds
	 */
	public void checkcarDeath(boolean cD, long now) {
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

	
	/**
	 * Checks if Animal is stopped in the game.<br>
	 * If Animal has reached all the 5 Empty Ends of a single level, Animal will get stopped at the level.
	 * 
	 * @return true if Animal has reached 5 {@link Animal#end}
	 */
	public boolean getStop() {
		return end==2;
	}
	
	
	/**
	 * Checks if Animal' score has changed.<br>
	 * 
	 * @return true if there is a change in the Animal's score
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * Sets the game {@link Animal#points} of Animal.
	 * @param points the points to be assigned to the Animal
	 */
	//points for animals
	public void setPoints(int points) {
		this.points=points;
	}
	
	/**
	 * Gets the game {@link Animal#points} of Animal.
	 * @return the current {@link Animal#points} of Animal
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the {@link Animal#level} of the Animal currently at.
	 * @param level one of the game levels
	 */
	//level for movement along logs and turtles used
	public void setLevel(int level) {
		this.level=level;
	}
	
	/**
	 * Sets the {@link Animal#movementX} of Animal at each move.<br>
	 * {@link Animal#movementX} differs between game levels.
	 * @param mX the value for {@link Animal#movementX} to be assigned with
	 */
	public void setmovementX(double mX) {
		this.movementX=mX;
	}

	
	/**
	 * Sets the number of {@link Animal#end} Animal has reached.
	 * @param end value for {@link Animal#end}
	 */
	public void setEnd(int end) {
		// TODO Auto-generated method stub
		this.end=end;
	}

	/**
	 * {@inheritDoc}<br>
	 * To generate images for Animal's animations.
	 */
	@Override
	public Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgSize,this.imgSize,true,true);
		return img;
	}
	

}
