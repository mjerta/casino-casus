package novi.slotmachines;

import novi.GameCollection;

import java.util.Scanner;

public class HighRoller extends SlotMachine {


  public HighRoller(Scanner inputScanner) {
    super("High Roller",3);
  }

  public int getRollPrice() {
    return 10;
  }

  @Override
  public int calculatePayOut() {
    if(reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
      return 3;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
      return 6;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
      return 9;
    }
    else if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
      return 12;
    } else if (reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
      return 15;
    }
    return 0;
  }

  @Override
  public String renderWinningConditions() {
    return """
           3x star | 3 coins
           3x yinyang | 6 coins
           3x spade | 9 coins
           3x heart | 12 coins
           3x club | 215 coins
           """;
  }
}
