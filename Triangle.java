/**
 * Triangle
 * Triangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the triangle's bounding rectangle.
 * @version 1.0.0
 * @author Ilyas Ahmed 
 * @since 2022-03-01
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends ClosedShape {
    // The height and width of the triangle.
    private int width;
    private int height;
    private static final int NUM_SIDES = 3;

    /**
	 * Creates an triangle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the triangle (in pixels).
	 * @param height The height of the triangle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the triangle is filled with colour, false if opaque.
	 */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        setHeight(height);
        setWidth(width);
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its width is " + width + " and its height is " + height + "\n";
        return result;
    }

    /**
 	 * @return The width of the triangle.
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
 	 * @return The height of the triangle.
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

    /** The method calculates the x-coordinates of the triangle.
     * @return double[]
     */
    public double[] getXCoords() {
       double xPoints[];
       xPoints = new double[] {x + height, x , x + height};
       return xPoints;
    }

    /** The method calculates the y-coordinates of the triangle.
     * @return double[]
     */
    public double[] getYCoords() {
        double yPoints[];
        yPoints = new double[] {y + (width / 2), y , y - (width / 2)};
        return yPoints;
    }

    /**
 	 * Draw the triangle.
 	 * @param g The graphics object of the drawable component.
 	 */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillPolygon(getXCoords(), getYCoords(), NUM_SIDES);
        } else {
            g.strokePolygon(getXCoords(), getYCoords(), NUM_SIDES);
        }
    }
}