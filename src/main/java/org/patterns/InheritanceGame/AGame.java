package org.patterns.InheritanceGame;

public  abstract class AGame implements IGame, Comparable<IGame>{
    private String name;
    protected int numPlayers;

    public AGame(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract void play();
    public abstract String win();

    public int compareTo(IGame other){
        return this.getName().compareTo(other.getName());
    }
}
