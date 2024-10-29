package org.patterns.Observer.ex2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Create observable game objects
    Game[] games = new Game[3];
    games[0] = new GameImpl("Basketball", "Duke", "UNC");
    games[1] = new GameImpl("Baseball", "UNC", "NCState");
    games[2] = new GameImpl("Lacrosse", "Duke", "Georgetown");

    // Create fan objects (observers)
    UNCFan tar_heel = new UNCFan();
    DukeFan dookie = new DukeFan();

    // Register observers
    for (Game g : games) {
      g.addObserver(tar_heel);
      g.addObserver(dookie);
    }

    // Allow the program user to score points
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      int game_index = s.nextInt();
      String team = s.next();
      int points_to_add = s.nextInt();

      games[game_index].scorePoints(team, points_to_add);
      games[game_index].printScore();
    }

    // Shut down
    s.close();
  }
}
