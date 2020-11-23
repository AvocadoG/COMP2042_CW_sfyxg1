package froggerAnimal_Actions;

/**
 * a base frame class for all kinds of Animal's death.
 *
 */
public interface AnimalDeath {

	/**To do an action upon {@link froggerAnimal_Actions.Animal} death.
	 * @param now current timeframe in nanoseconds*/
	void doAction( long now);
}
