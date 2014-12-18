/*
 * Write a method to return all subsets of a set.
 *
 * Solution: For each item, we either take the next item in the subset or we don't
 * which results in every subset being created. The base case is when we reach the
 * last element of our list. You can think of a subset as a binary string over the
 * set where 1 means include and 0 means exclude. So generating every subset is
 * generating every binary string.
 */

import java.util.*;

public class Question4 {

  /*
   * Returns a set of all the subsets of the given set.
   * Only works if the set size is <= size of integer because we use an integer to
   * generate every possible binary string.
   */
  public static Set<Set<Integer>> getSubsets(ArrayList<Integer> set) {
    Set<Set<Integer>> subsets = new HashSet<>();
    int max = 1 << set.size();
    for(int mask = 0; mask < max; mask++) {
      HashSet<Integer> subset = new HashSet<>();
      for(int j = 0; j < set.size(); j++) {
        if(((1 << j) & mask) != 0)
          subset.add(set.get(j));
      }
      subsets.add(subset);
    }
    return subsets;
  }

  public static void main(String[] args) {
    ArrayList<Integer> set = new ArrayList<>();
    for(int i = 0; i < 5; i++)
      set.add(i);
    Set<Set<Integer>> subsets = getSubsets(set);
    for(Set<Integer> s : subsets)
      System.out.println(s);
  }
}
