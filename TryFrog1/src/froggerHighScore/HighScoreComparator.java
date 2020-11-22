package froggerHighScore;

import java.util.Comparator;

/**
 * Defines how each high score record will be compared.
 * @author User
 *
 */
public class HighScoreComparator implements Comparator<HighScoreModel>{

	/**
	 * compare the points of HighScoreModel m1 and HighScoreModel m2
	 * 
	 * @param m1 the first {@link froggerHighScore.HighScoreModel}
	 * @param m2 the second {@link froggerHighScore.HighScoreModel}
	 * 
	 * @return 
	 *  int <b>1</b> if m1.points <b>less than</b> m2.points<br>
	 *  int <b>-1</b> if m1.points <b> more than</b> m2.points<br>
	 *  int <b>0</b> if m1.points <b>==</b> m2.points
	 */
	public int compare(HighScoreModel m1, HighScoreModel m2) {
		//store HighScoreModel according to the points in descending order
		return m1.getpoints()<m2.getpoints()? 1 : (m1.getpoints()>m2.getpoints()? -1 : 0);
	}
}
