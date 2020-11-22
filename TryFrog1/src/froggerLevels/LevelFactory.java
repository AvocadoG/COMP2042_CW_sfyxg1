package froggerLevels;

import froggerAnimal_Actions.Animal;

//FACTORY METHOD

/**
 * This is a Level Factory to create the game levels.<br>
 * <b>Factory Method Design Pattern</b> is applied.
 * @author GohXinYee
 *
 */
public class LevelFactory {

	/**
	 * generate the required game {@code Level}<br>
	 * All the generated levels are subclasses of {@link froggerLevels.Level}.
	 * @param level the game level to be created (example: level1, level2 etc) 
	 * @param animal the {@link froggerAnimal_Actions.Animal} to be put into the level
	 * @return the generated game level 
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
