package drawtest;
import java.util.Scanner;

/**
 * A class that contains static methods to check
 * the validity of the user's input, as well as 
 * a main method to run the program.
 * @author og
 *
 */

public class Draw {

	/**
	 * A boolean method which checks whether the input 
	 * represents one of the two shape selection choices
	 * @param input string
	 * @return boolean that says whether the choice is 
	 * one of the two valid choices for a shape
	 */
    public static boolean isChoiceShape(String input) {
        return (input.equalsIgnoreCase("p") 
                || input.equalsIgnoreCase("x"));
    }

    /**
     * A method which checks whether the input 
     * represents the choice to exit the program
     * @param input string
     * @return boolean value which says whether we should
     * exit the program
     */
    public static boolean shouldQuit(String input) {
        return input.equalsIgnoreCase("q");
    }

    /**
     * A method which, given a valid choice of shape and the 
     * desired number of rows, returns the string that represents 
     * the selected shape. The method throws an exception if the 
     * number of rows is not positive
     * @param choice of shape
     * @param number of rows
     * @return A string which represents the selected shape
     * @throws IllegalArgumentException if the number of 
     * rows is not positive
     */
    public static String getShapeString(String choice, int numRows) {

        String result = "";
        Shape shape;

        if (numRows <= 0) {
            throw new IllegalArgumentException();
        }

        if (choice.equalsIgnoreCase("p")) {
            shape = new Pyramid(numRows);
            result = shape.shapeAsString();
        } 
        else if (choice.equalsIgnoreCase("x")) {
            shape = new XCross(numRows);
            result = shape.shapeAsString();
        }
        else {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputChoice, inputNum;

        System.out.println("Welcome!");

        while (true) {  
//        	  show the main menu
            System.out.print("\nHere is the Main Menu:\n");
            System.out.print("- Select \'p\' to draw a pyramid shape\n");
            System.out.print("- Select \'x\' to draw an X shape\n");
            System.out.print("- Select \'q\' to quit this program\n");
            System.out.print("Please enter your selection here: ");
            
//            obtain the input string. remove white space if needed
            inputChoice = scanner.nextLine().trim();

//         	  quit if the user chooses to
            if (shouldQuit(inputChoice)) {
                System.out.print("\nSorry to see you leaving. "); 
                System.out.print("Hoping to see you again soon. ");
                System.out.print("Take care and g\'bye!\n\n");
                break;
            }
//            else if user chose a valid shape
            else if (isChoiceShape(inputChoice)) {
                while (true) {
                    System.out.print("Please enter the number of rows");
                    System.out.print(" (must be a positive integer): ");
                    inputNum = scanner.nextLine().trim();
                    try {
//                    	  get the number of rows as input and try to convert to int
                        int numRows = Integer.parseInt(inputNum);
                        String result = getShapeString(inputChoice, numRows);
                        System.out.print("Here is the shape:\n\n");                 
                        System.out.print(result);
                        break;      
                    }
                    catch (IllegalArgumentException e) {
                        System.out.print("Sorry, input must be a positive integer.");
                        System.out.print(" Please try again.\n");
                    }
                }
            }
//            otherwise ask user for valid input
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}