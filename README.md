# COMP2042_sfyxg1 ---- Frogger Game

Main.java is in src/main/java froggerFrames package

ECLIPSE JDK version : 14
JAVAFX version : JavaFX SDK 11.0.2
JUnit Test version : JUnit 4.13

# How to run the program on Eclipse:
**Note: Don't have to unzip the project**

**on Gradle build:**
1. File -> Import -> select "existing Projects into Workspace"
2. select archive file -> Browse -> select the zip file
3. select the project **TryFrog1_20093715** -> Finish
4. go to Window -> show view -> other -> select **GradleTasks**
5. same for show view **Gradle Execution**
5. go to **Gradle Tasks** -> select **TryFrog1_20093715** -> **application** -> **run**

**to run the program from the Main.java itself** :
1. in the imported TryFrog1_20093715 project on Eclipse, go to **src/main/java**
2. select **froggerFrames package**
3. select **Main.java**
4. go to Run Configurations -> select the **Main** in Java Application-> go to Arguments
5. add **--module-path "insert_the_path_to_your_javafx_lib" --add-modules=ALL-MODULE-PATH** in the VM Arguments
6. select Apply -> Run

**worst come to worst, if the above isn't working**
1. unzip the project
2. create a JavaFX project on Eclipse
3. select src -> import -> File System -> Browse
4. select the unzipped project folder, keep on clicking until src of the project
5. **src -> main -> java** : to retrieve all the classes.java(s)
6. **src -> main -> resources** : to retrieve all the relevant music, images, scorefile materials
7. **src -> test -> java**: to retrieve all junit test files 
8. change all the image,music,font,scorefile.txt links in the codes of **all** the classes.java(s) from 
	**src/main/resources/froggertextures** to **src/froggertextures**
	**src/main/resources/froggermusic** to **src/froggermusic**
	**src/main/resources/froggerfonts** to **src/froggermusic**
	**src/main/resources/froggerfiles** to **src/froggerfiles**

# Extension/Addition

  1. Added a **Start Screen** and **Info Screen** to the game (in **froggerFrames package**)

The Start Screen will ask for player's username in order to start the game.
The player can go to the Info Screen from the Start Screen or exit the game by clicking the ***Exit*** button.This if for better user-experience.

 2. Added a **High Score Pop Up** to the game (in **froggerHighScore package**)
 
High Score will be popped once the game ends, whether the player has lost or won the game. Only the Top 5 high score records will be shown in the pop up, together with the score of the current player, be it a win or a lose.This is for better gameplay experience.

 3. Added a **permanent High Score file** that stores all the scores of previous players (can be found in **froggerfiles package** : scorefile.txt).

4. Added new **levels** to the game (in **froggerLevels package**)
 
There are **10** levels in total, each with new game feautures (such as destinations with coins for bonus points, Logs with bombs, Monster etc) and increasing game speed.This is to add more fun and challenge to the game.

5. Added **Life** feature to the game (in **froggerElements package**)

Starts at having 5 life. If player's avatar runs out of life at a certain level, player will lose and the game will end right away. At each new level, the life will be restored.

6. New game features include :

**destinations with coins** - if player successfully collects all the coins continuously, the player can get +50 bonus points and proceed to the next level straightaway.
**logs with bombs on the river** - if player jumps onto the logs with bombs, player will die, lose a life.
**monster moving back and forth** - if player bumps into the monster, the monster will kill the player.
	
7. Added **pause** game and **quit** game feature where player can pause/quit amidst the game.
8. Added new font files, music files and images to the game. 


# Maintenance 

1. Organize all the classes into different packages and rename them, for better clarity. Remove unused images.
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

12. Added **gradle build** to the project

