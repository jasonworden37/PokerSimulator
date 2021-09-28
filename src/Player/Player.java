package Player;

import Poker.rank;

public class Player {
    String name,rank;
    int x,y,balance;
    String[] cards;
    rank ranker = new rank();
    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
        rank = "High Card";
        cards = new String[2];

    }
    public void setCard(String card, int index){
        cards[index] = card;
        updateRank();
    }

    public void updateRank(){
        rank = ranker.getRank(cards,2);
    }

    public String getName(){
        return name;
    }




}
