package novi.slotmachines;

import novi.Game;
import novi.GameCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class SlotMachine {
  private final String name;
  private final int numberOfReels;
  protected final ReelDeck reelDeck;

  public SlotMachine(String name, int numberOfReels) {
    this.name = name;
    this.numberOfReels = numberOfReels;
    ArrayList<Reel> reelList = new ArrayList<>();
    for(int i = 0; i < numberOfReels; i++) {
      reelList.add(new Reel());
    }
    reelDeck = new ReelDeck(reelList);

    GameCollection.INSTANCE.addSlotMachineGame(name, this);

  }

  public void renderIntro() {
    System.out.println("Welcome to the Slot machine" + name);
  }

  public int roll() {
    reelDeck.roll();
    return calculatePayOut();
  }


  public String render() {
    return reelDeck.render();
  }

  public abstract int getRollPrice();

  public abstract int calculatePayOut();

  public abstract String renderWinningConditions();

}
