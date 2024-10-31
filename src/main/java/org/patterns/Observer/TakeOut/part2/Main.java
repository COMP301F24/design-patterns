package org.patterns.Observer.TakeOut.part2;

public class Main {
  public static void main(String[] args) {
    Restaurant brenz =
        (Order o) -> {
          if (o.getType().equals(Order.Type.PIZZA)) {
            System.out.println("Brenz is making the best pizza in Chapel Hill");
          }
        };

      Restaurant pirateCaptain =
              (Order o) -> {
                  if (o.getType().equals(Order.Type.RAMEN)) {
                      System.out.println("PirateCaptain is making one steaming bowl of delicious noodles and protein");
                  }
              };

    Restaurant cosmicCantina =
        (Order o) -> {
          if (o.getType().equals(Order.Type.BURRITO)) {
            System.out.println("Cosmic Cantina is making delicious and nutritious sustenance in a flour tortilla");
          }
        };

    HungryCollegeStudent joe = new HungryCollegeStudent();

    joe.addRestaurant(cosmicCantina);
    joe.addRestaurant(brenz);
    joe.addRestaurant(pirateCaptain);

    joe.orderTakeout(new Order(Order.Type.RAMEN));
  }
}
