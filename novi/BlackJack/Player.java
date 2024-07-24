package novi.BlackJack;

public class Player {
  private Hand hand;
  private boolean staying;

  public Player() {
    this.hand = new Hand();
  }

  public void performMove(Deck deck, String move) {
    if(move.equals("hit")) {
      hand.addCard(deck.getNextCard());
      System.out.println("The player hit!");
    }
    else if (move.equals("stay")) {
      staying = true;
      System.out.println("The player is staying!");
    }
  }

  public void addCardsToHand(Card[] cards) {
    for (Card card : cards) {
      hand.addCard(card);
    }
  }

  public boolean isStaying() {
    return staying;
  }

  public boolean isBust() {
    return hand.getTotalValue() <= 21;
  }

  public int getHandvalue() {
    return hand.getTotalValue();
  }

  public String renderHand() {
    return hand.render();
  }
}
