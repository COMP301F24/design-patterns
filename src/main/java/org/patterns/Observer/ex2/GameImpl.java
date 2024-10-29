package org.patterns.Observer.ex2;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  // Observable: Encapsulates a list of observers
  private List<Fan> fans;

  // Encapsulates two teams and two scores
  private String home;
  private String visitor;
  private int homeScore;
  private int visitorScore;

  // Now also encapsulates a sport
  private String sport;

  // Constructor
  public GameImpl(String game_type, String visitingTeam, String homeTeam) {
    fans = new ArrayList<Fan>();

    sport = game_type;
    home = homeTeam;
    visitor = visitingTeam;
    homeScore = 0;
    visitorScore = 0;
  }

  // Observable: Registers an observer by adding it to the list
  public void addObserver(Fan o) {
    fans.add(o);
  }

  // Observable: De-registers an observer by removing it from the list
  public void removeObserver(Fan o) {
    fans.remove(o);
  }

  // Observable: Calls update() on each observer to notify them of an event
  public void notifyObservers() {
    for (Fan o : fans) {
      o.update(this);
    }
  }

  // Updates the scoreboard and notifies observers when a team scores
  public void scorePoints(String team, int points) {
    if (home.equals(team)) {
      homeScore += points;
    } else if (visitor.equals(team)) {
      visitorScore += points;
    }
    notifyObservers();
  }

  // Prints the current score to System.out
  public void printScore() {
    System.out.println(
        sport + ": " + visitor + " " + visitorScore + " - " + homeScore + " " + home);
  }

  // Returns the winning team as a String
  public String whoIsWinning() {
    if (homeScore > visitorScore) {
      return home;
    } else if (homeScore < visitorScore) {
      return visitor;
    }
    return "Tie Game";
  }
}
