package org.patterns.Decorator.MrPotatoHead;

public class Main {
    public static void main(String[] args){
        PotatoHead p = new MrPotatoHead();
        p = new PotatoRayBans(p);
        p = new PotatoMustache(p);
        p = new PotatoShoes(p);

        System.out.println(p.place());

        p = p.unwrap();

        System.out.println(p.place());
    }
}
