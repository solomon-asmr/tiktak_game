/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;

import java.util.Scanner;

public class UserPlayer extends Player {
    private Scanner scanner;

    public UserPlayer(PlayerType type, Game game) {
        super(type, game);
        scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove() {
        int row, col;
        do {
            System.out.println("Enter row and column (0-4): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!game.isValidMove(row, col));

        game.markCell(new Cell(row, col), playerType);
    }
}
