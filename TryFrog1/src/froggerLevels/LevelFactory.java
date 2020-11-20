package froggerLevels;

import froggerAnimal_Actions.Animal;

//FACTORY METHOD

/**
 * This is a Level Factory to retrieve the game levels.
 * <B>Factory Method Design Pattern</B> is applied.
 * @author User
 *
 */
public class LevelFactory {

	/**
	 * generate the required game {@code Level}<br>
	 * The {@code Level} will have an {@link p4_group_8_repo.Animal} ready in it but the {@code Animal} is not <i>activated</i> yet. All the generated {@code Level} are subclasses of {@link p4_group_8_repo.Level}.
	 * @param level the game level to be created (example: level1, level2 etc) 
	 * @param animal the {@code Animal} to be put into the level
	 * @return the generated game {@code Level} 
	 */
	public Level getLevel(String level, Animal animal) {
		
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
		if(level.equalsIgnoreCase("Level6")) {
			return new Level6(animal);
		}
		if(level.equalsIgnoreCase("Level7")) {
			return new Level7(animal);
		}
		if(level.equalsIgnoreCase("Level8")) {
			return new Level8(animal);
		}
		if(level.equalsIgnoreCase("Level9")) {
			return new Level9(animal);
		}
		
		
		return null;
	}
}
