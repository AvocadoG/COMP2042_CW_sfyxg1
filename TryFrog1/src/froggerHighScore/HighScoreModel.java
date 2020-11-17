package froggerHighScore;

/**
 * Player's high score record which consists of a username and game points.
 * @author User
 *
 */
public class HighScoreModel {

	private String username;
	private int points;
	
	/**
	 * This constructor will create a high score record of a player
	 * with the player's username and game points
	 * @param name the player's username
	 * @param points the player's points
	 */
	public HighScoreModel(String name, int points){
		setUsername(name);
		setPoints(points);
	}
	
	
	/**
	 * set the player's points
	 * @param points the points to be set 
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * get the player's points
	 * @return the player's {@link HighScoreModel#points} in int
	 */
	public int getpoints() {
		return this.points;
	}

	/**
	 * set the player's username
	 * @param username the name to be set as the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * get the player's username
	 * @return the player's {@link HighScoreModel#username} in String format
	 */
	public String getusername() {
		return this.username;
	}

	
}
