package novi.higherlower;

import novi.Game;
import novi.GameCollection;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame implements Game {
  private final Scanner inputScanner;
  private final Random random;

  public HigherLowerGame(Scanner inputScanner) {
    this.inputScanner = inputScanner;
    this.random = new Random();
    GameCollection.INSTANCE.addGame("Higher or Lower", this);
  }

  public void playGame() {
    boolean gameIsRunning = true;

    // Here you should generate the number to guess
    int randomNumber = random.nextInt(0, 100);
    int ammountOfGuesses = 0;
    int input = 0;
    while (gameIsRunning) {
      System.out.println(randomNumber);
      System.out.println("Make a guess");
      try {
        input = inputScanner.nextInt();
        System.out.printf("You typed: %s\n", input);
        ammountOfGuesses++;
        if (input > randomNumber) {
          System.out.println("That number is too high!");
        }
        else if (input < randomNumber) {
          System.out.println("That number is too low!");
        }
        else {
          System.out.printf("Correct! You guessed the number in %x turns", ammountOfGuesses);
          // Check if the guess is correct, if so end the game
          gameIsRunning = false;
        }
      } catch (InputMismatchException e) {
        System.out.println("Only numbers are allowed");
        inputScanner.nextLine();
      }
    }
  }
}
