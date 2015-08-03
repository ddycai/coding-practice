import java.util.Arrays;

/**
 * Mergesort.
 * 
 * Merge sort is a divide and conquer algorithm:
 *
 * (1) Divide: divide the array in half into two subproblems
 * (2) Conquer: solve each subproblem by running mergesort recursively
 * (3) Combine: merge the two sorted subarrays into one
 *
 * The conquer step is recursive so it must have a base case. This is when the size of the
 * subproblem is 1. The problem is solved trivially.
 */
class Mergesort {

  /**
   * Performs mergesort on [left, right].
   */
  public static void mergesort(int[] arr, int left, int right) {
    if(left < right) {
      int mid = (left + right)/2;
      mergesort(arr, left, mid);
      mergesort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  /**
   * Merges [left, mid] and [mid + 1, right] into one sorted array at [left, right].
   */
  public static void merge(int[] arr, int left, int mid, int right) {
    int p = left, q = mid + 1;
    int[] tmp = new int[right - left + 1];

    int i = 0;
    while(p <= mid && q <= right) {
      if(arr[p] < arr[q]) {
        tmp[i++] = arr[p++];
      } else {
        tmp[i++] = arr[q++];
      }
    }

    while(p <= mid) {
      tmp[i++] = arr[p++];
    }

    while(q <= right) {
      tmp[i++] = arr[q++];
    }

    // Copy into arr:
    for(i = 0; i < tmp.length; i++) {
      arr[left + i] = tmp[i];
    }
  }

  /**
   * Test the program.
   */
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 4, 7, 2, 1, 9, 0, -4, 2, 5, -7};
    System.out.format("Unsorted: %s\n", Arrays.toString(arr));
    mergesort(arr, 0, arr.length - 1);
    System.out.format("Sorted: %s\n", Arrays.toString(arr));
  }
}
