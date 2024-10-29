package org.patterns.Observer.ex3;

public class DukeFan implements Fan {
  // Handles events
  public void update(Game g, GameEvent e) {
    if (e.getWhoScored().equals("Duke")) {
      if (g.whoIsWinning().equals("Duke")) {
        System.out.println("Duke Fan: Go Devils!");
      } else {
        System.out.println("Duke Fan: Getting there, Duke!");
      }
    }
  }
}
