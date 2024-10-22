package org.patterns.Decorator.MrPotatoHead;

public class MrPotatoHead implements PotatoHead{

    @Override
    public PotatoHead unwrap() {
        return this;
    }

    @Override
    public String place() {
        return "The potato has a head";
    }
}
