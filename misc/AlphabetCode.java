/*
 * Given a string of numbers, find all possible ways of interpreting the string
 * into a string of characters where a = 1, b = 2, ... z = 26.
 *
 * Example: 
 * Input: "1123"
 *
 * Output List 
 * aabc //a = 1, a = 1, b = 2, c = 3 
 * kbc // since k is 11, b = 2, c= 3 
 * alc // a = 1, l = 12, c = 3 
 * aaw // a= 1, a =1, w= 23 
 * kw // k = 11, w = 23
 *
 * Explanation
 * We can shorten the problem by looking at the first two digits. We can take
 * the first digit to be letter or choose the first two digits to be a letter
 * (if it is within [1, 26]). For example:
 *
 * 1123 --> a123
 * 1123 --> k23
 *
 * Now we have a shorter code that we can apply the same procedure to. The base
 * case is when the code is empty, in which case we can print out all the
 * characters we have so far. We can implement this easily as a recursive
 * function with two recursive calls (we have two possible options, shown
 * above, at each recursion).
 */

import java.util.*;

public class AlphabetCode {

  /*
   * Returns the number of ways to decode code and prints them to standard
   * output.
   */
  public static int decode(String code, String s) {
    if(code.isEmpty()) {
      System.out.println(s);
      return 1;
    }
    int sum = 0;
    if(code.length()>=2) {
      int digits = Integer.parseInt(code.substring(0, 2));
      if(digits <= 26)
        sum += decode(code.substring(2), s + (char)(digits + 'a' - 1));
    }
    sum += decode(code.substring(1), s + (char)(code.charAt(0) - '1' + 'a'));
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(decode(s, ""));
    sc.close();
  }
}
