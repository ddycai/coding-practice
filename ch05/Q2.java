/*
 * Given a real number between 0 and 1 that is passed in as a double, print
 * the binary representation. If the number cannot be represented accurately in
 * binary with at most 32 characters, print "ERROR".
 *
 * Solution: A non-integer binary number looks like:
 * b1 * 2^-1 + b2 * 2^-2 + ... + bn * 2^-n
 * where bn is the nth binary digit. If we multiply the equation by 2, we can
 * extract the ones digit as either 0 or 1 and add it to the binary string.
 */

import java.util.Scanner;

public class Q2 {
  
  public static String doubleToBinary(double d) {
    int ans = 0, digit;
    int count = 0;
    while(d != 0) {
      if(count == 32) {
        throw new RuntimeException("ERROR");
      }
      count++;
      ans = ans << 1;
      digit = (int)(d * 2);
      d *= 2;
      if(digit == 1) {
        ans = (ans + 1);
        d -= 1;
      }
     }
     return Integer.toBinaryString(ans); 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double D = sc.nextDouble();
    try {
      System.out.println("0." + doubleToBinary(D));
    } catch(RuntimeException e) {
      System.out.println("ERROR");
    }
    sc.close();
  }

}
