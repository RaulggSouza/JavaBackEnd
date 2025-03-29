package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private final String winner;

    public Round(String player1, Card card1, String player2, Card card2, Card vira){
        int result = card1.compareValueTo(card2, vira);
        if (result > 0){
            winner = player1;
        } else if (result < 0){
            winner = player2;
        } else {
            winner = null;
        }
    }

    public String getWinner() {
        return winner;
    }
}
