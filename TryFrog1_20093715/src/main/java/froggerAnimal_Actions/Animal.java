package froggerAnimal_Actions;

import froggerActors.*;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * <b>Represents the player's avatar in the game, which is a frog in Frogger Game.<br>
 * It can move. It might get hit by the obstacles on the road, get eaten by monster, get bombed or drown into the river and die.<br>
 * Its goal is to reach the empty {@link froggerActors.End} on the other side.<br>
 * {@code Animal} is also an {@link froggerActors.Actor}.</b>
 */
public class Animal extends Actor {
	
	/**Animation for moving upwards*/Image imgW1,imgW2;
	/**Animation for moving to the left*/ Image imgA1, imgA2;
	/**Animation for moving backwards*/ Image imgS1, imgS2;
	/**Animation for moving to the right*/ Image imgD1, imgD2;
	
	/**Animations when Animal got hit by the Car/Trucks or eaten by the Monster*/
	Image hitImg1,hitImg2,hitImg3;
	/**Animations when Animal drown into the river*/
	Image drownImg1,drownImg2,drownImg3,drownImg4;
	private int imgSize = 40;
	/**determine if the second version of Animal animations are used.*/
	private boolean secondAnimation = false;
	/**determine if Animal should move*/
	boolean noMove = false;
	/**the previous y position of Animal in the game*/
	private double initialYposition = 800;
	/**level of Animal is at*/
	private int level=0;
	/**Animal points*/
	private int points = 0;
	/**the number of {@link froggerActors.End} Animal has reached*/
	private int end=0;
	/**the amount of coins Animal has collected*/
	private int coin=0;
	/**the number of life Animal has*/
	private int life=5;
	
	/**vertical moving speed of Animal in a single move*/
	private double movementY = 13.3333333*2;	
	/**horizontal moving speed of Animal in a single move*/
	private double movementX=0;

	/**
	 * determine Animal's car death.<br>
	 * <b>true</b> when Animal gets hit by the {@link froggerActors.Obstacle} on the road.
	 */
	 boolean carDeath = false;
	
	/**
	 * determine Animal's water death<br>
	 * <b>true</b> when Animal die-drowning in the river.
	 */
	 boolean waterDeath = false;
	
	/**
	 * determine Animal's monster death<br>
	 * <b>true</b> when Animal gets eaten by the {@link froggerActors.Monster}.
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
	 * 
	 * Defines how {@code Animal} will behave in the game.<br>
	 * Animal can collide with other game objects and move along with them.<br>
	 * Should the Animal experience any death, Animal will perform relevant actions upon its death.<br>
	 * Should the Animal successfully reach the destinations, Animal will gain points.
	 * 
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
		
		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			Log log = getIntersectingObjects(Log.class).get(0);
			if(log.hasbomb()) {
				waterDeath = true;
			}
			else {
				move(log.getSpeed(),0);
			}
		}
		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			Turtle turtle = getIntersectingObjects(Turtle.class).get(0);
			move(turtle.getSpeed(),0);
		}
		
		
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
			if (getIntersectingObjects(End.class).get(0).isOccupied()) {
				end--;
				points-=10;
			}
			else if (getIntersectingObjects(End.class).get(0).hasCoin()) {
				coin++;//coin chain
			}
			else {
				coin=0;//coin chain break
			}
			System.out.println("Coin chain has " + coin + " coins");
			points+=10;
			changeScore = true;
			initialYposition=800;
			getIntersectingObjects(End.class).get(0).setEndOccupied();
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
		
		
}
	
	
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

	/** Checks if {@code Animal} number of life has changed.<br>
	 * 
	 * @return boolean <b>true</b> if there is a change in the number of life<br>
	 * see {@link Animal#changeLife}
	 */
	public boolean changeLife() {
		if(changeLife) {
			changeLife=false;
			return true;
		}
		return false;
	}

	/** Checks if {@code Animal} has run out of life.
	 * @return boolean <b>true</b> when {@code Animal} has no more life.*/
	public boolean noLife(){
	  	return life==0;
	 }

