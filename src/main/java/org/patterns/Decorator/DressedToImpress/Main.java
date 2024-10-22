package org.patterns.Decorator.DressedToImpress;

public class Main {
    public static void main(String[] args){
        DressedToImpress steve = new BasePerson();
        steve = new SillyGlasses(steve);
        steve = new Pose28(steve);

        System.out.println(steve.pose());

        steve = steve.unwrap();
        System.out.println(steve.pose());
    }
}
