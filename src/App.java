import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Scanner to take user input

        // Initiate the game and get the list of players
        ArrayList<Player> players = initialize(scanner);

        // Play 5 turns of the game
        for (int i = 0; i < 5; i++) {
            System.out.println("Turn " + (i + 1));
            takeTurn(players, scanner); // Each player takes their turn
        }

        // Determine and display the final winners
        ArrayList<Player> winners = getWinners(players);
        System.out.println("Game is over! Winner:");

        // Display the name and score of each winner
        for (Player player : winners) {
            System.out.println(player.getName() + " with " + player.getScore());
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }

    // Method to initialize the game by getting the number of players, dice, and sides
    private static ArrayList<Player> initialize(Scanner scanner) {
        // Ask how many players will be in the game
        System.out.println("How many players?");
        int numPlayers = scanner.nextInt();  // Read the number of players

        // Ask how many dice each player will have
        System.out.println("How many dice?");
        int numDice = scanner.nextInt();  // Read the number of dice

        // Ask how many sides each die will have
        System.out.println("How many sides?");
        int numSides = scanner.nextInt();  // Read the number of sides for each die

        scanner.nextLine();  // Clear the buffer after reading integer inputs

        ArrayList<Player> players = new ArrayList<>();  // List to store the players

        // Loop to collect each player's name and create Player objects
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player name " + (i + 1) + ": ");
            String name = scanner.nextLine();  // Read the player's name
            players.add(new Player(name, numDice, numSides));  // Create and add the player
        }
        return players; // Return the list of players
    }

    // Method to handle one turn for all players
    private static void takeTurn(ArrayList<Player> players, Scanner scanner) {
        Random random = new Random();  // Random object for rolling dice

        // Loop through each player to take their turn
        for (Player player : players) {
            // Ask the player to guess the outcome of their roll
            System.out.println(player.getName() + "'s turn. Guess the roll:");
            int guess = scanner.nextInt();  // Read the player's guess

            // Roll the dice for the player and get the total roll value
            int roll = player.rollDice(random);
            System.out.println(player.getName() + " rolled " + roll);  // Display the roll

            // Check if the player guessed the roll correctly
            if (roll == guess) {
                player.increaseScore();  // Increase player's score if guessed correctly
                System.out.println(player.getName() + " guessed correctly!");
            } else {
                System.out.println(player.getName() + " guessed incorrectly.");
            }
        }
    }

    // Method to determine the winner(s) based on the highest score
    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();  // List to store the winner(s)
        int maxScore = 0;  // Variable to track the highest score

        // Loop through all players to find the highest score
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                winners.clear();  // Clear previous winners if a new high score is found
                winners.add(player);  // Add the player with the new highest score
                maxScore = player.getScore();  // Update the maxScore to the new high score
            } else if (player.getScore() == maxScore) {
                winners.add(player);  // If the player's score matches the max score, add them as a co-winner
            }
        }

        return winners;  // Return the list of winner(s)
    }
}
