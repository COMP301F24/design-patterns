package org.patterns.Factory;

public class Notification {
    protected Notification(){}

    public enum Type {
    TEXT,
    EMAIL,
    PUSH
  };

  public static Notification create(Student s) {
    Type type = s.getNotificationPreference();
    if (type == Type.TEXT) {
      return new TextNotification();
    } else if (type == Type.EMAIL) {
      return new EmailNotification();
    } else if (type == Type.PUSH) {
      return new PushNotification();
    } else {
      throw new UnsupportedOperationException();
    }
  }
}
