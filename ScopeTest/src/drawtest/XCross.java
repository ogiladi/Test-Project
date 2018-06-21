package drawtest;
/**
 * A class that represents an X shape.
 * Extends the Shape class and 
 * overrides the shapeAsString method.
 * @author og
 *
 */

public class XCross extends Shape {

    public XCross(int numRows) {
        this.height = numRows;
        this.width = 2 * (numRows - 1) + 1;
    }

    @Override
    public String shapeAsString() {

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == row * 2 || col == width - 1 - row * 2) {
                    sb.append('*');
                } 
                else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    } 
}