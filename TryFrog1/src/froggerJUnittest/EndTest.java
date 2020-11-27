package froggerJUnittest;

import static org.junit.Assert.*;

import org.junit.Test;

import froggerActors.End;
import javafx.embed.swing.JFXPanel;

/** Test on {@link froggerActors.End} class */
public class EndTest {

	End end1,end2;
	JFXPanel p = new JFXPanel();
	
	/** Test for creating End with and without coin */
	@Test
	public void test_End_hasCoin() {
		
		//create a new end without coin
		end1=new End(2,2,false);
		//create a new end with coin
		end2=new End(2,2,true);
		
		//check
		assertFalse("End has no coin",end1.hasCoin());
		assertTrue("End has coin",end2.hasCoin());
		
	}
	
	/** Test End starts with not being occupied by default*/
	@Test
	public void test_End_default_notoccupied() {
		
		//create a new end
		end1=new End(2,2,true);
		
		//end is not occupied
		assertFalse("End is not occupied",end1.isOccupied());
	}
	
	/** Test when End is setEndOccupied() with Animal, it is occupied and has no coin*/
	@Test
	public void test_End_setEndOccupied() {
		
		//create a new end with coin
		end1=new End(2,2,true);
		
		//end has coin and is not occupied
		assertTrue("End has coin",end1.hasCoin());
		assertFalse("End is not occupied",end1.isOccupied());
		
		//set end to being occupied by animal
		end1.setEndOccupied();
		
		//end now has no coin and is marked occupied
		assertFalse("End has no coin",end1.hasCoin());
		assertTrue("End is occupied",end1.isOccupied());
	}


}
