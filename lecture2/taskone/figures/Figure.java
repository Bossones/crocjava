package net.crocjava.lecture2.taskone.figures;

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
}