import java.util.Random;

public class Die {
  // Instance variables to store the number of sides and current value of the die,
  // and a static Random object shared across all instances for generating random numbers
  private int sides;
  private int value;  
  private static Random randomGenerator = new Random();

  // Default constructor initializes the die with 6 sides (a standard die)
  public Die() {
    this.sides = 6; // Default number of sides is set to 6
  }

  // Constructor to initialize the die with a specific number of sides
  public Die(int sides) {
    this.sides = sides; // Set the number of sides to the provided value
  }

  // Method to return the current value of the die
  public int getValue() {
    return this.value;
  }
  
  // Method to return the number of sides of the die
  public int getSides() {
    return this.sides;
  }

  // Method to roll the die and update its value with a random number between 1 and the number of sides
  public void roll(Random random) {
    // Generates a random integer between 1 and the number of sides (inclusive)
    this.value = randomGenerator.nextInt(this.sides) + 1;
  }
}
