package org.patterns.Observer.TakeOut.part1;

public class Main {
    public static void main(String[] args){
        HungryCollegeStudent joe = new HungryCollegeStudent();
        Restaurant brenz = new BrenzPizza();

       String phoneCall = joe.orderTakeout();
       Order dinner = brenz.processOrder(phoneCall);
       System.out.println(dinner.getDescription());

       Customer sally = new Customer() {
           @Override
           public String orderTakeout() {
               return "Tonkotsu Ramen";
           }
       };

       Restaurant pirateCaptain = new Restaurant() {
           @Override
           public Order processOrder(String order) {
               return new Order("One steaming bowl of delicious noodles and protein");
           }
       };

       Order sallysDinner = pirateCaptain.processOrder(sally.orderTakeout());
       System.out.println(sallysDinner.getDescription());

       Customer maria = () -> { return "Chicken Burrito";};
       Restaurant cosmicCantina = (String order) -> { return new Order("Delicious and nutritious sustenance in a flour tortilla");};
       System.out.println(cosmicCantina.processOrder(maria.orderTakeout()).getDescription());
    }
}
