package org.patterns.Decorator.DressedToImpress;

public class SillyGlasses implements DressedToImpress {
    private DressedToImpress person;

    public SillyGlasses(DressedToImpress person){
        this.person=person;
    }

    @Override
    public String pose() {
        return person.pose() + " while wearing silly glasses";
    }
    public DressedToImpress unwrap(){
        return person.unwrap();
    }

}
