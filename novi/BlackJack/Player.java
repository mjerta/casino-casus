package novi.BlackJack;

public class Player {
  private Hand hand;
  private boolean staying;

  public Player() {
    this.hand = new Hand();
  }

  public void performMove(Deck deck, String move) {
    if(move.equals("hit")) {
      Card nextCard = deck.getNextCard();
      hand.addCard(nextCard);
      System.out.println("The player hit with: " + nextCard.render());
      System.out.println("The total value of your hand is " + getHandvalue() + "\n");
    }
    else if (move.equals("stay")) {
      staying = true;
      System.out.println("The player is staying!");
      System.out.println("The total value stayed the same: " + getHandvalue()  + "\n");
    }
  }

  public void addCardsToHand(Card...cards) {
    for (Card card : cards) {
      hand.addCard(card);
    }
  }

  public boolean isStaying() {
    return staying;
  }

  public boolean isBust() {
    return hand.getTotalValue() > 21;
  }

  public int getHandvalue() {
    return hand.getTotalValue();
  }

  public String renderHand() {
    return hand.render();
  }
}
