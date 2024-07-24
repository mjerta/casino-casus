package novi.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

  private final List<Card> cards;

  public Deck() {

    CardSuit[] suits = new CardSuit[] {
      new CardSuit("diamonds", '\u2666', "red"),
      new CardSuit("spades", '\u2660', "black"),
      new CardSuit("hearts", '\u2665', "red"),
      new CardSuit("clubs", '\u2663', "black")
    };
    CardValue[] values = new CardValue[] {
      new CardValue("two", 2),
      new CardValue("three", 3),
      new CardValue("four", 4),
      new CardValue("five", 5),
      new CardValue("six", 6),
      new CardValue("seven", 7),
      new CardValue("eight", 8),
      new CardValue("nine", 9),
      new CardValue("ten", 10),
      new CardValue("jack", 10),
      new CardValue("queen", 10),
      new CardValue("king", 10)
    };

    cards = new ArrayList<>();
    for (CardSuit suit : suits) {
      for (CardValue value : values) {
        cards.add(new Card(suit, value));
      }
    }
  }
  public void shuffle() {
    Random rand = new Random();
    for(int i = 0; i < cards.size(); i++) {
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
