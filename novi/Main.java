package novi;

import java.util.Scanner;

import novi.BlackJack.BlackjackGame;
import novi.BlackJack.LowDeckBlackJack;
import novi.BlackJack.SimpleBlackJack;
import novi.higherlower.HigherLowerGame;
import novi.slotmachines.SlotMachineGame;

public class Main {

  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    SlotMachineGame slotMachineGame = new SlotMachineGame(inputScanner);
    HigherLowerGame higherLowerGame = new HigherLowerGame(inputScanner);
    BlackjackGame simpleBlackJack = new SimpleBlackJack(inputScanner);
    BlackjackGame lowDeckBlackJack = new LowDeckBlackJack(inputScanner);
    chooseGame(inputScanner);
  }

  public static void chooseGame(Scanner inputScanner) {
    while (true) {
      System.out.println("Welcome to the online casino\nChoose what game you want to play\n");
      System.out.println("x: choose to exit");
      GameCollection.INSTANCE.printGames();
      String choise = inputScanner.nextLine();
      if (choise.equals("x")) {
        System.out.println("See you next time!");
        break;
      }
      try {
        Game selectedGame = GameCollection.INSTANCE.getGame(GameCollection.INSTANCE.getGameNames().get(Integer.parseInt(choise)));
        selectedGame.playGame();

      } catch (Exception e) {
        if (e instanceof NumberFormatException) {
          System.out.println("That is not a number\n");
        }
        else if (e instanceof IndexOutOfBoundsException) {
          System.out.println("This index does not exists\n");
        }
        else if (e instanceof NullPointerException) {
          System.out.println("Null value\n");
        }
      }
    }
  }
}
