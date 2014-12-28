/*
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume the array was
 * originally sorted in increasing order.
 *
 * We could do a linear search but we can find the element more efficiently using
 * a modified binary search.
 *
 * The key insight is that when we partition a rotated sorted array in two
 * one half will always be sorted. What we can do is check which side of the
 * array is sorted by comparing A[mid] to A[low]. If A[mid] > A[low] then the left
 * side is sorted. If A[mid] < A[low] then the right side is sorted. 
 *
 * If A[mid] == A[low] then if the left side is sorted then it consists of the
 * same number (that's the only way it could be sorted). Then we can ignore it 
 * since our number can't be there if it's not equal to A[mid]. So we check A[mid]
 * and A[hi]:
 *
 * If A[mid] > A[hi] then the right side is not sorted, which means left is sorted
 * and we can ignore it. Search right.
 * If A[mid] == A[hi], we can't tell anything. So search both sides.
 * If A[mid] < A[hi]: this could not happen unless the array was not rotated.
 * Why? If the array was rotated then A[lo] >= A[hi]. We know A[lo] == A[mid] and
 * A[mid] < A[hi]. Then A[lo] == A[hi], which is the case above.
 * If the array was not rotated, then A[lo] can be less than A[hi], which means
 * both sides are sorted. Then the left side is all repeats and we can ignore it.
 *
 * As you can see, if A[mid] != A[hi], then we ignore the left because we know
 * that it's sorted, which is how we arrive at the algorithm below.
 *
 */

import java.util.*;

public class Q3 {

  public static int binarySearch(int[] a, int search, int lo, int hi) {
    int mid = (hi + lo)/2;
    if(a[mid] == search)
      return mid;

    if(lo > hi)
      return -1;
   
    // left half is sorted 
    if(a[lo] < a[mid]) {
      if(search < a[mid] && search >= a[lo])
        return binarySearch(a, search, lo, mid - 1);
      else
        return binarySearch(a, search, mid + 1, hi);
    // right side is sorted
    } else if(a[lo] > a[mid]) {
      if(search > a[mid] && search <= a[hi])
        return binarySearch(a, search, mid + 1, hi);
      else
        return binarySearch(a, search, lo, mid - 1);
    // lo and middle is the same!
    } else {
      // left side is sorted, search right
      if(a[mid] != a[hi]) {
          return binarySearch(a, search, mid + 1, hi);
      // can't tell anything, search both
      } else {
        int ans = binarySearch(a, search, lo, mid - 1);
        if(ans == -1)
          return binarySearch(a, search, mid + 1, hi);
        else
          return ans;
      }
    }

  }

  public static int[] rotatedSortedArray(int n) {
    int[] sorted = new int[n];
    for(int i = 0; i < n; i++)
      sorted[i] = (int)(Math.random() * 10);
    Arrays.sort(sorted);
    int[] arr = new int[n];
    int k = (int)(Math.random() * n);

    for(int i = 0; i < n; i++) {
      arr[(i + k) % n] = sorted[i];
    }
    return arr;
  }


  public static void main(String[] args) {
    // int[] arr = rotatedSortedArray(10);
    int[] arr = {2, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(arr));
    int res = binarySearch(arr, 3, 0, arr.length - 1);
    System.out.println(res);

  }

}
