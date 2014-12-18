/*
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible.
 *
 * Solution:
 * Use the bit mask 1010...1010 to extract the even bits and shift right.
 * Use the bit mask 0101...0101 to extract the odd bits and shift left.
 * Combine the bit masks.
 */

import java.util.Scanner;

public class Q6 {
 
  /*
   * 0xaaaaaaaa = 1010...1010
   * 0x55555555 = 0101...0101
   */ 
  public static int swapBits(int n) {
    return ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(Integer.toBinaryString(N));
    System.out.println(Integer.toBinaryString(swapBits(N)));
    sc.close();
  }

}
