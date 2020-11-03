package p4_group_8_repo;

import java.util.Comparator;

public class HighScoreComparator implements Comparator<HighScoreModel>{

	public int compare(HighScoreModel m1, HighScoreModel m2) {
		
		//store HighScoreModel according to the points in descending order
		return m1.getpoints()<m2.getpoints()? 1 : (m1.getpoints()>m2.getpoints()? -1 : 0);
	}
}
