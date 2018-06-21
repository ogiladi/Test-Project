# A Simple Test Project

A simple console application in Java: The user is presented with an options menu,
the program then checks the validity of the input and prints a shape to the console.

A .jar file is included, as well as several test classes.

To run the program using the .jar file on a terminal, in the project directory type: java -jar DrawTest.jar

To compile and run the non-test classes on a terminal, in the project directory type: 
javac -d bin -cp bin src/drawtest/Draw.java src/drawtest/Shape.java src/drawtest/Pyramid.java src/drawtest/XCross.java

To then run the program on a terminal, type: java -cp bin drawtest.Draw

You can run the test classes from an IDE which supports JUnit (e.g., Eclipse)
