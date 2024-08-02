package novi.slotmachines;

import java.util.ArrayList;
import java.util.List;

public class ReelDeck {

  private final List<Reel> reels;

  public ReelDeck(List<Reel> reels) {
    this.reels = reels;
  }

  public void roll() {
    for (Reel reel : reels) {
      reel.roll();
    }
  }

  public String render() {
    String totalrender = "";
    for (Reel reel : reels) {
      totalrender = totalrender + " " + reel.render() + "\n";
    }
    return totalrender;
  }

  public boolean allReelsHaveSymbol(Symbol symbol) {
    for (Reel reel : reels) {
      if (reel.getSymbol() != symbol) {
        return false;
      }
    }
    return true;
  }

}
