package org.patterns.Observer.ex2;

public class ProfPrairie implements Fan{

    @Override
    public void update(Game g){
        if (g.whoIsWinning().equals("UNC")) {
            System.out.println("UNC Fan: Go Heels!");
        } else if(g.whoIsWinning().equals("NC State")){
            System.out.println("NC State Fan: Go Wolfpack!");
        }
    }
}
