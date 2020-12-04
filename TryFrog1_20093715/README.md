# COMP2042_sfyxg1

**Main.java** in src/main/java/froggerFrames

### How to run the program on Eclipse:
1. File -> Import -> select "existing Projects into Workspace"
2. select archive file -> Browse -> select the zip file
3. Window -> showview -> other -> **GradleTasks**
4. same for **GradleExecution**
5. go to **GradleTasks** -> **TryFrog1_20093715** -> **application** -> **run**

### Extension/Addition

  1. **Start Screen** and **Info Screen** to the game (in **froggerFrames package**)

The Start Screen will ask for player's username.  
The player can go to the Info Screen from the Start Screen or exit the game by clicking the **Exit** button. For better user-experience.

 2. **HighScore Pop Up** to the game (in **froggerHighScore package**)
 
Popped once the game ends (win or lose). Only the Top5 records will be shown in the pop up, together with the current player's score.For better gameplay experience.

 3. **permanent HighScore file** in **src/main/resources/froggerfiles package** : scorefile.txt

4. **10 new levels** to the game (in **froggerLevels package**). Each with new game feautures and increasing game speed. To add more fun and challenge to the game.

5. New game features:

**destinations with coins** - if player successfully collects all the coins **continuously**, he gets bonus points and proceed to the next level straightaway.  
**logs with bombs** - if player jumps onto the logs with bombs, player will die.  
**monster** - if player bumps into the monster, it will eat the player.  
**Life** -  If player runs out of life at a certain level, player will lose and the game will end. At each level, the life will be restored to 5.  
	
6. **pause**+**quit** function amidst the game.
7. new **musics** for different levels and during the start of the game. (music source credit to :https://www.chosic.com/)


# Maintenance 

1. Organize the classes,files into different packages,rename them,for better clarity.
2. Remove unused files,methods and fields from the classes.

3. Remove the inheritance of **BackgroundImage** and **Digit** class from **Actor** class.

To ensure Liskov's Substitution Principle is followed as both classes aren't using the *act* method,which is an abstract method declared in the Actor class. 
4. Allow any **Node**(s) to be added into **World** class instead of only subclass objects of **Actor**.

5. Create subclasses for superclass **Level** and apply **Template-Method-Design-Pattern** where subclasses will implement the abstract methods declared in superclass *differently*. To ensure Open-Closed Principle.

6. **Factory-Design-Pattern** applied on **Level** and **Level Factory**

**LevelFactory** generates new levels based on input such as "Level1","Level2" etc. (in **froggerLevels package**)

7. **Animal** class came with lengthy codes. To clean the codes, **Strategy-Design-Pattern** is applied to the *death-checking actions*. (see **froggerAnimal_Actions package**)

Different concrete classes of animal death will implement the **AnimalDeath** interface with *different algorithm* in the animal's death execution. Animal can check and execute actions related to its death by creating AnimalDeathContext class object.

8. **Strategy-Design-Pattern** on GameActions(in **froggerGameActions package**) 

Each game action has different algorithm. Since we have several game actions which will be reused throughout the game,this design pattern can reduce redundancy and messy codes.

9. **Singleton-Design-Pattern** on StartScreen,InfoScreen ( **froggerFrames package**) as there should be only ONE StartScreen,InfoScreen throughout the game.

10. **MVC** pattern on recording and displaying HighScore

HighScoreController will update the top 5 high score records, retrieve the username and score of its HighScoreModel to its HighScoreView.

11. **Generator** classes to generate images,buttons,texts. (**froggerMaterialGenerator package**)

To reduce code redundancy in other classes in creating those elements.

