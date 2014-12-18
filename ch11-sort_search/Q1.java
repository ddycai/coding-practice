/*
 * You are given two sorted arrays, A and B, where A has a large enough buffer 
 * at the end to hold B. Write a method to merge B into A in sorted order
 */

import java.util.*;

public class Q1 {

  /*
   * Merges two sorted arrays A and B into A.
   * A - the first array
   * B - the second array
   * m - the size of A
   * n - the size of B
   */
  public static void merge(int[] A, int[] B, int m, int n) {
    int p = m - 1; // pointer for A
    int q = n - 1; // pointer for B
    int k = m + n - 1; // pointer to where we insert elements

    while(p >= 0 && q >= 0) {
      if(A[p] > B[q]) {
        A[k--] = A[p--];
      } else {
        A[k--] = B[q--];
      }
    }

    while(p >= 0) {
      A[k--] = A[p--];
    }

    while(q >= 0) {
      A[k--] = B[q--];
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[] A = new int[m + n];
    int[] B = new int[n];

    A[0] = 10;
    B[0] = 10;

    for(int i = 1; i < m; i++)
      A[i] = (int)(A[i - 1] * (1 + Math.random()));

    for(int i = 1; i < n; i++)
      B[i] = (int)(B[i - 1] * (1 + Math.random()));

    merge(A, B, m, n);

    System.out.println(Arrays.toString(A));
  }

}
  

