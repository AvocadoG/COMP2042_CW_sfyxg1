package froggerJUnittest;

import static org.junit.Assert.*;
import org.junit.Test;

import javafx.embed.swing.JFXPanel;

import froggerActors.*;

/** Test {@link froggerActors.Log} class*/
public class LogTest {

	Log log1,log2;
	
	JFXPanel p = new JFXPanel();


	/**Test logs with or without bombs*/
	@Test
	public void test_Log_hasbomb() {
		
		//set up log 1 without bombs, going left
		log1 = new Log("file:src/main/resources/froggertextures/logs.png", 300, 400, 276, -2*1.3);
		//set up log 2 with bombs, going right
		log2 = new Log("file:src/main/resources/froggertextures/logsbomb.png", 150, 50, 318, 0.75*1.3,true);
		
		
		assertFalse("Log has no bomb",log1.hasbomb());
		assertTrue("Log has bombs",log2.hasbomb());
	}
	
	/**Test logs moving direction*/
	@Test
	public void test_Log_goingleft() {
		
		//set up log 1 without bombs, going left
		log1 = new Log("file:src/main/resources/froggertextures/logs.png", 300, 400, 276, -2*1.3);
		//set up log 2 with bombs, going right
		log2 = new Log("file:src/main/resources/froggertextures/logsbomb.png", 150, 50, 318, 0.75*1.3,true);
				
					
		assertTrue("Log going left",log1.goingLeft());
		assertFalse("Log is not going left",log2.goingLeft());
	}

}
