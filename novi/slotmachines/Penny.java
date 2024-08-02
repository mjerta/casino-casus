package novi.slotmachines;

import novi.GameCollection;

import java.util.Scanner;

public class Penny extends SlotMachine {


  public Penny(Scanner inputScanner) {
    super("Penny",3);
  }

  public int getRollPrice() {
    return 1;
  }

  @Override
  public int calculatePayOut() {
    if(reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
      return 1;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
      return 2;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
      return 3;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
      return 4;
    } else if (reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
      return 5;
    }
    return 0;
  }

  @Override
  public String renderWinningConditions() {
    return """
           3x star | 1 coins
           3x yinyang | 2 coins
           3x spade | 3 coins
           3x heart | 4 coins
           3x club | 5 coins
           """;
  }
}
