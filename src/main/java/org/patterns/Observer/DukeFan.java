package org.patterns.Observer;

public class DukeFan implements Observer {
  // Encapsulates the game it observes
  private Subject game;

  // Constructor
  public DukeFan(Subject g) {
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
