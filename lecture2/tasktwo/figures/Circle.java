package net.crocjava.lecture2.tasktwo.figures;

import net.crocjava.lecture2.tasktwo.coord.*;

/**
 * A {@code Circle} is a circle shape and described by two parameters:
 * Coordinate of center of this {@code Circle}
 * Radius of this {@code Circle}
 *
 * @see Figure
 * @see Coordinate
 */
public class Circle implements Figure, Moveable {

    /**
     * The coordinate of the center of this {@code Circle}
     * If no center is set it will default to {@code (0,0)}.
     */
    private Coordinate center;

    /**
     * The radius of this {@code Circle}
     * If no radius is set it will set default to {@code (0,0)}
     */
    private double radius;

    /**
     * Constructs a {@code Circle} with no parameters.
     */
    public Circle() {
        center = new Coordinate();
        radius = 0.0;
    }

    /**
     * Constructs a {@code Circle} with next parameters:
     * If a radius is negative, then radius will set to default 0.
     *
     * @param center is a coordinate of the center {@code Circle}.
     * @param radius is a radius of {@code Circle}.
     */
    public Circle(Coordinate center, double radius) {
        if (center == null)
            throw  new NullPointerException();
        this.center = new Coordinate(center);
        if (radius >= 0)
            this.radius = radius;
        else
            this.radius = 0;
    }

    /**
     * Constructs a {@code Circle} with next parameters:
     * If a radius is negative, then radius will set to default 0.
     *
     * @param x is an abscissa of the coordinate of the center {@code Circle}.
     * @param y is an ordinate of the coordinate of the center {@code Circle}.
     * @param radius is a radius of {@code Circle}.
     */
    public Circle(double x, double y, double radius) {
        center = new Coordinate(x, y);
        if (radius >= 0)
            this.radius = radius;
        else
            this.radius = 0;
    }

    /**
     * Copy constructor
     *
     * @param circle is a circle to copy.
     */
    public Circle(Circle circle) {
        if (circle == null)
            throw new NullPointerException();
        center = new Coordinate(circle.getCenter());
        radius = circle.getRadius();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String shapeName() {
        return "Circle";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(double dx, double dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    /**
     * @return radius of this {@code Circle}.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @return center's coordinate.
     */
    public Coordinate getCenter() {
        return center;
    }

    /**
     * Sets new coordinate for center and new radius value for radius of this {@code Circle}
     * If {@param radius} is negative it will not change.
     *
     * @param center is a center coordinate of circle.
     * @param radius is a radius of circle.
     */
    public void setParameters(Coordinate center, double radius) {
        if (center == null)
            throw new NullPointerException();
        this.center.setCoordinate(center);
        if (radius >= 0)
            this.radius = radius;
    }

    /**
     * Sets new coordinate for center and new radius value for radius of this {@code Circle}
     * If {@param radius} is negative it will not change.
     *
     * @param x is an abscissa of the center coordinate.
     * @param y is an ordinate of the center coordinate.
     * @param radius is a radius of circle.
     */
    public void setParameters(double x, double y, double radius) {
        center.setX(x);
        center.setY(y);
        if (radius >= 0)
            this.radius = radius;
    }
}

