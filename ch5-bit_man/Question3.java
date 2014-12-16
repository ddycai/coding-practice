/*
 * Given a postivie integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
 *
 * Solution: We just need to rearrange the 1s in the binary representation such
 * that the number becomes slightly bigger. To do this, we have to swap the 
 * place of a 1 and a 0. We need to choose 1 such that it appears before the
 * zero.
 */

import java.util.Scanner;

public class Question3 {
  
  public static int nextLargest(int n) {
    int one = 1;
    // Look for the first 1 bit
    while((n & one) == 0) {
      one = one << 1;
    }

    // Look for the first 0 bit to the left
    int zero = one << 1;
    while((n & zero) > 1) {
      zero = zero << 1;
    }

    // Remove the 1 bit
    n = n & ~one;

    // Add the zero bit
    n = n | zero;

    return n;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(nextLargest(N));
    sc.close();
  }

}