	/**
	 * Checks if {@code Animal} has reached all the 5 destinations in a level and is stopped in the game.<br>
	 * 
	 * @return boolean <b>true</b> if Animal has reached all the destinations.
	 */
	public boolean getStop() {
		return end==2;
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
	public void setLevel(int level) {
		this.level=level;
	}
	/**Gets the {@link Animal#level} of the {@code Animal} currently at.
	 * @return level in int*/
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
	/**
	 * Gets the {@link Animal#movementX} of {@code Animal} at each move.
	 * @return horizontal movement in int
	 */
	public double getmovementX() {
		return this.movementX;
	}
	
	/**
	 * Sets the {@link Animal#movementY} of {@code Animal} at each move.<br>
	 * {@code movementY} is the vertical moving speed of {@code Animal}.
	 * @param mY the value for {@link Animal#movementY} to be assigned with
	 */
	public void setmovementY(double mY) {
		this.movementY=mY;
	}
	
	/**
	 * Gets the {@link Animal#movementY} of {@code Animal} at each move.<br>
	 * @return vertical movement in int
	 */
	public double getmovementY() {
		return this.movementY;
	}

	
	/**
	 * Sets the number of destinations Animal has reached.
	 * @param end value for number of destinations reached
	 */
	public void setEnd(int end) {
		// TODO Auto-generated method stub
		this.end=end;
	}
	/**
	 * Gets the number of destinations Animal has reached
	 * @return number of destinations Animal has reached in int
	 */
	public int getEnd() {
		return end;
	}
	
	/**
	 * Sets the number of {@link Animal#life} Animal has.
	 * @param life value for {@link Animal#life}
	 */
	public void setLife(int life) {
		this.life=life;
	}
	/**
	 * Gets the number of {@link Animal#life} Animal has
	 * @return number of {@link Animal#life} in int
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * Sets the number of {@link Animal#coin} Animal has collected.
	 * @param coin value for {@link Animal#coin}
	 */
	public void setCoin(int coin) {
		this.coin=coin;
	}

	
	/**
	 * Sets up all the necessary animations and looks for {@code Animal}.
	 * Used exclusively by {@code Animal} only.<br>
	 * Images for the animations are set up by using {@link Animal#createImage(String)} method
	 */
	//used in Animal class only
		private void animalAnimationSetUp() {
			// TODO Auto-generated method stub
			imgW1 = createImage("file:src/main/resources/froggertextures/froggerUp.png");
			imgA1 = createImage("file:src/main/resources/froggertextures/froggerLeft.png");
			imgS1 = createImage("file:src/main/resources/froggertextures/froggerDown.png");
			imgD1 = createImage("file:src/main/resources/froggertextures/froggerRight.png");
			imgW2 = createImage("file:src/main/resources/froggertextures/froggerUpJump.png");
			imgA2 = createImage("file:src/main/resources/froggertextures/froggerLeftJump.png");
			imgS2 = createImage("file:src/main/resources/froggertextures/froggerDownJump.png");
			imgD2 = createImage("file:src/main/resources/froggertextures/froggerRightJump.png");
			hitImg1 = createImage("file:src/main/resources/froggertextures/cardeath1.png");
			hitImg2 = createImage("file:src/main/resources/froggertextures/cardeath2.png");
			hitImg2 = createImage("file:src/main/resources/froggertextures/cardeath3.png");
			drownImg1 = createImage("file:src/main/resources/froggertextures/waterdeath1.png");
			drownImg2 = createImage("file:src/main/resources/froggertextures/waterdeath2.png");
			drownImg3 = createImage("file:src/main/resources/froggertextures/waterdeath3.png");
			drownImg4 = createImage("file:src/main/resources/froggertextures/waterdeath4.png");
		}

		
	/**used exclusively by {@code Animal} only to create its images
	 * @param ImageLink the link of the image for {@code Animal}
	 * @return {@code Image} a created image*/
	private Image createImage(String ImageLink) {
		// TODO Auto-generated method stub
		Image img = new Image(ImageLink, this.imgSize,this.imgSize,true,true);
		return img;
	}
	

}
