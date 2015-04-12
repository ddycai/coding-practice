/*
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit
 * i. You can assume that the bits j through i have enough space to fit all
 * of M. That is, if M= 10011, you can assume that there are at least 5 bits
 * between j and i. You would not, for example, have j-3 and i=2, because M
 * could not fully fit between bit 3 and bit 2.
 *
 * Explanation
 * Create a bitmask of j - i 1s to extract those bits from M. Shift M to the
 * left i bits. Then take your bitmask, shift it i bits to the left then
 * complement it to extract the other bits from N. Then combine M and N
 * together.
 */

import java.util.Scanner;

public class Q1 {
  
  public static int insert(int N, int M, int i, int j) {
   
    // Sequence of all 1s 
    int mask = ~0;
    
    // Create a sequence of j - i 1s
    mask = ~(mask << (j - i + 1));

    // Apply the mask to M
    M = M & mask;

    // Shift M left i bits
    M = M << i;

    // Move the mask left and complement it
    mask = ~(mask << i);
 
    N = N & mask;
    return M | N; 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int i = sc.nextInt();
    int j = sc.nextInt();
    int ans = insert(N, M, i, j);
    System.out.println(Integer.toBinaryString(N));
    System.out.println(Integer.toBinaryString(M));
    System.out.println(Integer.toBinaryString(ans));
    sc.close();
  }

}
