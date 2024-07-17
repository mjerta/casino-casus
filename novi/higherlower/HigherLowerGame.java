package novi.higherlower;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
  private Scanner inputScanner;
  private boolean gameIsRunning;
  private Random random;

  public HigherLowerGame(Scanner inputScanner) {
    this.inputScanner = inputScanner;
    this.random = new Random();
  }

  public void playGame() {
    gameIsRunning = true;

    // Here you should generate the number to guess
    int randomNumber = random.nextInt(0, 100);
    int ammountOfGuesses = 0;
    int input = 0;
    while (gameIsRunning) {
      System.out.println(randomNumber);
      System.out.println("Make a guess");

      boolean inputIsSet = false;

      try {
        String string = inputScanner.nextLine();
        input = Integer.parseInt(string);

      } catch (NumberFormatException e) {
        System.out.println("Only numbers between 0 and 100");
      }

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
        gameIsRunning = false;
      }

      // Check if the guess is correct, if so end the game



    }
  }
}
