package org.patterns.Observer.ex1;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  // Observable: Encapsulates a list of observers
  private List<Fan> observers;

  // Encapsulates two teams and two scores
  private String home;
  private String visitor;
  private int homeScore;
  private int visitorScore;

  // Constructor
  public GameImpl(String visitingTeam, String homeTeam) {
    observers = new ArrayList<Fan>();

    home = homeTeam;
    visitor = visitingTeam;
    homeScore = 0;
    visitorScore = 0;
  }

  // Observable: Registers an observer by adding it to the list
  public void addObserver(Fan o) {
    observers.add(o);
  }

  // Observable: De-registers an observer by removing it from the list
  public void removeObserver(Fan o) {
    observers.remove(o);
  }

  // Observable: Calls update() on each observer to notify them of an event
  public void notifyObservers() {
    for (Fan o : observers) {
      o.update();
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
    System.out.println(visitor + " " + visitorScore + " - " + homeScore + " " + home);
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
