package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private String name;
    private int score;
    private Card[] cards;
    private int chosenCardIndex = 0;

    public Player(String name) {
        this.name = name;
    }

    public void setCards(Card[] cards){
        this.cards = cards.clone();
    }

    public Card chooseCard(){
        Card chosenCard = cards[chosenCardIndex];
        if (chosenCardIndex < 3) cards[chosenCardIndex++] = null;
        return chosenCard;
    }

    public void incrementScore(){
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChosenCardIndex(int chosenCardIndex) {
        this.chosenCardIndex = chosenCardIndex;
    }
}
