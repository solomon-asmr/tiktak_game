/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected char[][] gameBoard = new char[5][5];
    protected PlayerType currentTurn;

    public Game() {
        // Initialize the game board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public abstract PlayerType getTurn();

    public List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '-') {
                    freeCells.add(new Cell(i, j));
                }
            }
        }
        return freeCells;
    }

        // Method to check if a player has won
        public PlayerType checkForWinner() {
            // Check each row and column
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 2; j++) { // Ensure j + 3 < 5
                    if (checkLineForWinner(gameBoard[i][j], gameBoard[i][j + 1], gameBoard[i][j + 2], gameBoard[i][j + 3])) {
                        return playerTypeFromChar(gameBoard[i][j]);
                    }
                    if (checkLineForWinner(gameBoard[j][i], gameBoard[j + 1][i], gameBoard[j + 2][i], gameBoard[j + 3][i])) {
                        return playerTypeFromChar(gameBoard[j][i]);
                    }
                }
            }

            // Check diagonals
            for (int i = 0; i < 2; i++) { // Ensure i + 3 < 5
                for (int j = 0; j < 2; j++) { // Ensure j + 3 < 5
                    // Top-left to bottom-right
                    if (checkLineForWinner(gameBoard[i][j], gameBoard[i + 1][j + 1], gameBoard[i + 2][j + 2], gameBoard[i + 3][j + 3])) {
                        return playerTypeFromChar(gameBoard[i][j]);
                    }
                    // Top-right to bottom-left
                    if (checkLineForWinner(gameBoard[i][4 - j], gameBoard[i + 1][3 - j], gameBoard[i + 2][2 - j], gameBoard[i + 3][1 - j])) {
                        return playerTypeFromChar(gameBoard[i][4 - j]);
                    }
                }
            }

            return null; // No winner found
        }


        // Helper method to check if four chars are the same and not empty
        private boolean checkLineForWinner(char c1, char c2, char c3, char c4) {
            return (c1 != '-') && (c1 == c2) && (c2 == c3) && (c3 == c4);
        }

        // Helper method to convert char to PlayerType
        private PlayerType playerTypeFromChar(char c) {
            return (c == 'X') ? PlayerType.X : PlayerType.O;
        }



        // ... [existing methods]

        // Check if the game is over (win or draw)
        public boolean isGameOver() {
            return checkForWinner() != null || isBoardFull();
        }

        // Switch the turn to the next player
        protected void switchTurn() {
            currentTurn = (currentTurn == PlayerType.X) ? PlayerType.O : PlayerType.X;
        }

        // Mark a cell with the current player's type
        public void markCell(Cell cell, PlayerType playerType) {
            if (isValidMove(cell.getRow(), cell.getCol())) {
                gameBoard[cell.getRow()][cell.getCol()] = (playerType == PlayerType.X) ? 'X' : 'O';
            }
        }

        // Check if the move is valid (cell is within the board and empty)
        public boolean isValidMove(int row, int col) {
            return row >= 0 && row < 5 && col >= 0 && col < 5 && gameBoard[row][col] == '-';
        }

        // Check if the board is full
        public boolean isBoardFull() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (gameBoard[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }
    public void playGame() {
        while (!isGameOver()) {
            makeMove();
            printBoard();
            if (checkForWinner() != null) {
                System.out.println("Winner: " + checkForWinner());
                return;
            }
            switchTurn();
        }

        if (isBoardFull()) {
            System.out.println("The game is a draw.");
        }
    }
    protected abstract void makeMove();


        // ... [other methods, including checkForWinner()]
    }


