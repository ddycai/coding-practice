/*
 * Write an algorithm to print all ways of arranging eight queens on an 8x8
 * chess board so that none of them share the same row, column or diagonal. In
 * this case, "diagonal" means all diagonals, not just the two that bisect the
 * board.
 *
 * My solution stores the board as a long, which means I can't do this for any
 * chess board larger than 8 because I was initially storing all of the
 * solutions in a HashSet and I thought a 64-bit long was the fastest
 * way to check two boards are equal. It turns out that we don't need to do
 * that. I'm keeping the solution using the longs because I think the bit
 * manipulation is neat.
 *
 * My solution is to place a queen in each row and check the constraints. I
 * stored the constraints as three arrays: col, rdiag and ldiag. col stores
 * which columns have been taken up, rdiag stores which right diagonals
 * (diagonals going from the left up to the right) have been taken up and ldiag
 * stores the left diagonals (diagonals going from left down to
 * the right).
 *
 * To check which right diagonal a point (i, j) is on, we take i + j.
 * To check which left diagonal a point (i, j) is on, we take the difference i
 * - j then we add N - 1 as an offset for negative differences.
 *
 * You can see this by sketching our your own example and looking at the
 * indices of the diagonals.
 *
 * Intuitively, it's because to traverse a diagonal from bottom left to top
 * right, you do row--, col++, which makes the row + col always the same.
 * From top left to bottom right, you do row++, col++, which makes the row -
 * col always the same.
 *
 * I know this is not the most elegant solution, but it's not bad.
 */

import java.util.*;

public class Q9 {

  public static int count = 0;

  public static void placeQueens(boolean[] col, boolean[] rdiag, boolean[] ldiag, long board, int row) { 
    
    if(row == 8) {
      printBoard(board);
      count++;
      return;
    }

    for(int j = 0; j < 8; j++) {
      long mask = 1L << (row * 8 + j);
      if((board & mask) == 0 && !col[j] && !rdiag[row + j] && !ldiag[row - j + 7]) {
        col[j] = true;
        rdiag[row + j] = true;
        ldiag[row - j + 7] = true;
        // set bit to 1
        board = board | mask;
        placeQueens(col, rdiag, ldiag, board, row + 1);
        // set bit to 0
        board = board & ~mask;
        col[j] = false;
        rdiag[row + j] = false;
        ldiag[row - j + 7] = false;

      }
    }
  }

  public static void printBoard(long board) {
    long mask = 0;
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        mask = 1L << (i * 8 + j);
        if((board & mask) != 0)
          System.out.print("Q ");
        else
          System.out.print(". ");
      }
      System.out.println();
    }
    System.out.println("----------");
  }


  public static void main(String[] args) {
    boolean[] col = new boolean[8];
    boolean[] rdiag = new boolean[16];
    boolean[] ldiag = new boolean[16];
    long board = 0L;
    placeQueens(col, rdiag, ldiag, board, 0);
    System.out.println(count);
  }

}
