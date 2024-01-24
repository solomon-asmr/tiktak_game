/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package XO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select game mode:");
        System.out.println("1 - Two autonomous players");
        System.out.println("2 - One autonomous player and one user-controlled player");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            choice = scanner.nextInt();
        }

        Game game;
        if (choice == 1) {
            game = new SelfGame(); // Both players are autonomous
        } else {
            game = new UserGame(); // One autonomous player and one user-controlled player
        }

        game.playGame(); // Start the game
    }
}
