package novi.BlackJack;

public class CardValue {

  private final int value;
  private final String name;

  public CardValue(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
