package org.patterns.Observer.TakeOut.part2;

public class Order {
    private Type type;

    public enum Type {PIZZA, RAMEN, BURRITO}

    public Order(Type type){
        this.type = type;
    }

    public Order.Type getType(){
        return this.type;
    }

    public String getDescription(){
        switch(this.type){
            case PIZZA -> { return "Delicious pizza"; }
            case RAMEN -> { return "Steaming bowl of noodles";}
            case BURRITO -> { return "Delicious and nutritious sustenance in a flour tortilla";}
        }
        return "";
    }
}
