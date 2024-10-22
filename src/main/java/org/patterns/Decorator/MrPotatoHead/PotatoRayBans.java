package org.patterns.Decorator.MrPotatoHead;

public class PotatoRayBans  implements PotatoHead{
    private PotatoHead header;

    public PotatoRayBans(PotatoHead header){
        this.header = header;
    }

    @Override
    public String place() {
        return this.header.place() + " and a funky set of raybanss";
    }

    public PotatoHead unwrap(){
        return header.unwrap();
    }

}
