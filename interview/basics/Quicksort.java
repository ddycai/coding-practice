import java.util.Arrays;

/**
 * Quicksort.
 * 
 * Quicksort is a divide and conquer algorithm:
 *
 * (1) Divide: choose a pivot value and partition the array into two subproblems. One with all the
 * values less than the pivot and one with all the values greater than (or eq) to the pivot
 * (2) Conquer: solve each subproblem by running quicksort recursively
 * (3) Combine: none
 *
 * The conquer step is recursive so it must have a base case. This is when the size of the
 * subproblem is 1. The problem is solved trivially.
 */
class Quicksort {

  /**
   * Performs quicksort on [left, right].
   */
  public static void quicksort(int[] arr, int left, int right) {
    if(left < right) {
      int mid = partition(arr, left, right);
      quicksort(arr, left, mid - 1);
      quicksort(arr, mid + 1, right);
    }
  }

  /**
   * Partitions the array in two (as described above) and returns the index of the pivot value.
   */
  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[right], tmp;

    int storeIndex = 0;
    for(int i = 0; i <= right - 1; i++) {
      if(arr[i] < pivot) {
        // Swap arr[i] and arr[storeIndex]:
        tmp = arr[i];
        arr[i] = arr[storeIndex];
        arr[storeIndex] = tmp;
        storeIndex++;
      }
    }

    // storeIndex is guaranteed to be the leftmost value >= pivot. Put pivot there.
    tmp = arr[right];
    arr[right] = arr[storeIndex];
    arr[storeIndex] = tmp;

    return storeIndex;
  }

  /**
   * Test the program.
   */
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 4, 7, 2, 1, 9, 0, -4, 2, 5, -7};
    System.out.format("Unsorted: %s\n", Arrays.toString(arr));
    quicksort(arr, 0, arr.length - 1);
    System.out.format("Sorted: %s\n", Arrays.toString(arr));
  }
}
