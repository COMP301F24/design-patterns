package org.patterns.Decorator.Robot;

public class SeeingRobot implements Robot{
    private Robot myRobot;

    public SeeingRobot(Robot myRobot){
        this.myRobot = myRobot;
    }
    @Override
    public String getFunction(){
        return myRobot.getFunction() + " that can see";
    }

}
