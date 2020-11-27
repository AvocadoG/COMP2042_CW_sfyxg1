package froggerActors;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

import froggerLevels.World;

/**
 * <b>{@code Actor} is the base class for all the interactive objects in the Frogger Game.<br>
 * Each interactive game object is known as an {@code Actor}.</b>
 *
 */

public abstract class Actor extends ImageView{

	/**
	 * Controls the movement of {@code Actor} in Frogger Game.
	 * @param dx the horizontal moving speed of Actor
	 * @param dy the vertical moving speed of Actor
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    
    /**
     * Access the {@link froggerLevels.World}, which is where the Actors are added to, in Frogger Game<br>
     * {@link froggerLevels.World} is the game arena of the game levels.
     * 
     * @return {@link froggerLevels.World}, the game arena where {@code Actor} is 
     */
    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * Retrieves a list of game objects from {@link froggerLevels.World} that collide with the {@code Actor}.<br>
     * The game objects must match the targeted {@code cls} class type. 
     * 
     * @param <A> specifies that {@code cls} should be a class type that is also a subclass of {@code Actor} class
     * @param cls the targeted game object class type when checking for collision
     * @return an ArrayList of game objects of {@code cls} type that collide with the {@code Actor}
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    
    /**
     * defines how {@code Actor} would act in the Frogger Game.<br>
     * It will be called every once per frame while the {@code Actor} and the Game are active.
     * @param now in nanoseconds format and it represents the timestamp of the current frame.
     */
    //USED BY EVERY SUBCLASS
    public abstract void act(long now);

}
