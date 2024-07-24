package novi.BlackJack;

import javax.xml.namespace.QName;

public class CardSuit {

  private final String name;
  private final char symbol;
  private final String color;

  public CardSuit(String name, char symbol, String color) {
    this.name = name;
    this.symbol = symbol;
    this.color = color;
  }
}
