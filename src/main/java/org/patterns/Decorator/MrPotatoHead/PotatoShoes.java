package org.patterns.Decorator.MrPotatoHead;

public class PotatoShoes  implements PotatoHead{
    private PotatoHead header;

    public PotatoShoes(PotatoHead header){
        this.header = header;
    }
    @Override
    public String place() {
        return this.header.place() + " and a snazzy set of limited release converses";
    }

    public PotatoHead unwrap(){
        return header.unwrap();
    }

}
