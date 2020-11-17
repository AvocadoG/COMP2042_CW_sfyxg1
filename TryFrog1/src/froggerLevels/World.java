package froggerLevels;


import java.util.ArrayList;
import java.util.List;

import froggerActors.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;

/**
 * Represents the main World of Frogger Game where all the game objects are added into this {@code World} for gameplay. 
 * @author User
 *
 */
public abstract class World extends Pane {
	
    private AnimationTimer timer;
    
    /**
     * This constructor will generate {@code World}. <br>
     * The World is connected to the game scene.
     * It <b>listens</b> to any changes in the game scene and let the game objects (Actor) perform relevant actions.
     * <br>
     * It keeps the game active and updated.<br>
     * See :
     * <a href="https://docs.oracle.com/javase/10/docs/api/javafx/beans/value/ObservableValue.html#addListener(javafx.beans.value.ChangeListener)">{@code addListener(ChangeListener)}</a>
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * creates a timer for the game.<br>
     * Once the timer is started, the game will be active.
     * <br>The game objects ({@link p4_group_8_repo.Actor}) will be put into action.
     * <br>
     * See : {@link p4_group_8_repo.Actor#act(long)} , 
     * <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/animation/AnimationTimer.html">AnimationTimer</a>
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * start the game.<br>
     * start the game timer.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * stop the game.<br>
     * stop the game timer.
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * pause the game
     * @param pausestatus determine if the game should be paused
     */
    public void pause(boolean pausestatus) {
    	if(pausestatus) {
    		timer.stop();
    	}
    	else {
    		timer.start();
    	}
    }
    
   /*
   public void add(Actor actor) {
        getChildren().add(actor);
    }*/
    
    /**
     * add game objects and other game elements into Frogger Game {@code World}
     * @param node the game objects/elements to be added
     */
    public void add(Node node) {
        getChildren().add(node);
    }

   /**
    * @deprecated NOT IN USE<br>
    * removes a game object which is also a subclass of {@code Actor} class, from {@code World}
    * @param actor the object to be removed
    */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * retrieve game objects which match {@code cls} type, from {@code World}
     * @param <A> specifies that {@code cls} should be a class type that's also a subclass of {@link p4_group_8_repo.Actor}
     * @param cls the targeted game object {@code cls} type when retrieving
     * @return a list of game objects of {@code cls} type retrieved from {@code World}
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }

   // public abstract void act(long now);
}
