/*
 * Implement an algorithm to print all valid (i.e., properly opened and closed)
 * combinations of n-pairs of parentheses.
 *
 * Solution: We can generate valid strings by keeping track of how many left and
 * right parentheses are in the current string.
 * At each step, we can add:
 *
 * 1. A left parentheses always
 * 2. A right parentheses only if there are more left than right parentheses
 *
 * When the left and right parentheses is n, then we have a valid solution.
 */

import java.util.*;

public class Q6 {

  /*
   * Prints all well-formed parentheses with n pairs of brackets.
   */
  public static void printParens(String s, int n, int left, int right) {
    if(left == n && right == n) {
      System.out.println(s);
      return;
    }

    if(n - left > 0) {
      printParens(s + "(", n, left + 1, right);
    }

    if(left > right) {
      printParens(s + ")", n, left, right + 1);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = sc.nextInt();
    printParens("", n, 0, 0);
    sc.close();
  }

}
