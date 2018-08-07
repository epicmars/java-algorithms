import java.util.Arrays;
import java.util.Random;

/**
 * The in-place quick sorting algorithm.
 */
public class QuickSort {

    /**
     * Sorting a integer array to ascending order with in-place quick sorting.
     *
     * @param array the array we are sorting
     * @param left  the start index of the sorting range
     * @param right the right index of the sorting range
     */
    public static void sort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            sort(array, left, index - 1);
        }
        if (index < right) {
            sort(array, index, right);
        }
    }

    /**
     * Partition a range of the array with a random selected pivot value in that range,
     * so that elements of the left part are less or equal to the pivot value and the
     * right part are greater than or equal to the pivot value.
     *
     * @param array the array we are sorting
     * @param left  the left index of the partition range
     * @param right the right index of the partition range
     */
    public static int partition(int[] array, int left, int right) {
        // Pick a pivot element randomly to achieve best average performance.
        // For convenience we can also pick the middle element of the range, which is:
        //      int pivotIndex = (start + end) / 2;
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        int pivot = array[pivotIndex];
        // Left and right index of iteration range.
        while (left <= right) {
            // Element with index "left" is greater than or equal to pivot.
            while (array[left] < pivot) left++;
            // Element with index "right" is less or equal to the pivot.
            while (array[right] > pivot) right--;

            // Swap value and adjust the indexes.
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        // Return right index is ok, because both of them can equal to the pivot value.
        return left;
    }

    /**
     * Swap two element of a array.
     *
     * @param array the target array
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;
        array[i] += array[j];
        array[j] = array[i] - array[j];
        array[i] -= array[j];
    }

    public static void main(String[] args) {
        int[] array = new int[]{342, 1111, -2, 1, 3, 4, 234};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
