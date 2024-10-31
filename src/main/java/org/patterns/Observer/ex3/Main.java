package org.patterns.Observer.ex3;

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

//    Fan profPrairie = new Fan(){
//      @Override
//      public void update(Game g, GameEvent e){
//        if(g.whoIsWinning().equals("UNC") || g.whoIsWinning().equals("NC State")){
//          System.out.println("Go Team!");
//        }
//      }
//    };

    Fan profPrairie = (Game g, GameEvent e) -> {
        if(g.whoIsWinning().equals("UNC") || g.whoIsWinning().equals("NC State")){
          System.out.println("Go Team!");
        }

    };


    // Register observers
    for (Game g : games) {
      g.addObserver(tar_heel);
      g.addObserver(dookie);
      g.addObserver(profPrairie);
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
