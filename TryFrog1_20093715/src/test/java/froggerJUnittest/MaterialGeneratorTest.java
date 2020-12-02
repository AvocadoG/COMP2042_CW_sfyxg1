package froggerJUnittest;

import static org.junit.Assert.*;

import org.junit.Test;

import froggerMaterialGenerator.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Test for the generator classes in {@link froggerMaterialGenerator} package
 * @author User
 *
 */
public class MaterialGeneratorTest {

	ImageGenerator imggen;
	ButtonGenerator btngen;
	TextGenerator txtgen;
	JFXPanel p = new JFXPanel();
	
	/**Test ImageGenerator generates image with syncing properties*/
	@Test
	public void test_ImageGenerator() {
		
		Image img1,imgtest;
		
		//create an image generator
		imggen=new ImageGenerator();
		
		//create an image manually for testing
		imgtest = new Image("file:src/main/resources/animalimage/froggerUp.png");
		
		//create an image using the generator
		img1 =  imggen.generate("file:src/main/resources/animalimage/froggerUp.png", 20, 30);
		
		assertEquals(imgtest.getClass(),img1.getClass());//Image element
		assertTrue("image is 20 wide",20==(int)img1.getRequestedWidth());//sync width
		assertTrue("image is 30 high",30==(int)img1.getRequestedHeight());//sync height
		
	}
	
	/** Test TextGenerator generates text with syncing properties*/
	@Test
	public void test_TextGenerator() {
		
		Text txt1, txttest;
		
		//create a text generator
		txtgen=new TextGenerator();
		
		//create an empty text manually for test
		txttest = new Text();
		
		//create content 
		String txtcontent = "HelloWorld";
		
		//create text using the generator
		txt1 = txtgen.generate(txtcontent, "ChickenPie", 20, TextAlignment.CENTER, Color.BLACK);
		
		assertEquals(txttest.getClass(),txt1.getClass());//Text element
		assertEquals(txtcontent,txt1.getText());//sync content
		assertTrue("txt1 is black in color",Color.BLACK==txt1.getFill());//sync color
		assertTrue("txt1 is in center alignment",TextAlignment.CENTER==txt1.getTextAlignment());//sync text alignment

	}
	
	
	/** Test ButtonGenerator generates button with syncing properties*/
	@Test
	public void test_ButtonGenerator() {
		
		Button btn1, btntest;
		
		//create a button generator
		btngen = new ButtonGenerator();
		
		//create an empty button manually for testing
		btntest = new Button();
		
		//create a button using the generator
		btn1 = btngen.generate("file:src/main/resources/froggertextures/startbtnfrogger.png",140,50);
		
		assertEquals(btntest.getClass(),btn1.getClass());//Button element
		assertTrue("button is 140 wide in min",140==(int)btn1.getMinWidth());//sync width
		assertTrue("button is 50 high in min",50==(int)btn1.getMinHeight());//sync height
		assertTrue("button is 140 wide in max",140==(int)btn1.getMaxWidth());//sync width
		assertTrue("button is 50 high in max",50==(int)btn1.getMaxHeight());//sync height
	}

}
