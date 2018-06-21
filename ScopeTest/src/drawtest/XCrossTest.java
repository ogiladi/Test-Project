package drawtest;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class for the XCross class.
 * @author og
 *
 */

public class XCrossTest {
	
	/**
	 * A private method to build the string for the X shape
	 * in a different way, using an array. Can later compare  
	 * with the method from the XCross class to see
	 * whether the same string is obtained.
	 * @param The height of the shape.
	 * @return A string object with an X shape.
	 */
	private String buildFromArray(int n) {
		int width = 2 * (n - 1) + 1;
		int height = n;
		
		char[][] arr = new char[height][width+1];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				arr[row][col] = ' ';
			}
			arr[row][width] = '\n';
		}
		for (int row = 0; row < height; row++) {
			arr[row][row*2] = '*';
			arr[row][width-1-row*2] = '*';
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col <= width; col++) {
				sb.append(arr[row][col]);
			}
		}
		return sb.toString();
		
	}

	/**
	 * Compare the string output from the two different methods.
	 * Consider X shapes with the number of rows from 1 to 50.
	 */
	@Test
	public void testShapeAsString() {
		for (int i = 1; i <= 50; i++) {
			XCross x = new XCross(i);
			assertEquals(x.shapeAsString(), buildFromArray(i));
		}
	}
}
