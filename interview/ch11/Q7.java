/*
 * A circus is designing a tower routine consisting of people standing atop one
 * another's shoulders. For practical and aesthetic reasons, each person must
 * be both shorter and lighter than the person below him or her. Given the
 * heights and weights of each person in the circus, write a method to compute
 * the largest possible number of people in such a tower.
 *
 * Explanation
 * This is a variation of the longest increasing sequence problem. We can solve
 * this problem by using this inductive property given array A:
 * Suppose we know the the LIS[0] to LIS[n] where LIS[i] is the longest
 * increasing sequence ending at index i of A. Then we can find LIS[n + 1] by
 * taking the maximum of all LIS[i], 0 <= i <= n, such that A[i] < A[n + 1].
 *
 * Once we know how to solve the LIS problem, we can solve this problem by
 * taking the pairs, sort them by height, then run LIS on the weights.
 */

import java.util.*;

public class Q7 {

  /*
   * Returns the LIS of the given array.
   * This is a function that uses generics which takes an array of T, a
   * comparator for T, and returns a List<T> of the LIS.
   */
  public static <T> List<T> lis(T[] a, Comparator<? super T> c) {

    int[] len = new int[a.length];
    int[] p = new int[a.length];
    int maxind = 0;
    
    len[0] = 1;
    p[0] = -1;
    for(int i = 1; i < a.length; i++) {
      len[i] = 1;
      p[i] = -1;
      for(int j = 0; j < i; j++) {
        if(c.compare(a[i], a[j]) > 0 && len[j] + 1 > len[i]) {
          len[i] = len[j] + 1;
          p[i] = j;
        }
      }
      // find the maximum increasing sequence
      if(len[i] > len[maxind])
        maxind = i;
    }

    // use the predecessor array to find the LIS
    LinkedList<T> res = new LinkedList<>();
    while(maxind != -1) {
      res.addFirst(a[maxind]);
      maxind = p[maxind];
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Person[] persons = new Person[n];
    for(int i = 0; i < n; i++) {
      int h = sc.nextInt();
      int w = sc.nextInt();
      persons[i] = new Person(h, w);
    }

    // Sort the people by height, then weight
    Arrays.sort(persons);

    // Find the LIS, using weights as the comparator
    List<Person> lis = lis(persons, new Comparator<Person>(){
      public int compare(Person a, Person b) {
        return a.weight - b.weight;
      }
    });

    for(Person p : lis) {
      System.out.println(p);
    }
      
    sc.close();

  }

}

class Person implements Comparable<Person> {
  int height, weight;
  public Person(int h, int w) {
    height = h;
    weight = w;
  }
  public int compareTo(Person p) {
    if(height != p.height)
      return height - p.height;
    else
      return weight - p.weight;
  }
  public String toString() {
    return String.format("(%d, %d)", height, weight);
  }
}
