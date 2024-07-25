package novi.BlackJack;

public class Dealer {
  private Hand hand;
  private boolean staying;

  public Dealer() {
    this.hand = new Hand();
  }

  public void performMove(Deck deck) {
    if(getHandvalue() < 17) {
      Card nextCard = deck.getNextCard();
      hand.addCard(nextCard);
      System.out.println("The dealer hit with: " + nextCard.render());
      System.out.println("The total value of the dealers hand is " + getHandvalue()  + "\n");
    }
    else {
      staying = true;
      System.out.println("The player is staying!");
      System.out.println("The total value stayed the same: " + getHandvalue()  + "\n");
    }
  }

  public void addCardsToHand(Card... cards) {
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
