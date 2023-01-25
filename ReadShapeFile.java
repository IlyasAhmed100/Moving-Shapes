/**
 * ReadShapeFile
 * This class reads a shape file. It then proceeds to read each line in the file, 
 * line by line and depending on what the shape is
 * the appropriate methods to construct the shape will be called as well as assigning 
 * information about the shape to specific variables.
 * @version 1.0.0
 * @author Ilyas Ahmed 
 * @since 2022-03-01
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/** The makeCircle function when called assigns the parameters in the file that have been split into a list
	 * and assigns them to their appropriate variables. It then constructs the circle and returns it. 
	 * @param lineSplit file lines are split into a list to get each parameter of circle.
	 * @return Circle
	 */
	private static Circle makeCircle(String[] lineSplit) {
		int insertionTime = Integer.parseInt(lineSplit[1]);
		int x = Integer.parseInt(lineSplit[2]);
		int y = Integer.parseInt(lineSplit[3]);
		int vx = Integer.parseInt(lineSplit[4]);
		int vy = Integer.parseInt(lineSplit[5]);
		boolean isFilled = Boolean.parseBoolean(lineSplit[6]);
		int diameter = Integer.parseInt(lineSplit[7]);
		Color colour = Color.rgb(Integer.parseInt(lineSplit[8]), Integer.parseInt(lineSplit[9]), Integer.parseInt(lineSplit[10]));
		Circle shape = new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled);
		return shape;
	}

	/** The makeOval function when called assigns the parameters in the file that have been split into a list
	 * and assigns them to their appropriate variables. It then constructs the oval and returns it. 
	 * @param lineSplit file lines are split into a list to get each parameter of oval.
	 * @return Oval
	 */
	private static Oval makeOval(String[] lineSplit) {
		int insertionTime = Integer.parseInt(lineSplit[1]);
		int x = Integer.parseInt(lineSplit[2]);
		int y = Integer.parseInt(lineSplit[3]);
		int vx = Integer.parseInt(lineSplit[4]);
		int vy = Integer.parseInt(lineSplit[5]);
		boolean isFilled = Boolean.parseBoolean(lineSplit[6]);
		int width = Integer.parseInt(lineSplit[7]);
		int height = Integer.parseInt(lineSplit[8]);
		Color colour = Color.rgb(Integer.parseInt(lineSplit[9]), Integer.parseInt(lineSplit[10]), Integer.parseInt(lineSplit[11]));
		Oval shape = new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
		return shape;
	}

	/** The makeSquare function when called assigns the parameters in the file that have been split into a list
	 * and assigns them to their appropriate variables. It then constructs the square and returns it. 
	 * @param lineSplit file lines are split into a list to get each parameter of square.
	 * @return Square
	 */
	private static Square makeSquare(String[] lineSplit) {
		int insertionTime = Integer.parseInt(lineSplit[1]);
		int x = Integer.parseInt(lineSplit[2]);
		int y = Integer.parseInt(lineSplit[3]);
		int vx = Integer.parseInt(lineSplit[4]);
		int vy = Integer.parseInt(lineSplit[5]);
		boolean isFilled = Boolean.parseBoolean(lineSplit[6]);
		int side = Integer.parseInt(lineSplit[7]);
		Color colour = Color.rgb(Integer.parseInt(lineSplit[8]), Integer.parseInt(lineSplit[9]), Integer.parseInt(lineSplit[10]));
		Square shape = new Square(insertionTime, x, y, vx, vy, side, colour, isFilled);
		return shape;
	}

	/** The makeRect function when called assigns the parameters in the file that have been split into a list
	 * and assigns them to their appropriate variables. It then constructs the rectangle and returns it. 
	 * @param lineSplit file lines are split into a list to get each parameter of rectangle.
	 * @return Rect
	 */
	private static Rect makeRect(String[] lineSplit) {
		int insertionTime = Integer.parseInt(lineSplit[1]);
		int x = Integer.parseInt(lineSplit[2]);
		int y = Integer.parseInt(lineSplit[3]);
		int vx = Integer.parseInt(lineSplit[4]);
		int vy = Integer.parseInt(lineSplit[5]);
		boolean isFilled = Boolean.parseBoolean(lineSplit[6]);
		int width = Integer.parseInt(lineSplit[7]);
		int height = Integer.parseInt(lineSplit[8]);
		Color colour = Color.rgb(Integer.parseInt(lineSplit[9]), Integer.parseInt(lineSplit[10]), Integer.parseInt(lineSplit[11]));
		Rect shape = new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
		return shape;
	}

	/** The makeTriangle function when called assigns the parameters in the file that have been split into a list
	 * and assigns them to their appropriate variables. It then constructs the triangle and returns it. 
	 * @param lineSplit file lines are split into a list to get each parameter of triangle.
	 * @return Triangle
	 */
	private static Triangle makeTriangle(String[] lineSplit) {
		int insertionTime = Integer.parseInt(lineSplit[1]);
		int x = Integer.parseInt(lineSplit[2]);
		int y = Integer.parseInt(lineSplit[3]);
		int vx = Integer.parseInt(lineSplit[4]);
		int vy = Integer.parseInt(lineSplit[5]);
		boolean isFilled = Boolean.parseBoolean(lineSplit[6]);
		int width = Integer.parseInt(lineSplit[7]);
		int height = Integer.parseInt(lineSplit[8]);
		Color colour = Color.rgb(Integer.parseInt(lineSplit[9]), Integer.parseInt(lineSplit[10]), Integer.parseInt(lineSplit[11]));
		Triangle shape = new Triangle(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
		return shape;
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue.
	 * @param in the scanner of the file.
	 * @return the queue represented by the data file.
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		
		while (in.hasNextLine()) {
			String eachLine;
			String[] lineSplit;
			eachLine = in.nextLine();
			lineSplit = eachLine.split(" ");

			if (lineSplit[0].equals("circle")) {
				shapeQueue.enqueue(makeCircle(lineSplit));
			} else if (lineSplit[0].equals("oval")) {
				shapeQueue.enqueue(makeOval(lineSplit));
			} else if (lineSplit[0].equals("square")) {
				shapeQueue.enqueue(makeSquare(lineSplit));
			} else if (lineSplit[0].equals("rect")) {
				shapeQueue.enqueue(makeRect(lineSplit));
			} else if (lineSplit[0].equals("triangle")) {
				shapeQueue.enqueue(makeTriangle(lineSplit));
			}
		}
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
	    Scanner in = new Scanner(System.in); //null is not sensible. Please change
	    File newFile = new File(filename);

		try {
			in = new Scanner(newFile);
		} catch (FileNotFoundException e) {
			System.err.println("Could not find " + filename);
			System.exit(0);
		}
		return ReadShapeFile.readLineByLine(in);
	}
}