package p4_group_8_repo;

public class HighScoreModel {

	private String username;
	private int points;
	
	public HighScoreModel(String name, int points){
		this.username=name;
		this.points=points;
	}
	
	public String getusername() {
		return this.username;
	}
	public int getpoints() {
		return this.points;
	}
}
