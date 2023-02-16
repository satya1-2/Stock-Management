package stockManagement;

import java.util.ArrayList;
import java.util.Collections;

class Card {

    private final String suit;
    private final String rank;


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit + ", rank=" + rank + "]";
    }

}

class DeckOfCard {

    private static final String suits[] = {"club", "diamond", "heart", "spade"};
    private static final String ranks[] = {null, "ace", "deuce", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
    private final ArrayList<Card> cards;

    public DeckOfCard() {
        cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                this.cards.add(new Card(suits[i], ranks[j]));
            }
        }
        //Shuffle after the creation
        Collections.shuffle(this.cards);

    }

    public ArrayList<Card> getCards() {
        return cards;
    }


}

public class CardPuzzle {

    public static void main(String[] args) {

        DeckOfCard deck = new DeckOfCard();
        ArrayList<Card> cards = deck.getCards();
        for (Card card : cards) {
            System.out.println(card);
        }

    }

}