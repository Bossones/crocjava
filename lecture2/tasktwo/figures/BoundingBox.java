package net.crocjava.lecture2.tasktwo.figures;

import net.crocjava.lecture2.tasktwo.coord.Coordinate;
import net.crocjava.lecture2.tasktwo.coord.Moveable;

/**
 * A {@code BoundingBox} is a box and described by two parameters:
 * Coordinate of lower left corner of this {@code BoundingBox}
 * Coordinate of upper right corner of this {@code BoundingBox}
 *
 * @see Figure
 * @see Coordinate
 */
public class BoundingBox implements Figure, Moveable {

    /**
     * The coordinate of the lower left corner of this {@code BoundingBox}
     * If no lower left corner is set it will default to {@code (0,0)}.
     */
    private Coordinate lowerLeftCorner;

    /**
     * The coordinate of the upper right corner of this {@code BoundingBox}
     * If no upper right corner is set it will default to {@code (0,0)}.
     */
    private Coordinate upperRightCorner;

    /**
     * Constructs a {@code BoundingBox} with no parameters.
     */
    public BoundingBox() {
        setCoordinates(new Coordinate(), new Coordinate());
    }

    /**
     * Constructs a {@code BoundingBox} with coordinates for the lower left and upper right corners.
     * If an abscissa or an ordinate of {@param upperRightCorner} coordinate is less than
     * the abscissa or the ordinate of {@param upperRightCorner} coordinate,
     * then coordinates of corners will set to {@code (0,0)}.
     *
     * @param lowerLeftCorner is a coordinate of lower left corner.
     * @param upperRightCorner is a coordinate of upper right corner.
     */
    public BoundingBox(Coordinate lowerLeftCorner, Coordinate upperRightCorner) {
        if (lowerLeftCorner == null || upperRightCorner == null)
            throw new NullPointerException();
        if (lowerLeftCorner.getX() > upperRightCorner.getX() || lowerLeftCorner.getY() > upperRightCorner.getY()) {
            setCoordinates(new Coordinate(), new Coordinate());
        } else {
            setCoordinates(lowerLeftCorner, upperRightCorner);
        }
    }

    /**
     * Constructs a {@code BoundingBox} with coordinates for the lower left and upper right corners.
     * If {@param x2} is less than {@param x1} or {@param y2} is less than {@param y1}, then
     * coordinates of corners will set to {@code (0,0)}
     *
     * @param x1 is an abscissa of the lower left corner coordinate.
     * @param y1 is an ordinate of the lower left corner coordinate.
     * @param x2 is an abscissa of the upper right corner coordinate.
     * @param y2 is an ordinate of the upper right corner coordinate.
     */
    public BoundingBox(double x1, double y1, double x2, double y2) {
        if (x2 < x1 || y2 < y1) {
            setCoordinates(new Coordinate(), new Coordinate());
        } else {
            setCoordinates(new Coordinate(x1, y1), new Coordinate(x2, y2));
        }
    }

    /**
     * Copy constructor
     *
     * @param boundingBox is a box to copy.
     */
    public BoundingBox(BoundingBox boundingBox) {
        if (boundingBox == null)
            throw new NullPointerException();
        lowerLeftCorner = new Coordinate( boundingBox.getLowerLeftCorner() );
        upperRightCorner = new Coordinate( boundingBox.getUpperRightCorner() );
    }

    /**
     * @return the lower left corner coordinate of {@code BoundingBox}
     */
    public Coordinate getLowerLeftCorner() { return lowerLeftCorner; }

    /**
     * @return the upper right corner coordinate of {@code BoundingBox}
     */
    public Coordinate getUpperRightCorner() { return upperRightCorner; }

    /**
     * {@inheritDoc}
     */
    @Override
    public double area() {
        return ( upperRightCorner.getX() - lowerLeftCorner.getX() ) *
                ( upperRightCorner.getY() - lowerLeftCorner.getY() );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double perimeter() {
        return 2 * ( ( upperRightCorner.getX() - lowerLeftCorner.getX() ) +
                ( upperRightCorner.getY() - lowerLeftCorner.getY() ) );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String shapeName() { return "BoundingBox"; }

    public boolean findPoint(Coordinate point) {
        if (point == null)
            throw new NullPointerException();
        return findPoint(point.getX(), point.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean findPoint(double x, double y) {
        return x <= upperRightCorner.getX() && x >= lowerLeftCorner.getX() &&
                y <= upperRightCorner.getY() && y >= lowerLeftCorner.getY();
    }

    /**
     * This function sets new coordinates for the current {@code BoundingBox}'s coordinates.
     * If an abscissa or an ordinate of {@param upperRightCorner} coordinate is less than
     * the abscissa or the ordinate of {@param upperRightCorner} coordinate,
     * then coordinates will not change.
     *
     * @param lowerLeftCorner is a new value for the current coordinate of the lower left corner.
     * @param upperRightCorner is a new value for the current coordinate of the upper right corner.
     */
    public void setCoordinates(Coordinate lowerLeftCorner, Coordinate upperRightCorner) {
        if (lowerLeftCorner == null || upperRightCorner == null)
            throw new NullPointerException();
        if (upperRightCorner.getX() >= lowerLeftCorner.getX() && upperRightCorner.getY() >= lowerLeftCorner.getY()) {
            this.lowerLeftCorner = lowerLeftCorner;
            this.upperRightCorner = upperRightCorner;
        }
    }

    /**
     * This function sets new coordinates for the current {@code BoundingBox}'s coordinates
     * If {@param x2} is less than {@param x1} or {@param y2} is less than {@param y1}, then
     * coordinates of corners will not change.
     *
     * @param x1 is an abscissa of the lower left corner coordinate.
     * @param y1 is an ordinate of the lower left corner coordinate.
     * @param x2 is an abscissa of the upper right corner coordinate.
     * @param y2 is an ordinate of the upper right corner coordinate.
     */
    public void setCoordinates(double x1, double y1, double x2, double y2) {
        if (x2 >= x1 && y2 >= y1) {
            lowerLeftCorner.setX(x1);
            lowerLeftCorner.setY(y1);
            upperRightCorner.setX(x2);
            upperRightCorner.setY(y2);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(double dx, double dy) {
        setCoordinates(lowerLeftCorner.getX() + dx, lowerLeftCorner.getY() + dy,
                upperRightCorner.getX() + dx, upperRightCorner.getY() + dy);
    }
}
