package org.patterns.Observer.ex1;

public class DukeFan implements Fan {
  // Encapsulates the game it observes
  private Game game;

  // Constructor
  public DukeFan(Game g) {
    game = g;
    game.addObserver(this);
  }

  // Handles events
  public void update() {
    if (game.whoIsWinning().equals("Duke")) {
      System.out.println("Duke Fan: Go Devils!");
    }
  }
}
