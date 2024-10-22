package org.patterns.Decorator.DressedToImpress;

public class BasePerson implements DressedToImpress{

    @Override
    public String pose() {
        return "The Person looks fabulous";
    }

    public DressedToImpress unwrap(){
        return this;
    }
}
