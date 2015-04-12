/*
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */

import java.util.*;

public class Q2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] words = new String[n];
    for(int i = 0; i < n; i++) {
      words[i] = sc.nextLine();
    }
    Arrays.sort(words, new AnagramComparator());
    System.out.println(Arrays.toString(words));
    sc.close();
  }

}

/*
 * A comparator that compares two strings based on how similar their sorted
 * character sequences are. This will place anagrams next to each other in the
 * sorted sequences.
 */
class AnagramComparator implements Comparator<String> {

  public String sortChars(String s) {
    char[] chArray = s.toCharArray();
    Arrays.sort(chArray);
    return new String(chArray);
  }

  public int compare(String a, String b) {
    return sortChars(a).compareTo(sortChars(b));
  }
}
  

