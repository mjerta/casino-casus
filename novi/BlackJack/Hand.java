package novi.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private List<Card> cards;

  public Hand() {
    cards = new ArrayList<Card>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public int getTotalValue() {
    int total = 0;
    for (Card card : cards) {
      total += card.getValue();
    }
    return total;
  }

  public String render() {
    StringBuilder output = new StringBuilder();
    for (Card card : cards) {
      output.append(card.render());
    }
    return output.toString();
  }
}
