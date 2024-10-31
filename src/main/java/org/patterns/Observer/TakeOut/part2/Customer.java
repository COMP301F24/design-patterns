package org.patterns.Observer.TakeOut.part2;

public interface Customer {
    void orderTakeout(Order o);
    void addRestaurant(Restaurant r);
    void removeRestaurant(Restaurant r);
}
