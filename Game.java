import java.util.*;

class Game {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = ' ';
            }
        }
        boolean gameover = false;
        char player = 'X';

        while (!gameover) {
            Printboard(board);
            System.out.println("Player " + player + " enter ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            System.out.println("row: " + r + "col: " + c);
            if (board[r][c] == ' ') {
                // making a move
                board[r][c] = player;
                gameover = havewon(board, player);
                if (gameover) {
                    System.out.println("Player " + player + " won the game");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Wrong move!");
            }

        }
        Printboard(board);
        System.out.println("Thank you for playing the game!");
    }

    public static boolean havewon(char[][] board, char player) {
        // checking columns
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // checking rows
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // checking first diagnol
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // checking second diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void Printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}