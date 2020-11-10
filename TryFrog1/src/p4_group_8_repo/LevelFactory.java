package p4_group_8_repo;

//FACTORY METHOD
public class LevelFactory {

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
