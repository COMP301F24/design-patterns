package org.patterns.Observer.ex1;

public class UNCFan implements Fan {
  // Encapsulates the game it observes
  private Game game;

  // Constructor
  public UNCFan(Game g) {
    game = g;
    game.addObserver(this);
  }

  // Handles events
  public void update() {
    if (game.whoIsWinning().equals("UNC")) {
      System.out.println("UNC Fan: Go Heels!");
    }
  }
}
