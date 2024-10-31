package org.patterns.Observer.ex3;

public class UNCFan implements Fan {
  // Handles events
  // TODO: Add functionality so if UNC scored and
  //       a lead change happened, UNC fans should GO CRAZY!
  public void update(Game g, GameEvent e) {
    if (e.getWhoScored().equals("UNC")) {
      switch(g.whoIsWinning()){
        case "UNC" -> {System.out.println("UNC Fan: GO HEELS!");}
        default -> {System.out.println("UNC Fan: Good job, Carolina.");}
       }
//      if (g.whoIsWinning().equals("UNC")) {
//        System.out.println("UNC Fan: GO HEELS!");
//      } else {
//        System.out.println("UNC Fan: Good job, Carolina.");
//      }
    } else if (g.whoIsWinning().equals("UNC")) {
      System.out.println("UNC Fan: Stay tough, Heels.");
    }
  }
}
