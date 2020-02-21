import java.util.Arrays;

public class TaskOne {

    /**
     * This method replaces the first element of array with its minimum element and
     * the last element - with the maximum element.
     * @param array - an input array
     * @return an modified array
     */
    public static int[] minMax(int[] array) {
        int max = array[array.length - 1];
        int indexMax = array.length - 1;
        int min = array[0];
        int indexMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        if (array[0] != min) {
            array[indexMin] = array[0];
            array[0] = min;
        }
        if (array[array.length - 1] != max) {
            array[indexMax] = array[array.length - 1];
            array[array.length - 1] = max;
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
