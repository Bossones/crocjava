import net.crocjava.lecture2.tasktwo.coord.Coordinate;
import net.crocjava.lecture2.tasktwo.figures.*;

public class Annotation {

    /**
     * The shape for this {@code Annotation}
     * If no shape is set it will default to {@code BoundingBox}
     */
    private Figure shape;

    /**
     * Name of the shape field.
     * If no name is set it will default to "Zero Bounding Box".
     */
    private String nameOfField;

    /**
     * Constructs a {@code Circle} with no parameters.
     */
    public Annotation() {
        shape = new BoundingBox(0, 0, 0, 0);
        nameOfField = "Zero Bounding Box";
    }

    /**
     * Constructs a {@code Annotation} with the next parameters:
     *
     * @param shape is a some shape for the annotation.
     * @param nameOfField is a name for the annotation.
     */
    public Annotation(Figure shape, String nameOfField) {
        if (shape == null || nameOfField == null)
            throw new NullPointerException();
        setParameters(shape, nameOfField);
    }

    /**
     * @return annotation's shape.
     */
    public Figure getShape() {
        return shape;
    }

    /**
     * @return name of field for annotation.
     */
    public String getNameOfField() {
        return nameOfField;
    }

    /**
     * Sets new parameters for this {@code Annotation}
     *
     * @param shape is a new shape for annotation.
     * @param nameOfField is a new name of field dor annotation.
     */
    public void setParameters(Figure shape, String nameOfField) {
        if (shape == null || nameOfField == null)
            throw new NullPointerException();
        this.shape = shape;
        this.nameOfField = nameOfField + "";
    }

    /**
     * This function found annotation with same coordinates.
     *
     * @param annotations array of annotations.
     * @param x is an abscissa of coordinate.
     * @param y is an ordinate of coordinate.
     * @return first founded annotation.
     */
    public static Annotation findByPoint(Annotation[] annotations, double x, double y) {
        if (annotations == null)
            throw new NullPointerException();
        for (Annotation ann : annotations)
            if (ann.getShape().findPoint(x, y))
                return ann;
        return new Annotation();
    }

    public static void main(String[] args) {
        // Create new array of annotations
        Annotation[] anno = new Annotation[] {
                new Annotation(new Circle(5, 1, 2), "Circle 1"),
                new Annotation(new BoundingBox(0, 0, 5, 5), "Bounding Box 1"),
                new Annotation(new Circle(new Coordinate(0, 0), 2), "Circle 2"),
                new Annotation(new Circle(new Coordinate(5, 6), -4), "Circle 3"),
                new Annotation(new BoundingBox(5, 7, 1, 1), "Bounding Box 2")
        };

        // output for each annotation
        for (Annotation annotation : anno) {
            System.out.println(annotation.getShape().shapeName());
            System.out.println(annotation.getNameOfField());
            System.out.println("----------------------------------");
        }

        // new value for "BoundingBox 1" - "New Circle 4"
        anno[1].setParameters(new Circle(), "New Circle 4");
        // get last figure properties
        Figure shp = anno[4].getShape();
        String nameOfField = anno[4].getNameOfField();
        System.out.println("Perimeter of last shape is: " + shp.perimeter() + "\nAnd its name: " + nameOfField);

        System.out.print("\n===============================================\n");
        // output for each annotation
        for (Annotation annotation : anno) {
            System.out.println(annotation.getShape().shapeName());
            System.out.println(annotation.getNameOfField());
            System.out.println("----------------------------------");
        }

        // move"Circle 2"
        ( (Circle) anno[2].getShape() ).move(10, 15);

        System.out.println("===============================================\n");

        // find first annotation contains point
        System.out.println(Annotation.findByPoint(anno, 0, 0).getShape().area() + "\n" +
                Annotation.findByPoint(anno, 0, 0).getNameOfField());

        System.out.println(Annotation.findByPoint(anno, 10, 15).getShape().area() + "\n" +
                Annotation.findByPoint(anno, 10, 15).getNameOfField());
    }
}

/*
output:

Circle
Circle 1
----------------------------------
BoundingBox
Bounding Box 1
----------------------------------
Circle
Circle 2
----------------------------------
Circle
Circle 3
----------------------------------
BoundingBox
Bounding Box 2
----------------------------------
Perimeter of last shape is: 0.0
And its name: Bounding Box 2

===============================================
Circle
Circle 1
----------------------------------
Circle
New Circle 4
----------------------------------
Circle
Circle 2
----------------------------------
Circle
Circle 3
----------------------------------
BoundingBox
Bounding Box 2
----------------------------------
===============================================

0.0
Bounding Box 2
12.566370614359172
Circle 2


 */


