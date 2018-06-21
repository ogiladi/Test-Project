package drawtest;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class for the Draw class
 * @author og
 *
 */

public class DrawTest {

	/**
	 * Test whether the isChoiceShape method is working
	 * using different inputs
	 */
	@Test
	public void testIsChoiceShape() {
//		go over all lower case characters to check matching
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (ch == 'p' || ch == 'x') {
				assertTrue(Draw.isChoiceShape(String.valueOf(ch)));
			}
			else {
				assertFalse(Draw.isChoiceShape(String.valueOf(ch)));
			}
		}
		
//		go over all upper case characters to check matching
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (ch == 'P' || ch == 'X') {
				assertTrue(Draw.isChoiceShape(String.valueOf(ch)));
			}
			else {
				assertFalse(Draw.isChoiceShape(String.valueOf(ch)));
			}
		}
		
//		check 1000 random strings of length between 2 and 30
		for (int i = 0; i < 1000; i++) {
			int wordLen = 2 + (int) (Math.random() * 29);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < wordLen; j++) {
				char ch = (char) Math.floor((Math.random() * 256));
				sb.append(ch);
			}
			String randWord = sb.toString();
			assertFalse(Draw.isChoiceShape(randWord));		
		}
	}
	
	/**
	 * Test whether the shouldQuit method is working
	 * using different inputs
	 */
	@Test
	public void testShouldQuit() {
//		go over all lower case characters to check matching
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (ch == 'q') {
				assertTrue(Draw.shouldQuit(String.valueOf(ch)));
			}
			else {
				assertFalse(Draw.shouldQuit(String.valueOf(ch)));
			}
		}
		
//		go over all upper case characters to check matching
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (ch == 'Q') {
				assertTrue(Draw.shouldQuit(String.valueOf(ch)));
			}
			else {
				assertFalse(Draw.shouldQuit(String.valueOf(ch)));
			}
		}
			
//		check 1000 random strings of length between 2 and 30
		for (int i = 0; i < 1000; i++) {
			int wordLen = 2 + (int) (Math.random() * 29);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < wordLen; j++) {
				char ch = (char) Math.floor((Math.random() * 256));
				sb.append(ch);
			}
			String randWord = sb.toString();
			assertFalse(Draw.shouldQuit(randWord));		
		}
	}
	
	/**
	 * Test whether an exception is
	 * thrown when the user inputs a negative 
	 * number of rows, which is randomly chosen
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetShapeInvalidInput() {
//		choose a random number of rows between -99 and 0
		int invalidNumRows = - (int)(Math.random() * 100);
//		make a random choice of a pyramid or an X shape
		double rand = Math.random();
		String choice = rand < 0.5 ? "p" : "x";
		Draw.getShapeString(choice, invalidNumRows);
	}

}
