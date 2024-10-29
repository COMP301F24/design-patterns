package org.patterns.Observer.ex2;

public class DukeFan implements  Fan {
  public void update(Game g) {
    if (g.whoIsWinning().equals("Duke")) {
      System.out.println("Duke Fan: Go Devils!");
    }
  }
}
