/*
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 */

import java.util.*;

public class Q2 {

  public static char winner(char[][] board) {

    // downwards diagonal
    boolean win = true;
    for(int i = 1; i < board.length; i++)
      win = win & (board[i][i] == board[i - 1][i - 1]);

    if(win)
      return board[0][0]; 

    win = true;
  
    // upwards diagonal
    for(int i = 1; i < board.length; i++)
      win = win & (board[board.length - i - 1][i] == board[board.length - i][i - 1]);

    if(win)
      return board[board.length - 1][0];

   // columns
   for(int i = 0; i < board.length; i++) {
     win = true;
     for(int j = 1; j < board.length; j++)
       win = win & (board[j - 1][i] == board[j][i]);
     if(win)
       return board[0][i];
   }

   // rows
   for(int i = 0; i < board.length; i++) {
     win = true;
     for(int j = 1; j < board.length; j++)
       win = win & (board[i][j - 1] == board[i][j]);
     if(win)
       return board[i][0];
   }

   return '.';
  }

  public static void main(String[] args) {
    char[][] board = new char[3][3];
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < 3; i++) {
      board[i] = sc.nextLine().toCharArray();
    }
    System.out.println(winner(board));
    sc.close();
  }

}


