/*
 * Design an algorithm to find the kth number such that the only prime factors
 * are 3, 5 and 7.
 *
 * Solution:
 * Suppose we have a set A containing the first k - 1 numbers such that the only
 * prime factors are 3, 5 and 7. To find the kth number, we must multiply one of
 * the numbers in our set by 3, 5 or 7. In order for the resultant number to be
 * the kth number, it must satisfy:
 *
 * There must not exist a number with prime factors 3, 5 and 7 that is between this number of the (k - 1)th number.
 *
 * To ensure this property, for i = [3, 5, 7], find the first number greater than
 * A[k - 1]/i in A. Then multiply that number by i. There cannot be a number 
 * smaller than this which we could multiply by i to get something greater than 
 * A[k - 1] because the first number smaller than this would be A[k - 1]/i, which 
 * multiplied by i would give us A[k - 1]. This ensures the condition above. We 
 * take the minimum of all three to get A[k].
 */

import java.util.*;

public class Q7 {

  /*
   * Find the next integer in A greater than n.
   */
  public static int findNext(int[] A, int n) {
    int i = 0;
    while(A[i] <= n)
      i++;
    return A[i];
  }

  /*
   * Finds the Kth number whose prime factors are only 3, 5 and 7.
   */
  public static int findNumber(int K) {
    int[] A = new int[K + 1];
    A[0] = 1;

    for(int k = 1; k <= K; k++) {
      A[k] = Integer.MAX_VALUE;
      for(int i = 3; i <= 7; i+=2)
        A[k] = Math.min(A[k], findNext(A, A[k - 1]/i)*i); 
    }

    return A[K];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int K = sc.nextInt();
    System.out.println(findNumber(K));
    sc.close();
  }
}
        
