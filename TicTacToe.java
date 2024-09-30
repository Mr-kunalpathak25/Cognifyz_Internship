import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // Player X starts first
        initializeBoard();
    }

    // Initialize the board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current game board
    public void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("--------------");
        }
    }

    // Check if the current player has won
    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Check if the game is a draw
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Found an empty spot
                }
            }
        }
        return true; // No empty spots left
    }

    // Switch the current player
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Play a round of Tic-Tac-Toe
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            boolean gameWon = false;
            boolean gameDraw = false;

            while (!gameWon && !gameDraw) {
                displayBoard();
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt() - 1; // Convert to 0-based index
                int col = scanner.nextInt() - 1; // Convert to 0-based index

                if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                    System.out.println("This move is not valid. Try again.");
                    continue;
                }

                board[row][col] = currentPlayer; // Place the move on the board

                gameWon = checkWin(); // Check for a win
                gameDraw = checkDraw(); // Check for a draw

                if (gameWon) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (gameDraw) {
                    displayBoard();
                    System.out.println("It's a draw!");
                } else {
                    switchPlayer(); // Switch to the other player
                }
            }

            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            if (playAgain) {
                initializeBoard(); // Reset the board for a new game
                currentPlayer = 'X'; // Reset the current player
            }

        } while (playAgain);

        scanner.close();
        System.out.println("Thank you for playing!");
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}