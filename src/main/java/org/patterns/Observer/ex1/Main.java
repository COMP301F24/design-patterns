package org.patterns.Observer.ex1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Create game object (observable)
    Game g = new GameImpl("Duke", "UNC");

    // Create fan objects (observers)
    UNCFan tar_heel = new UNCFan(g);
    DukeFan dookie = new DukeFan(g);

    // Allow the program user to score points
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String team = s.next();
      int points_to_add = s.nextInt();

      g.scorePoints(team, points_to_add);
      g.printScore();
    }

    // Shut down
    s.close();
  }
}
