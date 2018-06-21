package drawtest;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class for the Pyramid class
 * @author og
 *
 */

public class PyramidTest {
	
	/**
	 * A private method that builds the pyramid string in a different 
	 * way, this time using a two dimensional array. Later can
	 * compare the output with the output from the Pyramid class
	 * method.
	 * @param height of the pyramid
	 * @return string object with the pyramid
	 */
	private String buildFromArray(int n) {
		int width = 2 * (n - 1) + 1;
		int height = n;
		char[][] arr = new char[height][width+1];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < height; col++) {
				arr[row][col] = (row + col < height - 1) ? ' ' : '*';
				arr[row][width-1-col] = arr[row][col];
			}
			arr[row][width] = '\n';
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
	 * Consider pyramids with number of rows between 1 and 50.
	 */
	@Test
	public void testShapeAsString() {
		for (int i = 1; i <= 50; i++) {
			Pyramid p = new Pyramid(i);
			assertEquals(p.shapeAsString(), buildFromArray(i));
		}
	}
}
