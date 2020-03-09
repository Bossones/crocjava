package taskone;

/**
 * The class describes a chess figure position on the chess board.
 */
public class ChessFigurePosition {

    /**
     * Length of the chess board.
     * If no x set it will be sets default to 0.
     */
    private int x;

    /**
     * High of the chess board.
     * If no y set it will be sets default to 0.
     */
    private int y;

    /**
     * Construct this {@code ChessFigurePosition} with no parameters.
     */
    public ChessFigurePosition() {
        setPosition(0, 0);
    }

    /**
     * Construct this {@code ChessFigurePosition} with the arguments:
     * @param x - the length of the chess board
     * @param y - the high of the chess board
     */
    public ChessFigurePosition(int x, int y) {
        setPosition(x, y);
    }

    /**
     * Sets new position for this {@code ChessFigurePosition}
     * @param x - the length of the chess board.
     * @param y - the high of the chess board.
     */
    public void setPosition(int x, int y) {
        if (x < 0 || y < 0 || x > 7 || y > 7) {
            throw new IllegalArgumentException("Wrong chess figure position");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Sets y position for this {@code ChessFigurePosition}
     * @param y - the high of the chess board.
     */
    public void setY(int y) {
        setPosition(x, y);
    }

    /**
     * Sets x position for this {@code ChessFigurePosition}
     * @param x - the length of the chess board.
     */
    public void setX(int x) {
        setPosition(x, y);
    }

    /**
     * @return x position of the chess figure.
     */
    public int getX() {
        return x;
    }

    /**
     * @return y position of the chess figure.
     */
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        return "" + alphabet[x] + (y + 1);
    }


    public static void main(String[] args) {
        ChessFigurePosition cfp = new ChessFigurePosition(1, 1);
        System.out.println(cfp); // print current position
        cfp.setPosition(5, 5); // set new position
        System.out.println(cfp); // print current position
        System.out.println(cfp.getX()); // get x
        cfp.setX(2); // set x
        System.out.println(cfp); // print current position
    }
}

/* Output:
    b2
    f6
    5
    c6
 */
