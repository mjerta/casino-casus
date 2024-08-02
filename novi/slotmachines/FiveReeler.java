package novi.slotmachines;

import novi.GameCollection;

import java.util.Scanner;

public class FiveReeler extends SlotMachine {


  public FiveReeler(Scanner inputScanner) {
    super("Five Reeler",5);
  }

  public int getRollPrice() {
    return 5;
  }

  @Override
  public int calculatePayOut() {
    if(reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
      return 5;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
      return 10;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
      return 15;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
      return 20;
    } else if (reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
      return 25;
    }
    return 0;
  }

  @Override
  public String renderWinningConditions() {
    return """
           5x star | 50 coins
           5x yinyang | 10 coins
           5x spade | 15 coins
           5x heart | 20 coins
           5x club | 25 coins
           """;
  }
}
