package froggerAnimal_Actions;
//object is not stored as a field for a class
//use-a relationship : method of a class creates a new object of another class. The object only exists within that method, will destroy after method done.
//dependency : method of a class use the object of another class, no object is created or stored in a field.

//if object is stored as a field for a class
//Agg / Com
//Agg : take in argument and store the argument as a field in the class
//Com : create a new object of another class and store it as a field in the class


/**
 * <b>The base frame class for all kinds of Animal's death.</b>
 *
 */
public interface AnimalDeath {

	/**To do an action upon {@link froggerAnimal_Actions.Animal} death.
	 * @param now current timeframe in nanoseconds*/
	void doAction( long now);
}
