/*
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the color
 * changes from the original color.
 *
 * Solution: We can write a paintFill function that fills the curent square and
 * then recursively calls paintFill on its adjacent squares. It will stop painting
 * when it finds that the current color is not longer the old color.
 */

import java.util.*;

public class Q7 {


  /*
   * Function that calls the actual paintFill function with the parameter 'old',
   * which is the old colour at point (row, col) to keep track of when we should
   * stop colouring.
   */
  public static void paintFill(char[][] screen, int row, int col, char c) {
    paintFill(screen, row, col, screen[row][col], c);
  }

  private static void paintFill(char[][] screen, int row, int col, char old, char c) {
    if(row <= 0 || col <= 0 || row >= screen.length || col >= screen[0].length)
      return;
    if(screen[row][col] != old)
      return;
    screen[row][col] = c;
    paintFill(screen, row + 1, col, old, c);
    paintFill(screen, row, col + 1, old, c);
    paintFill(screen, row - 1, col, old, c);
    paintFill(screen, row, col - 1, old, c);
  }

  /*
   * Takes a grid and a point (r, c) and fills paint fills it with '.'.
   * Input: Begins with nr (number of rows), nc (number of columns), r and c
   * (the coordinates of the point fill point) followed by nr lines containing
   * nc characters.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nr = sc.nextInt();
    int nc = sc.nextInt();
    int r = sc.nextInt();
    int c = sc.nextInt();
    char[][] screen = new char[nr][nc];
    sc.nextLine();
    for(int i = 0; i < nr; i++) {
      String s = sc.nextLine();
      for(int j = 0; j < nc; j++) {
        screen[i][j] = s.charAt(j);
        System.out.print(screen[i][j]);
      }
      System.out.println();
    }

    paintFill(screen, r, c, '.');

    System.out.println("---");

    for(int i = 0; i < nr; i++) {
      for(int j = 0; j < nc; j++) {
        System.out.print(screen[i][j]);
      }
      System.out.println();
    }

  }

}
