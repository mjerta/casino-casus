package novi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum GameCollection {
  INSTANCE;

  private final Map<String, Game> games;

  GameCollection() {

    games = new HashMap<>();
  }

  public void addGame(String gameName, Game game) {
    this.games.put(gameName, game);
  }

  public void removeGame(String gameName) {
    games.remove(gameName);
  }

  public Game getGame(String name) {
    return games.get(name);
  }

  public List<String> getGameNames() {
    return new ArrayList<>(games.keySet());
  }

  public void printGames() {
    List<String> gameNames = getGameNames();
    for (int i = 0; i < gameNames.size(); i++) {
      System.out.println(i + ": " + gameNames.get(i));
    }
  }

  public String getGamename(Game game) {
    for (Map.Entry<String, Game> entry : games.entrySet()) {
      if (entry.getValue().equals(game)) {
        return entry.getKey();
      }
    }
    return null;
  }

  public int getNumGames() {
    return games.size();
  }
}