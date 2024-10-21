package org.patterns.Decorator.Tags;

public class DiscountedPriceTag implements PriceTag {
  private PriceTag tag;
  private double discount;

  DiscountedPriceTag(PriceTag tag, double discount) {
    this.tag = tag;
    this.discount = discount;
  }

  @Override
  public void setAmount(double amount) {
    tag.setAmount(amount);
  }

  @Override
  public double getAmount() {
    return Math.max(tag.getAmount() - discount, 0);
  }

  public PriceTag unwrap() {
    return tag;
  }
}
