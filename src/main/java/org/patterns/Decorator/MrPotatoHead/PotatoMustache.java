package org.patterns.Decorator.MrPotatoHead;

public class PotatoMustache  implements PotatoHead {
    private PotatoHead header;

    public PotatoMustache(PotatoHead header){
        this.header = header;
    }

    @Override
    public String place() {
        return header.place() + " and a mustache";
    }

    public PotatoHead unwrap(){
        return header.unwrap();
    }
}
