package novi.slotmachines;

import java.util.Random;

public class Reel {

  private Symbol currentSymbol;
  private Symbol[] symbolValues;

  public Reel() {
    this.symbolValues = Symbol.values();
  }

  public void roll() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(symbolValues.length);
    currentSymbol = symbolValues[randomNumber];

  }

  public String render() {
    return currentSymbol.toString();
  }

  public Symbol getSymbol() {
    return currentSymbol;
  }


}
