package org.patterns.Observer.TakeOut.part1;

public class Order {
    private String description;

    public Order(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
