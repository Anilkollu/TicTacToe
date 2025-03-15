
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameOver) {
      printBoard(board);
      System.out.print("Player" + player + "enter: ");
      try{
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println();

        // check if the indices are out of bound:
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds, please enter right index!");
        }

        if (board[row][col] == ' ') {
          board[row][col] = player; 
          gameOver = haveWon(board, player);
          if (gameOver) {
            System.out.println("Player " + player + " has won: ");
          } else {
            if (player == 'X') {
            player = 'O';
            } else {
            player = 'X';
            }
          }
        } else {
          System.out.println("Invalid move. Try again!");
        }
      }
      catch(ArrayIndexOutOfBoundsException e){
        System.out.println(e.getMessage());
      }
    }
    printBoard(board);
  }

  public static boolean haveWon(char[][] board, char player) {
    // check the rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) return true;
    }

    // check for col
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) return true;
    }

    // diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player)  return true;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player)  return true;
    
    return false;
  }

  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print( "_" + board[row][col] + "_" + "|" );
        
      }
      System.out.println();
    }
  }
}







