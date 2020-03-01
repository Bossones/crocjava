package net.crocjava.lecture2.tasktwo.figures;

import net.crocjava.lecture2.tasktwo.coord.Moveable;

/**
 * A {@code Figure} is a abstract shape.
 */
public interface Figure {

    /**
     * This function calculates area of this {@code Figure}
     * @return area of this {@code Figure}.
     */
    double area();

    /**
     * This function calculates perimeter of this {@code Figure}
     * @return perimeter of this {@code Figure}.
     */
    double perimeter();

    /**
     * @return name of this {@code Figure}
     */
    String shapeName();

    /**
     * This function finds point inside this {@code Figure}
     *
     * @param x is an abscissa of point coordinate.
     * @param y is an ordinate of point coordinate.
     * @return true if the point is inside this {@code Figure}, false - another way.
     */
    boolean findPoint(double x, double y);
}