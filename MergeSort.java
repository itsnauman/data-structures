/**
 * This class implements the Merge Sort algorithm.
 * @author Nauman Ahmad
 */
public class MergeSort {
    private MergeSort() {}

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int first, int last) {
        // Return if there is only one element in the array
        if (first == last)
            return;

        int mid = (first + last) / 2;

        sort(arr, first, mid);
        sort(arr, mid + 1, last);
        merge(arr, first, mid, mid + 1, last);
    }
  
    /**
    * Merge two sorted arrays
    */
    private static void merge(int[] arr, int leftFirst, int leftLast, int rightFirst, int rightLast) {
        int[] tmp = new int[rightLast - leftFirst + 1];

        int leftPtr = leftFirst;
        int rightPtr = rightFirst;
        int ptr = 0;

        while (leftPtr <= leftLast && rightPtr <= rightLast) {
            if (arr[leftPtr] < arr[rightPtr])
                tmp[ptr++] = arr[leftPtr++];
            else
                tmp[ptr++] = arr[rightPtr++];
        }

        while (leftPtr <= leftLast)
            tmp[ptr++] = arr[leftPtr++];

        while (rightPtr <= rightLast)
            tmp[ptr++] = arr[rightPtr++];

        System.arraycopy(tmp, 0, arr, leftFirst, tmp.length);
    }
}
