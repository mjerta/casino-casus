package novi.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Deck {

  private final List<Card> cards;

  public Deck(CardSuit[] suits, CardValue[] values, int ammounOfDecks) {
    cards = new ArrayList<>();
    for (int i = 0; i < ammounOfDecks; i++) {
      for (CardSuit suit : suits) {
        for (CardValue value : values) {
          cards.add(new Card(suit, value));
        }
      }
    }
  }

  public void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < cards.size(); i++) {
      int randomIdex = rand.nextInt(i + 1);
      // Swap cards[i] with the element at random index
      Card temp = cards.get(i);
      cards.set(i, cards.get(randomIdex));
      cards.set(randomIdex, temp);
    }
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }

  public Card getNextCard() {
    return cards.removeLast();
  }
}
