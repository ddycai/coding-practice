/*
 * You have a stack of n boxes, with widths w, heights h and depths d. The boxes
 * cannot be rotated and can only be stacked on top of one another if each box in 
 * the stack is strictly larger than the box above it in width, height, and depth.
 * Implement a method to build the tallest stack possible, where the height of a
 * stack is the sum of the heights of each box. 
 *
 * Solution
 * Let each box be the bottom and construct the best stack with that box on the
 * bottom, then take the max of all the bottoms. How do we construct the best
 * stack with bottom b[i]? The same way, we take each box as the bottom that
 * can fit on top of b[i] and build the best stack, then we take the maximum of
 * those and so on.
 *
 * Dynamic Programming
 * Since we recalculate the optimal stack with bottom b[i] frequently, we can
 * save the answers in a DP table (in this case a DP map from bottoms to
 * optimal stacks) and look them up when necessary.
 */

import java.util.*;

public class Q10 {

  /**
   * Calculates the height of the stack
   */
  public static int height(Stack<Box> stk) {
    int h = 0;
    for(Box b : stk)
      h += b.height;
    return h;
  }

  /**
   * Calculates the optimal stack with the specified Box at the bottom
   */
  public static Stack<Box> solve(Box[] boxes, Box bottom, Map<Box, Stack<Box>> dp) {

    if(dp.containsKey(bottom)) {
      return dp.get(bottom);
    }
     
    int bestHeight = 0;
    Stack<Box> best = null;

    for(Box box : boxes) {
      if(box.lessThan(bottom)) {
        Stack<Box> stk = solve(boxes, box, dp);
        int h = height(stk);
        if(h > bestHeight) {
          bestHeight = h;
          best = stk;
        }
      }
    }

    if(best == null) {
      best = new Stack<>();
    }

    best.push(bottom);

    dp.put(bottom, (Stack<Box>)best.clone());
    System.out.format("%s : %s\n", bottom, best);

    return best;
  }    

  /**
   * Input: starts with N, the number of boxes followed by N lines, each
   * containing w, d and h separated by spaces.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Box[] boxes = new Box[n];
    for(int i = 0; i < n; i++) {
      int w = sc.nextInt();
      int h = sc.nextInt();
      int d = sc.nextInt();
      boxes[i] = new Box(w, h, d);
    }

    int bestHeight = 0;
    Stack<Box> best = null;

    Map<Box, Stack<Box>> map = new HashMap<>();

    for(Box box : boxes) {
      Stack<Box> stk = solve(boxes, box, map);
      int h = height(stk);
      if(h > bestHeight) {
        bestHeight = h;
        best = stk;
      }
    }

    System.out.println(best);

  }

}

class Box {
  int width, height, depth;
  public Box(int w, int h, int d) {
    width = w;
    height = h;
    depth = d;
  } 

  public boolean lessThan(Box o) {
    return width < o.width && height < o.height && depth < o.depth;
  }

  public String toString() {
    return String.format("(%d %d %d)", width, height, depth);
  }
}
