import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    public static final int WINNING_POSITION = 100;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        int[] positions = new int[numPlayers];
        int[] rolls = new int[numPlayers];
        int currentPlayer = 0;
        boolean isGameOver = false;

        Random random = new Random();
        while (!isGameOver) {
            System.out.println("Player " + (currentPlayer + 1) + " turn:");

            int roll = random.nextInt(6) + 1;
            rolls[currentPlayer]++;

            int option = random.nextInt(3);
            switch (option) {
                case NO_PLAY -> System.out.println("No Play");
                case LADDER -> {
                    System.out.println("Ladder");
                    if (positions[currentPlayer] + roll <= WINNING_POSITION) {
                        positions[currentPlayer] += roll;
                    }
                }
                case SNAKE -> {
                    System.out.println("Snake");
                    if (positions[currentPlayer] - roll >= 0) {
                        positions[currentPlayer] -= roll;
                    }
                }
            }

            System.out.println("Player " + (currentPlayer + 1) + " position: " + positions[currentPlayer]);

            if (positions[currentPlayer] == WINNING_POSITION) {
                isGameOver = true;
                System.out.println("Player " + (currentPlayer + 1) + " wins!");
            } else {
                currentPlayer = (currentPlayer + 1) % numPlayers;
            }
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " rolls: " + rolls[i]);
        }

        scanner.close();
    }
}
