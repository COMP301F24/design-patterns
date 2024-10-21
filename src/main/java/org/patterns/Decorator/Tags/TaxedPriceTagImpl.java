package org.patterns.Decorator.Tags;

public class TaxedPriceTagImpl implements TaxedPriceTag {
    double rate;
    PriceTag pre_tax_tag;

    public TaxedPriceTagImpl(PriceTag pre_tax_tag, double rate) {
        this.pre_tax_tag = pre_tax_tag;
        this.rate = rate;
    }

    @Override
    public void setAmount(double amount) {
        pre_tax_tag.setAmount(amount);
    }

    @Override
    public double getAmount() {
        return pre_tax_tag.getAmount()+getTax();
    }

    @Override
    public double getTax() {
        return rate*pre_tax_tag.getAmount();
    }

    @Override
    public double getTaxRate() {
        return rate;
    }

    @Override
    public PriceTag getPreTaxPriceTag() {
        return pre_tax_tag;
    }
}
