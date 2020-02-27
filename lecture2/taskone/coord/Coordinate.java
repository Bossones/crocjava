package net.crocjava.lecture2.taskone.coord;

/**
 * This class is used to store coordinates on the coordinate plane.
 */
public class Coordinate {

    /**
     * The X coordinate of this {@code Coordinate}.
     * If no X coordinate is set it will default to 0.
     */
    private double x;

    /**
     * The Y coordinate of this {@code Coordinate}.
     * If no Y coordinate is set it will default to 0.
     */
    private double y;

    /**
     * Constructs a {@code Coordinate} with no parameters.
     */
    public Coordinate() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a {@code Coordinate} with parameters:
     *
     * @param x is an abscissa
     * @param y is an ordinate
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a {@code Coordinate} with parameters:
     *
     * @param coordinate of a point on a coordinate plane.
     */
    public Coordinate(Coordinate coordinate) {
        if (coordinate == null)
            throw new NullPointerException();
        x = coordinate.x;
        y = coordinate.y;
    }

    /**
     * The function sets new values of x and y to the current coordinate.
     *
     * @param coordinate of a point on a coordinate plane.
     */
    public void setCoordinate(Coordinate coordinate) {
        if (coordinate == null)
            throw new NullPointerException();
        x = coordinate.x;
        y = coordinate.y;
    }

    /**
     * The function sets a new value of x for the current abscissa x.
     * @param x is a new abscissa's value.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * The function sets a new value of y for the current ordinate y.
     * @param y is a new ordinate's value.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return an point's abscissa x.
     */
    public double getX() {
        return x;
    }

    /**
     * @return an point's ordinate y.
     */
    public double getY() {
        return y;
    }

}
