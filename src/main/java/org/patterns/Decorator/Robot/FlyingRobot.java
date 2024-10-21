package org.patterns.Decorator.Robot;

public class FlyingRobot implements Robot{
    Robot myRobot;

    public FlyingRobot(Robot myRobot){
        this.myRobot = myRobot;
    }

    @Override
    public String getFunction() {
        return myRobot.getFunction() + " that can fly";
    }
}
