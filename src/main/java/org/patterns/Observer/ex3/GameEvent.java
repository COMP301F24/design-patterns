package org.patterns.Observer.ex3;

public interface GameEvent {
  // Gets the type of event as a String
  String getType();

  // Gets the team that scored as a String
  String getWhoScored();
}
