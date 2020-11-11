package p4_group_8_repo;

/**
 * Player's high score record.
 * A record comes with the username and the game points.
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
	 * @param points {@link HighScoreModel#points}
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * get the player's points
	 * @return {@link HighScoreModel#points}
	 */
	public int getpoints() {
		return this.points;
	}

	/**
	 * set the player's username
	 * @param username {@link HighScoreModel#username}
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * get the player's username
	 * @return {@link HighScoreModel#username}
	 */
	public String getusername() {
		return this.username;
	}

	
}
