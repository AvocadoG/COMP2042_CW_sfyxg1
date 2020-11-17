package froggerHighScore;

import java.util.Comparator;

/**
 * Defines how each high score record will be compare.
 * @author User
 *
 */
public class HighScoreComparator implements Comparator<HighScoreModel>{

	/**
	 * compare the points of HighScoreModel m1 and HighScoreModel m2
	 *  @return 
	 *  1 if m1.points <b>less than</b> m2.points, 
	 *  -1 if m1.points <b> more than</b> m2.points, 
	 *  0 if m1.points <b>==</b> m2.points
	 */
	public int compare(HighScoreModel m1, HighScoreModel m2) {
		//store HighScoreModel according to the points in descending order
		return m1.getpoints()<m2.getpoints()? 1 : (m1.getpoints()>m2.getpoints()? -1 : 0);
	}
}
