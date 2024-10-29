package org.patterns.Observer.ex3;

public class GameEventImpl implements GameEvent {
  // Encapsulates the event type and who scored
  private String type;
  private String whoScored;

  // Constructor
  GameEventImpl(String type, String whoScored) {
    this.type = type;
    this.whoScored = whoScored;
  }

  // Gets the type of event as a String
  public String getType() {
    return type;
  }

  // Gets the team that scored as a String
  public String getWhoScored() {
    return whoScored;
  }
}
