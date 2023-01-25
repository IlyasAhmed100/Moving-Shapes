/**
 * Rect
 * Rect is a rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle's bounding rectangle.
 * @version 1.0.0
 * @author Ilyas Ahmed 
 * @since 2022-03-01
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends ClosedShape {
    // The height and width of the rectangle
    private int width;
    private int height;

    /**
	 * Creates a rectangle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the rectangle (in pixels).
	 * @param height The height of the rectangle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the rectangle is filled with colour, false if opaque.
	 */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        setWidth(width);
        setHeight(height);
    } 

    /**
     * Method to convert a rectangle to a string.
     */
    public String toString() {
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + width + " and its height is " + height + "\n";
        return result;
    }

    /**
 	 * @return The width of the rectangle.
 	 */
    public int getWidth() {
        return width;
    }

    /**
	 * @param width Resets the width.
	 */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
 	 * @return The height of the rectangle.
 	 */
    public int getHeight() {
        return height;
    }

     /**
 	 * @param height Resets the height.
 	 */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
 	 * Draw the rectangle.
 	 * @param g The graphics object of the drawable component.
 	 */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect( x, y, width, height);
        } else {
            g.strokeRect(x, y, width, height);
        }
    }
}
