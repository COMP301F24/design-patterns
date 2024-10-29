package org.patterns;

import org.patterns.Factory.Notification;
import org.patterns.Factory.Student;
import org.patterns.Factory.TextNotification;

public class Main {
    public static void main(String[] args){
        Student text = new Student(Notification.Type.TEXT);


        Notification n = Notification.create(text);
        System.out.println(n.getClass());
    }

}
