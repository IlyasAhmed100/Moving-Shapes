/**
 * Square
 * Square is a square shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * square's bounding rectangle.
 * @version 1.0.0
 * @author Ilyas Ahmed 
 * @since 2022-03-01
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {
    // The side of the square
    private int side;

     /**
	 * Creates a square.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param side The side of the square (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the square is filled with colour, false if opaque.
	 */

    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        setSide(side);
    }

    /**
     * Method to convert a rectangle to a string.
     */
    public String toString() {
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side is " + side + "\n";
        return result;
    }

    /**
 	 * @return The side of the square.
 	 */
    public int getSide() {
        return side;
    }

    /**
	 * @param side Resets the side.
	 */
    public void setSide(int side) {
        this.side = side;
    }

    /**
 	 * Draw the square.
 	 * @param g The graphics object of the drawable component.
 	 */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }
    }

    /**
 	 * @return The side of the square.
 	 */
    public int getWidth() {
        return side;
    }

    /**
 	 * @return The side of the square.
 	 */
    public int getHeight() {
        return side;
    }
}
