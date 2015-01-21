/*
 * Given a string, S, and alphabet, A, find the shortest substring of S that
 * contains all the letters of A. If there is more than one solution, output
 * the first one that appears.
 * Example: For S = aacxacaxbxc, A = abc, the output is caxb
 *
 * Explanation
 * You can do this in brute force in O(n^2) time by searching every possible
 * substring (a substring can be defined by two indexes, so look at every
 * pair), but how can we do better?
 *
 * The idea is to have a left and right pointer p and q, respectively, and to
 * have a clever method of incrementing p and q to find all potential
 * solutions. Then, take the minimum.
 *
 * How do we do this? Start with p = q = 0. For each substring which ends at q,
 * find the shortest such substring by incrementing p. We increment p when:
 *
 * 1. If the element at S[p] is not in the alphabet. If so, then we can have a
 * shorter solution by excluding it since it does not change whether or not the
 * substring contains all elements of p.
 * 2. If the element at S[p] is in the alphabet and there is more than 1
 * already in S[p, q], we can remove it without changing the condition.
 *
 * Once we cannot increment p anymore, it means the solution cannot get any
 * shorter, we check if each of the alphabet appears at least once in S[p, q].
 * If so, we take min(current best, this solution).
 *
 * Why do we not have to set p = 0 at each iteration? Because the conditions
 * that increment p until the point that it stops for q - 1 still hold no
 * matter what the new S[q] is. S[q] can only increase the frequency of one of
 * the letters of the alphabet or do nothing to change the frequency. Thus, we
 * would be doing extra work if we set p = 0 each time.
 *
 * What is the time complexity? p can increase at most |S| times and q can
 * increase at most |S| times so there are at most 2|S| iterations
 * incrementations of p or q. At each incrementation, we must check the
 * frequency of each symbol of A in S[p, q]. If we iterate through S[p, q],
 * this will take linear time, which makes the entire algorithm O(n^2), same as
 * brute force.  We can do this more efficiently by storing the frequencies in
 * a map and updating it, which will make this operation |A| in the worst case.
 * So the time complexity is O(|S||A|). If |A| is small compared to |S|, this
 * is pretty much linear.
 */

import java.util.*;

public class AlphabetSubstring {

  /*
   * Checks if all frequencies in the given Map is >= 1.
   */
  public static boolean checkFrequency(Map<Character, Integer> freq) {
    for(Integer i : freq.values()) {
      if(i == 0)
        return false;
    }
    return true;
  }

  public static String findSubstring(String s, String alphabet) {
    // A frequency map
    Map<Character, Integer> freq = new HashMap<>();
    for(int i = 0; i < alphabet.length(); i++) {
      freq.put(alphabet.charAt(i), 0);
    }

    int p = 0, q = 0;   // current pointers
    int bp = 0, bq = s.length() - 1; // stores the best solution
    for(q = 0; q < s.length(); q++) {
      char c = s.charAt(q);
      if(freq.containsKey(c)) {
        freq.put(c, freq.get(c) + 1);

        // start cutting from the left side
        char c2 = s.charAt(p);
        while(p < q) {
          if(freq.get(c2) == null)
            p++;
          else if(freq.get(c2) > 1) {
            freq.put(c2, freq.get(c2) - 1);
            p++;
          } else
            break;
          c2 = s.charAt(p);
        }
      }

      if(checkFrequency(freq) && q - p < bq - bp) {
        bp = p;
        bq = q;
      }
    }

    return s.substring(bp, bq + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String a = sc.nextLine();
    System.out.println(findSubstring(s, a));
    sc.close();
  }

}
