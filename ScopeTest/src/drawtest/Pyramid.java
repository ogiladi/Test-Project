package drawtest;
/**
 * A class that represents a pyramid (Christmas
 * Tree). Extends the Shape class and overrides
 * the shapeAsString method
 * @author og
 *
 */

public class Pyramid extends Shape {

    public Pyramid(int numRows) {
        this.height = numRows;
        this.width = 2 * (numRows - 1) + 1;
    }
    
    @Override
    public String shapeAsString() {

        StringBuilder sb = new StringBuilder();
        int midCol = height - 1; // the 'middle' of the tree

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col >= midCol - row && col <= midCol + row) {
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