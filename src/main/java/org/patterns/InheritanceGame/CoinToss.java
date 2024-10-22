package org.patterns.InheritanceGame;

public class CoinToss extends AGame {

    public CoinToss(){
        super("CoinToss");
        this.numPlayers = 1;
    }
    @Override
    public void play() {
        double odds = Math.random(); //Returns a number [0-1).
        if(odds > 0.5){
            win();
        }
        System.out.println("You lost.  Please play again.");
    }

    @Override
    public String win() {
        return "You won the coin toss!";
    }
}
