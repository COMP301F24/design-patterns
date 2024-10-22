package org.patterns.Decorator.DressedToImpress;

public class Pose28 implements DressedToImpress {
    private DressedToImpress person;

    public Pose28(DressedToImpress person){
        this.person = person;
    }


    @Override
    public String pose() {
        return person.pose() + " while doing pose28";
    }
    public DressedToImpress unwrap(){
        return person.unwrap();
    }

}
