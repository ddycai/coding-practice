/*
 * Write a method that, given a guess and a solution, returns the number of
 * hits and pseudo-hits in the Game of Master Mind.
 *
 * Solution
 * You can identify a hit easily by checking if guess[i] == solution[i].
 * Checking a pseudo-hit is a bit more tricky. First, you must check if
 * guess[i] matches some solution[j]. If it does, you must check if guess[j] ==
 * solution[j]. If it does, then solution[j] is already a hit so we continue
 * looking. If not, then solution[j] and guess[i] is a pseudo-hit. Every time
 * we identify a hit/pseudo-hit, we remove it (set it to null) in the solution
 * array so that we do not use it again.
 */

import java.util.*;

public class Q5 {

  public static int[] guess(char[] guess, char[] solution) {
  
    int[] hits = new int[2];
    ArrayList<Character> list = new ArrayList<>();
    for(char c : solution)
      list.add(c);

    for(int i = 0; i < guess.length; i++) {
      // same letter, same position
      if(list.get(i) != null && guess[i] == list.get(i)) {
        hits[0]++;
        list.set(i, null);
      // look for guess[i] in solution array
      } else {
        for(int j = 0; j < guess.length; j++) {
          if(list.get(j) != null && guess[i] == list.get(j)) {
          // if in the wrong position, remove it
          // add a pseudo hit
          if(guess[ind] != solution[ind]) {
            hits[1]++;
            list.set(ind, null);
          }
        }
      }
    }

    return hits;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Solution: ");
    String solution = sc.nextLine();
    System.out.print("Guess: ");
    String guess = sc.nextLine();
    int[] h = guess(guess.toCharArray(), solution.toCharArray());
    System.out.format("hits = %d, pseudo-hits = %d\n", h[0], h[1]);
    sc.close();
  }

}

