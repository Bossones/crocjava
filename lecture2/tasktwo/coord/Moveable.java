package net.crocjava.lecture2.tasktwo.coord;

/**
 * An interface for move some objects on a coordinate plane.
 */
public interface Moveable {

    /**
     * Move some objects on a coordinate plane
     *
     * @param dx x axis offset
     * @param dy y axis offset
     */
    void move(double dx, double dy);
}