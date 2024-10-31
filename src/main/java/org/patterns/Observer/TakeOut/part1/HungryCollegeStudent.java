package org.patterns.Observer.TakeOut.part1;

public class HungryCollegeStudent implements Customer {
    @Override
    public String orderTakeout() {
        return "Pizza";
    }
}
