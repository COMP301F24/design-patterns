package org.patterns.Observer.TakeOut.part2;

import java.util.ArrayList;
import java.util.List;

public class HungryCollegeStudent implements Customer{
    private List<Restaurant> rests = new ArrayList<>();

    @Override
    public void orderTakeout(Order o) {
        for(Restaurant r : rests){
            r.processOrder(o);
        }
    }

    @Override
    public void addRestaurant(Restaurant r) {
        this.rests.add(r);
    }

    @Override
    public void removeRestaurant(Restaurant r) {
        this.rests.remove(r);
    }
}
