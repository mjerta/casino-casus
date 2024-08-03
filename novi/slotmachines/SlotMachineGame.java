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
    while (!gameIsFinished) {
      String choise = gamePicker();
      if (exitTheGameOrNot(choise)) break;

      SlotMachine chosenSlotMachine = GameCollection.INSTANCE.getSlotMachine(Integer.parseInt(choise));
      if (chosenSlotMachine != null) {
        playSlotMachine(chosenSlotMachine);
      }
    }
  }

  private void playSlotMachine(SlotMachine chosenSlotMachine) {
    reelerIsFinished = false;
    while (!reelerIsFinished) {
      int slotMachinePrice = chosenSlotMachine.getRollPrice();
      chosenSlotMachine.renderIntro();
      System.out.println(chosenSlotMachine.renderWinningConditions());
      if (playerCoins >= slotMachinePrice) {
        processSlotMachinePlay(chosenSlotMachine, slotMachinePrice);
      }
      else {
        printNoCoinsLeft(false);
        reelerIsFinished = true;
      }
    }
  }

  private void processSlotMachinePlay(SlotMachine slotMachine, int slotMachinePrice) {
    insertCoin(slotMachine);
    renderGameFlowBeforeHandle(inputScanner, slotMachinePrice);
    var result = slotMachine.roll();
    System.out.println(slotMachine.render());
    validateHandle(result, slotMachinePrice);
  }

  private boolean exitTheGameOrNot(String choise) {
    if (choise.equals("x")) {
      System.out.println("See you next time at the slotmachines!\n");
      return true;
    }
    return false;
  }

  public String gamePicker() {
    System.out.println("Which game you want to play?");
    System.out.println("x: choose to exit");
    GameCollection.INSTANCE.printSlotMachineGames();
    return inputScanner.nextLine();
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

  public void renderGameFlowAfterHandle() {
    System.out.println("Press n if you want to stop, or any other key if you want to continue");
    String choise = inputScanner.nextLine();
    if (choise.equals("n")) {
      reelerIsFinished = true;
    }
  }

  public void printNoCoinsLeft(Boolean noCoinsAtAll) {
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

  public void validateHandle(int wonAmmountOfCoins, int priceOfGame) {
    if (wonAmmountOfCoins > 0) {
      printOutWinningMessage(wonAmmountOfCoins);
      return;
    }
    if (playerCoins < priceOfGame) {
      printNoCoinsLeft(true);
      reelerIsFinished = true;
      gameIsFinished = true;
    }
    else {
      printOutLosingMessage();
      renderGameFlowAfterHandle();
    }
  }
}
