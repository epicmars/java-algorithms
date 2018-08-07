
public class BinarySearch {

    /**
     * Binary searching that search a integer value in an increasing ordered integer array,
     * which will find the index of the searched integer in the array.
     *
     * @param array array in which to search
     * @param x     integer value to be searched
     * @return index of searched integer in the array, if not found return -1.
     */
    public static int search(int[] array, int x) {
        // Start index of search range.
        int start = 0;
        // End index of search range.
        int end = array.length - 1;

        // Continue search until search range is empty.
        while(start <= end) {
            // Get middle index of search range.
            int mid = (start + end) / 2;
            if (x < array[mid]) {
                // Will search in the left part in next round.
                end = mid - 1;
            } else if (x > array[mid]) {
                // Will search in the right part in next round.
                start = mid + 1;
            } else {
                return mid;
            }
        }
        // If not found.
        return -1;
    }
}