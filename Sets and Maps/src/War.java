import java.util.LinkedHashSet;
import java.util.Scanner;

public class War {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading input and filling decks for both players
        LinkedHashSet<Integer> firstPlayerDeck = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayerDeck = new LinkedHashSet<>();

        // Read and populate the first player's deck
        System.out.println("Enter 20 unique numbers for the first player:");
        for (int i = 0; i < 20; i++) {
            firstPlayerDeck.add(sc.nextInt());
        }

        // Read and populate the second player's deck
        System.out.println("Enter 20 unique numbers for the second player:");
        for (int i = 0; i < 20; i++) {
            secondPlayerDeck.add(sc.nextInt());
        }

        // Game loop, max 50 rounds
        for (int i = 0; i < 50; i++) {
            // If any player runs out of cards, the game ends
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                System.out.println("Draw");
                break;
            }

            // Get and remove the top numbers for both players
            int firstNumberPlayer1 = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstNumberPlayer1);

            int firstNumberPlayer2 = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(firstNumberPlayer2);

            // Compare the numbers and decide who wins the round
            if (firstNumberPlayer1 > firstNumberPlayer2) {
                firstPlayerDeck.add(firstNumberPlayer1);  // Winner keeps his number
                firstPlayerDeck.add(firstNumberPlayer2); // Winner takes the opponent's number
            } else if (firstNumberPlayer2 > firstNumberPlayer1) {
                secondPlayerDeck.add(firstNumberPlayer1);  // Winner keeps his number
                secondPlayerDeck.add(firstNumberPlayer2); // Winner takes the opponent's number
            }
            // If there's a draw, no cards are added back to either deck
        }

        // Determine the winner or if it's a draw
        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player wins!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
