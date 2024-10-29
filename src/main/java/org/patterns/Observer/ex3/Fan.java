package org.patterns.Observer.ex3;

public interface Fan {
  // Called by the Observable when an event occurs
  void update(Game g, GameEvent e);
}
