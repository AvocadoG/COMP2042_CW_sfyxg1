package froggerActors;

/**
 * <b>Represents the turtles in Frogger Game<br>
 * The base class for {@link froggerActors.Turtle}</b>
 * 
 *
 */
public abstract class Turtle extends Actor{

	protected double speed;
	
	/**
	 * This constructor will create a basic Turtle
	 * @param xpos x position of turtle in the game
	 * @param ypos y position of turtle in the game
	 * @param s moving speed of turtle in the game
	 */
	public Turtle(int xpos, int ypos, double s ) {
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * retrieve the moving speed of turtle
	 * @return speed of turtle in {@code double} format
	 * 
	 */
	public double getSpeed() {
		return speed;
	}
}
