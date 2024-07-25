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
    for (int i = 0; i < cards.size(); i++) {
      if (i >= 1) {
        output.append(" & ");
      }
      output.append(cards.get(i).render());
    }
    return output.toString();
  }
}
