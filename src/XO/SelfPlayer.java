/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;

import java.util.List;
import java.util.Random;

public class SelfPlayer extends Player {

    public SelfPlayer(PlayerType type, Game game) {
        super(type, game);
    }

    @Override
    public void makeMove() {
        try {
            Thread.sleep(500); // Simulate thinking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Cell> freeCells = game.getFreeCells();
        if (!freeCells.isEmpty()) {
            Random random = new Random();
            Cell selectedCell = freeCells.get(random.nextInt(freeCells.size()));
            game.markCell(selectedCell, playerType);
        }
    }
}
