package org.patterns.Observer.ex2;
public class UNCFan implements Fan {
  public void update(Game g) {
    if (g.whoIsWinning().equals("UNC")) {
      System.out.println("UNC Fan: Go Heels!");
    }
  }
}
