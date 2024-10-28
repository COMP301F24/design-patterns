package org.patterns.Factory;

public class Main {
    public static void main(String[] args){
        Student text = new Student(Notification.Type.TEXT);

        TextNotification myNote = new TextNotification();

        Notification n = Notification.create(text);
        System.out.println(n.getClass());
    }

}
