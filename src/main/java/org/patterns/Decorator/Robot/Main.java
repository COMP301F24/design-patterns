package org.patterns.Decorator.Robot;

public class Main {
    public static void main(String[] args){
        Robot r = new RobotImpl();
        System.out.println(r.getFunction());

        r = new FlyingRobot(r);
        System.out.println(r.getFunction());

        r = new SeeingRobot(r);
        System.out.println(r.getFunction());
    }
}
