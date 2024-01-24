/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;

public class UserGame extends Game {
    private SelfPlayer autonomousPlayer;
    private UserPlayer userPlayer;
    private PlayerType currentTurn = PlayerType.X;

    public UserGame() {
        super();
        autonomousPlayer = new SelfPlayer(PlayerType.X, this);
        userPlayer = new UserPlayer(PlayerType.O, this);
    }

    @Override
    public PlayerType getTurn() {
        return currentTurn;
    }
    @Override
    protected void makeMove() {
        if (currentTurn == PlayerType.X) {
            autonomousPlayer.makeMove();
        } else {
            userPlayer.makeMove();
        }
    }

    @Override
    public void playGame() {
        while (!isGameOver()) {
            if (getTurn() == PlayerType.X) {
                autonomousPlayer.makeMove();
            } else {
                userPlayer.makeMove();
            }
            printBoard();
            if (checkForWinner() != null) {
                announceWinner();
                return;
            }
            switchTurn();
        }

        if (isBoardFull()) {
            System.out.println("The game is a draw.");
        }
    }

    // Method to announce the winner
    private void announceWinner() {
        PlayerType winner = checkForWinner();
        if (winner != null) {
            System.out.println("Winner: " + winner);
        }
    }

    // Override switchTurn() if needed
    @Override
    protected void switchTurn() {
        // Switch the turn to the other player
        currentTurn = (currentTurn == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }

    // Implement other methods as needed
    // ...
}
