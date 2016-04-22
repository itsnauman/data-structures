/**
 * This class implements the Quick Sort algorithms
 * @author Nauman Ahmad
 */
class QuickSort {
    private QuickSort() {}

    public static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int arr[], int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }

    }

    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        int tmp;

        // Pivot is always the last element in the array
        int pivot = rightIndex;
        int left = leftIndex;
        int right = rightIndex - 1;

        // Choose the pivot and shift it to the right
        int mid = (leftIndex + rightIndex) / 2;
        tmp = arr[rightIndex];
        arr[rightIndex] = arr[mid];
        arr[mid] = tmp;

        while (left <= right) {
            // Move left pointer until a value > pivot is found
            while ((left <= right) && arr[left] <= arr[pivot]) left++;

            // Move right pointer until a value < pivot is found
            while ((left <= right) && arr[right] >= arr[pivot]) right--;

            // Swap values at left & right pointers
            if (left <= right) {
                tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        // Swap pivot at it's original place
        tmp = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = tmp;

        // Return index of pivot / partition
        return left;
    }
}
