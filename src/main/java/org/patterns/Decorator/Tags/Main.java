package org.patterns.Decorator.Tags;

public class Main {
  public static void main(String[] args) {
    PriceTag basicTag = new PriceTagImpl(100);
    PriceTag discountTag1 = new DiscountedPriceTag(basicTag, 20);
    PriceTag discountTag2 = new DiscountedPriceTag(discountTag1, 20);

    TaxedPriceTag with_tax = new TaxedPriceTagImpl(basicTag, 0.05);
    System.out.println("That will be " + with_tax.getAmount() + " with tax.");
  }
}
