/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;
public abstract class Player {
    protected PlayerType playerType;
    protected Game game;

    public Player(PlayerType type, Game game) {
        this.playerType = type;
        this.game = game;
    }

    public abstract void makeMove();
}
