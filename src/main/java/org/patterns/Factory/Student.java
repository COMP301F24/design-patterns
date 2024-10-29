package org.patterns.Factory;

public class Student {
    Notification.Type preference;

    public Student(Notification.Type preference){
        this.preference = preference;
    }

    public Notification.Type getNotificationPreference(){

        return this.preference;
    }

}
