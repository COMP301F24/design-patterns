package org.patterns.Observer;

public class UNCFan implements Observer {
  // Encapsulates the game it observes
  private Subject game;

  // Constructor
  public UNCFan(Subject g) {
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
