/*
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels 
 * (5 cents) and pennies (1 cent), write code to calculate the number of ways of 
 * representing n cents.
 *
 * Let S = {S1, S2 ... Sm} be the set of denominations. In this case, it is 
 * S = {1, 5, 10, 25}
 * Let C(N, m) represent the number of ways to make N dollars with up to the mth
 * denomination.
 *
 * We can partition C(N, m) into two sets:
 *
 * 1. The set not containing the mth coin, which the same as C(N, m - 1), the 
 * number of ways to make N dollars with up to the (m - 1)th coin.
 * 2. The set containing at least one of the mth coin, which is the same as 
 * C(N - S[m], m), the number of ways to make N - S[m] dollars with up to the mth
 * coin and then adding S[m] in.
 *
 * Therefore: C(N, m) = C(N, m - 1) + C(N - S[m], m)
 *
 * The base cases:
 * C(N, m) = 1, N = 0
 * C(N, m) = 0, N < 0
 * C(N, m) = 0, N >= 1, m <= 0
 *
 * The recursive solution is implemented below.
 *
 * Referenced: http://www.algorithmist.com/index.php/Coin_Change
 */

import java.util.*;

public class Q8 {

  public int[] S;

  public Q8(int[] S) {
    this.S = S;
  }

  public int count(int n) {
    return count(n, S.length - 1);
  }

  public int count(int n, int m) {
    if(n == 0)
      return 1;
    if(n < 0)
      return 0;
    if(m < 0 && n >= 1)
      return 0;

    return count(n, m - 1) + count(n - S[m], m);
  }

  public static void main(String[] args) {
    int[] S = {1, 5, 10, 25};
    Q8 q = new Q8(S);
    System.out.println(q.count(10));
  }

}
