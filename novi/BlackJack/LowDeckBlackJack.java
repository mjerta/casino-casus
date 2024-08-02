package novi.BlackJack;

import novi.GameCollection;

import java.util.Scanner;

public class LowDeckBlackJack extends BlackjackGame {
  public LowDeckBlackJack(Scanner inputScanner) {
    super(inputScanner, new LowDeck());
    GameCollection.INSTANCE.addGame("Low deck blackjack", this);


  }

  @Override
  public void printOutIntro() {
    System.out.println("\nWelcome to the " + GameCollection.INSTANCE.getGamename(this) + "\n");
  }

  @Override
  public void runRound() {
    if (dealer.isBust() || dealer.isStaying() && dealer.getHandvalue() < player.getHandvalue()) {
      createExpance();
      System.out.println("You won!!");
      renderOutFullGameStatus();
      chooseToPlayAgain();
      return;
    }
    if (player.isBust() || player.isStaying() && player.getHandvalue() <= dealer.getHandvalue()) {
      createExpance();
      System.out.println("You lost buddy!");
      renderOutFullGameStatus();
      chooseToPlayAgain();
      return;
    }
    if (!player.isStaying()) {
      renderOutStatusPlayer();
      perfomMovePlayer();
    }
    if (!dealer.isStaying() && !player.isBust()) {
      renderOutStatusDealer();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        System.out.println("Tread was interrupted.");
      }
      dealer.performMove(deck);
    }
  }
}
