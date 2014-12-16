/*
 * An array A contains all the integers from 0 to n, except for one number which
 * is missing. In this problem, we cannot access an entire integer in A with a
 * single oepration. The elements of A are represented in binary, and the only
 * operation we can use to access them is "fetch the jth bit of A[i]", which takes
 * constant time. Write code to find the missing integer. Can you do it in O(n)
 * time?
 *
 * Solution: When we count in binary the least significant bit alternates between
 * 0 and 1. Therefore, when n is odd, the #(1s) == #(0s) in the least significant
 * bit when we count from 0 to n. When n is even, there is one more 0.
 * If we remove a number of 0 .. n, then it will change the #(0s) and #(1s) in
 * the least significant bit!
 * We can use this fact to determine the least significant bit of the removed
 * number. If the removed number is even, then #(1s) == #(0s), else #(1s) < #(0s).
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Question7 {

  /*
   * Generates a list of integers from 0 to n, then randomly removes one of them.
   */
  public static ArrayList<Integer> randomList(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0; i <= n; i++)
      list.add(i);
    Collections.shuffle(list);
    list.remove(list.size() - 1);
    return list;
  }
 
  /*
   * Extracts the jth bit of integer n.
   */ 
  public static boolean extractBit(int n, int j) {
    return (n & (1 << j)) != 0;
  }
 
  /*
   * Calculates number of digits in the binary representation. 
   */
  public static int ndigits(int n) {
    int c = 0;
    while(n != 0) {
      n = n >> 1;
      c++;
    }
    return c;
  }

  public static int missingNo(ArrayList<Integer> list, int j, int nd) {

    // Base case: when j is greater than the number of digits in n
    if(j > nd) {
      return 0;
    }

    ArrayList<Integer> ones = new ArrayList<Integer>();
    ArrayList<Integer> zeros = new ArrayList<Integer>();

    for(int n : list) {
      if(extractBit(n, j))
        ones.add(n);
      else
        zeros.add(n);
    }

    if(ones.size() < zeros.size()) {
      int ans = missingNo(ones, j + 1, nd);
      System.out.format("The %dth bit of ? is %d\n", j, 1);
      return (ans << 1) | 1;
    } else {
      int ans = missingNo(zeros, j + 1, nd);
      System.out.format("The %dth bit of ? is %d\n", j, 0);
      return (ans << 1) | 0;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    ArrayList<Integer> list = randomList(N);
    // System.out.println(list);
    int ans = missingNo(list, 0, Integer.toBinaryString(N).length());
    System.out.println(ans);
    if(list.contains(ans))
      System.out.println("Answer is incorrect.");
    else
      System.out.println("Answer is correct.");
    sc.close();
  }

}
