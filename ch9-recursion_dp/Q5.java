/*
 * Write a method to compute all permutations of a string.
 *
 * Solution: Simplest way would be to recurse on each character of the string with
 * that character removed. The disadvantage would be a lot of overhead in function
 * calls and creating new string objects. See printPerms() below.
 *
 * If we needed the function to return a list of permutations, we would need to
 * solve the problem a different way. If we know all the permutations of a string
 * of length n, then we can generate the permutations of a string of length n + 1
 * by inserting the (n + 1)th character into every possible position in the
 * permutations of length n. We can use this property to write a recursive
 * function for generating permutations. See getPerms() below.
 *
 * We can also compute permutations by swapping to lower the space complexity. 
 * However, strings are immutable in Java therefore it would only be possible to 
 * do this with a char array.
 */

import java.util.*;

public class Q5 {

  public static void printPerms(String s, String perm) {
    if(s.length() == 1) {
      System.out.println(perm + s);
      return;
    }

    for(int i = 0; i < s.length(); i++)
      printPerms(s.substring(0, i) + s.substring(i + 1), perm + s.charAt(i));
  }

  public static ArrayList<String> getPerms(String s) {
    ArrayList<String> perms = new ArrayList<>();

    // Base case
    if(s.length() == 1) {
      perms.add(s);
      return perms;
    }

    char c = s.charAt(0);
    ArrayList<String> words = getPerms(s.substring(1));
    
    for(String w : words) {
      for(int i = 0; i <= w.length(); i++) {
        perms.add(w.substring(0, i) + c + w.substring(i));
      }
    }

    return perms;
  }

  public static void main(String[] args) {
    ArrayList<String> perms = getPerms("abc");
    System.out.println(perms);
  }

}
