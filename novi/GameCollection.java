package novi;

import novi.slotmachines.SlotMachine;
import novi.slotmachines.SlotMachineGame;

import java.util.*;

public enum GameCollection {
  INSTANCE;

  private final Map<String, Game> games;
  private final Map<String, SlotMachine> slotMachineGames;

  GameCollection() {
    games = new LinkedHashMap<>();
    slotMachineGames = new LinkedHashMap<>();
  }

  public void addSlotMachineGame(String gameName, SlotMachine slotMachine) {
    this.slotMachineGames.put(gameName, slotMachine);
  }

  public Map<String, SlotMachine> getSlotMachineGames() {
    return slotMachineGames;
  }

  public List<String> getStringSlotMachineGames() {
    return new ArrayList<>(slotMachineGames.keySet());
  }

  public List<SlotMachine> getSlotMachineGamesValues() {
    return new ArrayList<>(slotMachineGames.values());
  }

  public void printSlotMachineGames() {
    List<String> gameNames = getStringSlotMachineGames();
    for (int i = 0; i < gameNames.size(); ++i) {
      System.out.println(i + ": " + gameNames.get(i));
    }
  }

  public SlotMachine getSlotMachine(int index) {
    return getSlotMachineGamesValues().get(index);
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

  public String printGames(Game game) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Game> entry : games.entrySet()) {
      if (entry.getValue() == game) {
        sb.append(entry.getKey());
      }
    }
    return sb.toString();
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