package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * Actor Class is the base class for all the interactive objects in the Frogger Game.<br>
 * Each interactive game object is known as an Actor.
 * 
 * 
 * @author User
 *
 */

public abstract class Actor extends ImageView implements ImageGenerator{

	/**
	 * Controls the movement of the Actor in Frogger Game.
	 * @param dx the horizontal moving speed of the Actor
	 * @param dy the vertical moving speed of the Actor
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    
    /**
     * Allows the access to the Actor's parent {@link p4_group_8_repo.World} class.<br>
     * {@link p4_group_8_repo.World} is the main Game Arena
     * @return World the Main Game Arena 
     */
    //to access the World class (Pane)
    public World getWorld() {
        return (World) getParent();
    }

   /* NOT IN USE
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }*/

    
    /**
     * Retrieves a list of game objects from the {@link p4_group_8_repo.World} that collide with the {@link p4_group_8_repo.Actor}.<br>
     * The game objects must match the targeted {@code cls} class type. 
     * 
     * @param <A> a class type that is a subclass of {@link p4_group_8_repo.Actor} class
     * @param cls the targeted game object class type to check for collision
     * @return a list of game objects of {@code cls} type that collide with the {@link p4_group_8_repo.Actor}, 
     */
    //detect intersectingobjects which are of Actor class and are added to the World Pane
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
    * 
    * @deprecated NOT IN USE
    * @param e an Event that occurs
    */
    public void manageInput(InputEvent e) {
        
    }

    /**
     * Retrieve the first object which matches the targeted {@code cls} type, from the {@link p4_group_8_repo.World} that collides with 
     * {@link p4_group_8_repo.Actor}
     * 
     * @deprecated Not in Use
     * @param <A> a class type that is a subclass of {@link p4_group_8_repo.Actor} class
     * @param cls the targeted game object class type to check for collision
     * @return a single object of type {@code cls} collided with {@link p4_group_8_repo.Actor}
     */
   
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
    
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    
    /**
     * defines how Actor would act in the Game.<br>
     * It will be called every once per frame while the Actor and the Game are active.
     * @param now in nanoseconds format and it represents the timestamp of the current frame.
     */
    //USED BY EVERY SUBCLASS
    public abstract void act(long now);

}
