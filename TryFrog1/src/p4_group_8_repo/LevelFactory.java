package p4_group_8_repo;

//FACTORY METHOD

/**
 * This is a Level Factory to retrieve the game levels.
 * Factory Method Design Pattern is applied.
 * @author User
 *
 */
public class LevelFactory {

	/**
	 * generate the required game level with an Animal ready in that level. All levels are subclasses of LevelMaster.
	 * @param level the game level to be created (example: level1, level2 etc) 
	 * @param animal the Animal to be put into the level
	 * @return the generated game level
	 */
	public LevelMaster getLevel(String level, Animal animal) {
		
		if(level.equalsIgnoreCase("Level1")) {
			return new Level1(animal);
		}
		if(level.equalsIgnoreCase("Level2")) {
			return new Level2(animal);
		}
		if(level.equalsIgnoreCase("Level3")) {
			return new Level3(animal);
		}
		if(level.equalsIgnoreCase("Level4")) {
			return new Level4(animal);
		}
		if(level.equalsIgnoreCase("Level5")) {
			return new Level5(animal);
		}
		
		return null;
	}
}
