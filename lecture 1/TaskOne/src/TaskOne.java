import java.util.Arrays;

public class TaskOne {

    /**
     * This method replaces the first element of array with its minimum element and
     * the last element - with the maximum element.
     * @param array - an input array
     * @return an modified array
     */
    public static int[] minMax(int[] array) {
        int[] values = new int[] {array[0], array[array.length - 1], 0, array.length - 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < values[0]) {
                values[0] = array[i];
                values[2] = i;
            }
            if (array[i] > values[1]) {
                values[1] = array[i];
                values[3] = i;
            }
        }
        if (array[0] != values[0]) {
            array[values[2]] = array[0];
            array[0] = values[0];
        }
        if (array[array.length - 1] != values[1]) {
            array[values[3]] = array[array.length - 1];
            array[array.length - 1] = values[1];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[] {5, 2, 6, 1, -2, 10, 4, 3, 7})));
    }
}
    /* output:
    [-2, 2, 6, 1, 5, 7, 4, 3, 10]
    */
