package novi.slotmachines;

import novi.Game;
import novi.GameCollection;

import java.util.*;

public class SlotMachineGame implements Game {
  private final Scanner inputScanner;
  private int playerCoins;
  private boolean gameIsFinished;
  private SlotMachine[] slotMachines;
  private boolean reelerIsFinished;

  public SlotMachineGame(Scanner inputScanner) {
    this.inputScanner = inputScanner;
    playerCoins = 50;
    GameCollection.INSTANCE.addGame("Slot Machine Game", this);
    slotMachines = new SlotMachine[]{new FiveReeler(inputScanner), new HighRoller(inputScanner), new Penny(inputScanner),};
  }

  @Override
  public void playGame() {
    gameIsFinished = false;
    String choise = "";
    while (!gameIsFinished) {
      System.out.println("Which game you want to play?");
      System.out.println("x: choose to exit");
      GameCollection.INSTANCE.printSlotMachineGames();
      choise = inputScanner.nextLine();
      if(choise.equals("x")) {
        System.out.println("See you next time at the slotmachines!\n");
        gameIsFinished = true;
        break;
      }
      for (SlotMachine slotMachine : slotMachines) {
        if (GameCollection.INSTANCE.getSlotMachine(Integer.parseInt(choise)).equals(slotMachine)) {
          reelerIsFinished = false;
          while (!reelerIsFinished) {
            int slotMachinePrice = slotMachine.getRollPrice();
            slotMachine.renderIntro();
            System.out.println(slotMachine.renderWinningConditions());
            if (playerCoins >= slotMachinePrice) {
              insertCoin(slotMachine);
              renderGameFlowBeforeHandle(inputScanner, slotMachinePrice);
              int result = executeHandle(slotMachine);
              validateHandle(slotMachine, result, choise, slotMachinePrice);
            }
            else {
              printOutNoCoinsAnymore(false);
              reelerIsFinished = true;
            }
          }
        }
      }
    }
  }

  public void insertCoin(SlotMachine slotMachine) {
    playerCoins -= slotMachine.getRollPrice();
  }

  public void renderGameFlowBeforeHandle(Scanner inputScanner, int slotMachinePrice) {
    System.out.println("You spend " + slotMachinePrice);
    System.out.println("Total coins left: " + playerCoins);
    System.out.println("Pull the handle. Press any key");
    inputScanner.nextLine();

  }

  public void renderGameFlowAfterHandle(String choise) {
    System.out.println("Press n if you want to stop, or any other key if you want to continue");
    choise = inputScanner.nextLine();
    if (choise.equals("n")) {
      reelerIsFinished = true;
    }
  }

  public int executeHandle(SlotMachine slotMachine) {
    var result = slotMachine.roll();
    var reel = slotMachine.render();
    System.out.println(reel);
    return result;
  }

  public void printOutNoCoinsAnymore(Boolean noCoinsAtAll) {
    System.out.println("You did not have enough coins to play this game");
    if (!noCoinsAtAll) {
      System.out.println("Please, try another game");
    }
    else {
      System.out.println("No more coins left, your out of the game \n");
    }
  }

  public void printOutWinningMessage(int wonAmmountOfCoins) {
    System.out.println("Congratulations you have won " + wonAmmountOfCoins + " coins!");
  }

  public void printOutLosingMessage() {
    System.out.println("You did not get any points");
  }

  public void validateHandle(SlotMachine slotMachine, int wonAmmountOfCoins, String choise, int priceOfGame) {
    if (wonAmmountOfCoins > 0) {
      printOutWinningMessage(wonAmmountOfCoins);
      return;
    }
    if (playerCoins < priceOfGame) {
      printOutNoCoinsAnymore(true);
      reelerIsFinished = true;
      gameIsFinished = true;
    }
    else {
      printOutLosingMessage();
      renderGameFlowAfterHandle(choise);
    }
  }
}
