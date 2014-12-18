/*
 * A child is running up a staircase with n steps, and can hop either 1 step, 2
 * steps or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 *
 * Solution: We can do this using brute force. We start at 0 and at each recursive
 * step we add 1, 2 and 3. The base case is when we reach n (and we stop).
 * This runs in O(3^n), which is extremely slow.
 *
 * We can also solve this using dynamic programming. Suppose you know the number
 * of ways to get to 1, 2 ... n - 1 steps stored in array A. Since we know we
 * can get to n - 1 in A[n - 1] ways, we can simply go up 1 step from any of
 * those and get to the nth step. By the same logic, we know we can get to n - 2
 * in A[n - 2] ways then we can go up 2 steps to get to the nth step. We could
 * also go up 1 step twice, but that would be accounted for in A[n - 1].
 * Therefore, A[n] = A[n - 1] + A[n - 2] + A[n - 3].
 */

import java.util.*;

public class Question1 {

  /*
   * Brute force recursive implemention
   * This solution runs in O(3^n)!
   */
  public static int ways(int n, int cur) {
    if(n == cur)
      return 1;
    if(cur > n)
      return 0;
    return ways(n, cur + 1) + ways(n, cur + 2) + ways(n, cur + 3);
  }

  /*
   * Dynamic programming implementation.
   * This solution runs in O(n).
   */
  public static int ways(int n) {
    if(n == 1 || n == 2)
      return n;
    if(n == 3)
      return 4;
    int[] A = new int[n + 1];
    A[1] = 1;
    A[2] = 2;
    A[3] = 4;

    for(int i = 4; i <= n; i++) {
      A[i] = A[i - 1] + A[i - 2] + A[i - 3];
    }
    
    return A[n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(ways(n));
    System.out.println(ways(n, 0));
    sc.close();
  }
}
