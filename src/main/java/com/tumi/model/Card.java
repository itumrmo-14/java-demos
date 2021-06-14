package com.tumi.model;

public class Card  implements Comparable<Card>{
    private int suit;
    private int rank;
    @Override
    public int compareTo(Card o) {
        if (this.rank == (o.getRank()))
            return 0;
        else if ((this.rank) > (o.getRank()))
            return 1;
        else
            return -1;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
