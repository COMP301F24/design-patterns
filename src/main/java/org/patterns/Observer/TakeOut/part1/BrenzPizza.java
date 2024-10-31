package org.patterns.Observer.TakeOut.part1;

public class BrenzPizza implements Restaurant {
    public Order processOrder(String description){
        return new Order("Large Cheese Pizza");
    }
}
