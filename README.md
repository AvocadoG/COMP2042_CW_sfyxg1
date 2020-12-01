# COMP2042_sfyxg1 ---- Frogger Game

Main.java is in src/main/java froggerFrames package

ECLIPSE JDK version : 14
JAVAFX version : JavaFX SDK 11.0.2
JUnit Test version : JUnit 4

# Extension/Addition

  1. Added a **Start Screen** and **Info Screen** to the game (in **froggerFrames package**)

The Start Screen will ask for player's username in order to start the game.
The player can go to the Info Screen from the Start Screen or exit the game by clicking the ***Exit*** button.This if for better user-experience.

 2. Added a **High Score Pop Up** to the game (in **froggerHighScore package**)
 
High Score will be popped once the game ends, whether the player has lost or won the game. Only the Top 5 high score records will be shown in the pop up, together with the score of the current player, be it a win or a lose.This is for better gameplay experience.

 3. Added a **permanent High Score file** that stores all the scores of previous players (can be found in **froggerfiles package** : scorefile.txt).

4. Added new **levels** to the game (in **froggerLevels package**)
 
There are **10** levels in total, each with new feautures (such as destinations with coins for bonus points, Logs with bombs, Monster etc) and increasing game speed.This is to add more fun and challenge to the game.

5. Added **Life** feature to the game (in **froggerElements package**)

Starts at having 5 life. If player's avatar runs out of life at a certain level, player will lose and the game will end right away. At each new level, the life will be restored.

6. Added **pause** game feature where player can pause amidst the game.
7. Added new font files, music files and images to the game.


# Maintenance 

1. Organize all the classes into different packages and rename them, for better clarity.
2. Remove unused methods and fields from the classes.

3. Remove the inheritance of **BackgroundImage** and **Digit** class from **Actor** class.

To ensure Liskov's Substitution Principle is followed as both classes aren't using the *act* method, which is an abstract method declared in the Actor class. 
4. Allow any **Node**(s) to be added into the **World** class instead of only objects of **Actor** class or its subclasses.

5. Create subclasses for superclass **Level** (such as **Level1** class, **Level2** class etc) and apply **Template Method Design Pattern** where subclasses will implement the abstract methods declared in superclass *differently*. (see **froggerLevels package**). This can ensure Open-Closed Principle is applied.

6. Move the responsibility of generating game arena actions (add Logs, Turtle, Obstacles etc) to the subclasses of **Level** class , in the *createArena()* method, for Single Responsibility Principle. It was originally in the **Main** class.

7. **Factory Design Pattern** applied on Level and Level Factory

Create a **LevelFactory** to generate new levels based on input such as "Level 1", "Level 2" etc. (Can be found in **froggerLevels package**)

8. **Animal** class originally came with a huge chunk of codes in its methods. To clean the code, **Strategy Design Pattern** is applied to the *death-checking actions*. (see **froggerAnimal_Actions package**, **AnimalDeath** interface and **AnimalDeathContext** class) 

Different concrete classes of animal death will implement the **AnimalDeath** interface and have *different algorithm* in the animal's death execution (see *doAction()* method). Animal can check and execute actions related to its death by creating AnimalDeathContext class object.

9. **Strategy Design Pattern** on Game Actions such as level up, pop high score etc. (see **froggerGameActions package**) 

Each game action has different algorithm. Since we have several game actions which will be reused throughout the levels in Frogger Game, this design pattern can reduce redundancy and messy codes.

10. **Singleton Design Pattern** is applied on StartScreen and InfoScreen. (see **froggerFrames package**). This is because there should be only ONE StartScreen and InfoScreen throughout the game.

11. **MVC** pattern applied on recording and displaying High Score (see **froggerHighScore package**)

HighScoreController will update the top 5 high score records to the HighScoreView (which is the high score pop up) to be shown in the game. It will also retrieve the username and score of its HighScoreModel to be updated to the view.

