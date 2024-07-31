package novi.BlackJack;

import novi.Game;

import java.util.Scanner;

public abstract class BlackjackGame implements Game {
  private final Scanner inputScanner;
  protected Deck deck;
  protected Player player;
  protected Dealer dealer;
  boolean gameIsRunning;

  public BlackjackGame(Scanner inputScanner, Deck deck) {
    this.inputScanner = inputScanner;
    this.deck = deck;
  }

  public void playGame() {
    printOutIntro();
    resetGame();
    while (gameIsRunning) {
      runRound();
    }
  }

  public abstract void printOutIntro();

  public abstract void runRound();

  public void renderOutFullGameStatus() {
    renderOutStatusPlayer();
    System.out.println();
    renderOutStatusDealer();
    System.out.println();
  }

  public void renderOutStatusPlayer() {
    System.out.println("PLAYERS HAND");
    System.out.println(player.renderHand());
    System.out.println("The total value of your hand is " + player.getHandvalue());
  }

  public void renderOutStatusDealer() {
    System.out.println("DEALERS HAND");
    System.out.println(dealer.renderHand());
    System.out.println("The total value of the dealers hand is " + dealer.getHandvalue());
  }

  public void perfomMovePlayer() {
    while (true) {
      System.out.println("Hit or stay");
      String choise = inputScanner.nextLine();
      if (choise.equals("hit")) {
        player.performMove(deck, "hit");
        return;
      }
      else if (choise.equals("stay")) {
        player.performMove(deck, "stay");
        return;
      }
    }
  }

  public void chooseToPlayAgain() {
    while (true) {
      System.out.println("Do you want to play again");
      String choise = inputScanner.nextLine();
      if (choise.equals("yes")) {
        resetGame();
        return;
      }
      else if (choise.equals("no")) {
        gameIsRunning = false;
        return;
      }
    }
  }

  public void resetGame() {
    this.player = new Player();
    this.dealer = new Dealer();
    // the deck will be shuffled;
    deck.shuffle();
    // Give the player 2 cards
    player.addCardsToHand(deck.getNextCard(), deck.getNextCard());
    // Give the dealer a card
    dealer.addCardsToHand(deck.getNextCard());
    gameIsRunning = true;
  }

  public void createExpance() {
    try {
      Thread.sleep(1000);
      System.out.print(".");
      Thread.sleep(1000);
      System.out.print(".");
      Thread.sleep(1000);
      System.out.print(".\n");
    } catch (InterruptedException e) {
      System.out.println("Tread was interrupted.");
    }
  }
}
