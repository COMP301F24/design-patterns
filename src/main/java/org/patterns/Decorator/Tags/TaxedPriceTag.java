package org.patterns.Decorator.Tags;

public interface TaxedPriceTag extends PriceTag {
    double getTax();
    double getTaxRate();
    PriceTag getPreTaxPriceTag();
}
