package Poker;

import Player.Player;

import java.util.ArrayList;

public class Game {
    private int index, SB, BB;
    private Player dealer,small,big,turn;
    private ArrayList<Player> players;
    public Game(ArrayList<Player> players,int SB, int BB){
        this.players = players;
        this.SB = SB;
        this.BB = BB;
        index = 3 % players.size();
        dealer = players.get(0);
        small = players.get(1);
        big = players.get(2 % players.size());
        turn = players.get(3 % players.size());


    }



    public void printTurns(){
        System.out.println("Dealer is " + dealer.getName());
        System.out.println("Small blind is: " + small.getName());
        System.out.println("Big blind is: " + big.getName());
        System.out.println("Turn is " + turn.getName());
    }


    public Player getDealer() {
        return dealer;
    }

    public Player getSmall() {
        return small;
    }

    public Player getBig() {
        return big;
    }

    public Player getTurn() {
        return turn;
    }

    public void takeTurn(){
        index = (index + 1) % players.size();
        turn = players.get(index);
    }
}
