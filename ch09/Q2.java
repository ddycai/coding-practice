/*
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot
 * can only move in two directors: right and down. How many possible paths are
 * there for the robot to go from (0,0) to (X,Y)?
 *
 * FOLLOW UP
 * Imagine certain spots are "off limits," such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom
 * right.
 * 
 * Solution: To get from (0, 0) to (X, Y), we need to go right X times and down
 * Y times. How many ways can we do this? You think think of it as the number
 * of ways to arrange a string of length X + Y consisting of Rs and Ds.
 * There are (X + Y)! ways to arrange this string, but since order amongst Rs and
 * Ds does not matter, we divide by X! and Y! to account for this.
 *
 * FOLLOW UP: I haven't done this yet.
 */

import java.util.*;

public class Q2 {

  public static int fact(int n) {
    if(n == 0 || n == 1)
      return 1;
    int f = 1;
    for(int i = 2; i <= n; i++)
      f *= i;
    return f;
  }

  public static int ways(int X, int Y) {
    return fact(X + Y)/(fact(X) * fact(Y));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();
    int Y = sc.nextInt();
    System.out.println(ways(X, Y));
    sc.close();
  }
}
