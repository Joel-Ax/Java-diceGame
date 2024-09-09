import java.util.ArrayList;
import java.util.Random;

public class Player {
  // Private instance variables
  private String name;             // Name of the player
  private int score;               // Player's score
  private ArrayList<Die> diceList; // List of dice associated with the player

  // Constructor to initialize the player with a name, number of dice, and sides per die
  public Player(String name, int numDice, int numSides) {
    this.name = name;             // Set the player's name
    this.score = 0;               // Initialize score to 0
    this.diceList = new ArrayList<Die>(); // Initialize an empty list for dice
    
    // Add the specified number of dice, each with the specified number of sides
    for (int i = 0; i < numDice; i++) {
      this.addDie(numSides); // Add each die to the player's dice list
    }
  }

  // Getter for the player's name
  public String getName(){
    return this.name; // Return the player's name
  }

  // Getter for the player's score
  public int getScore() {
    return this.score; // Return the player's current score
  }

  // Method to roll all dice in the player's dice list
  // The total value of all rolls is calculated and returned
  public int rollDice(Random random) {
    int totalValue = 0; // Initialize the total value of rolled dice
    // Iterate through each die and roll it, adding its value to totalValue
    for (Die die : diceList) {
      die.roll(random);           // Roll the current die
      totalValue += die.getValue(); // Add the rolled value to totalValue
    }
    return totalValue; // Return the sum of the values of all dice after rolling
  }

  // Method to get the total value of all dice without re-rolling them
  public int getDieValue() {
    int totalValue = 0; // Initialize the total value
    // Iterate through each die and add its current value to totalValue
    for (Die die : diceList) {
      totalValue += die.getValue(); // Add the value of each die to totalValue
    }
    return totalValue; // Return the sum of the values of all dice
  }

  // Method to increase the player's score by 1
  public void increaseScore() {
    this.score += 1; // Increment the player's score by 1
  }

  // Method to add a new die with a specified number of sides to the player's dice list
  public void addDie(int sides) {
    Die newDie = new Die(sides);  // Create a new die with the specified number of sides
    diceList.add(newDie);         // Add the new die to the player's dice list
  }
}
