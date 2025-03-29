package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private final Card vira;
    private Round[] rounds;
    private final Player player1;
    private final Player player2;
    private int roundsPlayed;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        rounds = new Round[3];
        Deck deck = new Deck();
        deck.shuffle();
        vira = deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
        roundsPlayed = 0;
    }

    public void playRound(){
        Round round = new Round(player1.getName(), player1.chooseCard(), player2.getName(), player2.chooseCard(), vira);
        System.out.println(round.getWinner());
        rounds[roundsPlayed++] = round;
    }

    public boolean isDone(){
        if (roundsPlayed < 2) return false;
        if (roundsPlayed == 2) {
            if (rounds[0].getWinner() != null && rounds[1].getWinner() == null) return true;
            if (rounds[0].getWinner() == null && rounds[1].getWinner() != null) return true;
            if (rounds[0].getWinner() == null && rounds[1].getWinner() == null) return false;
            return (rounds[0].getWinner().equals(rounds[1].getWinner()));
        }
        return true;
    }

    public String getWinner(){
        if (!isDone()) return null;
        if (roundsPlayed == 2){
            if (rounds[0].getWinner() != null){
                if (rounds[1].getWinner() == null || rounds[0].getWinner().equals(rounds[1].getWinner())) return rounds[0].getWinner();
            }
            if (rounds[1].getWinner() != null) return rounds[1].getWinner();
        }
        if (rounds[2].getWinner() != null){
            if (rounds[0].getWinner().equals(rounds[2].getWinner()) || rounds[1].getWinner().equals(rounds[2].getWinner())) return rounds[2].getWinner();
        }
        if (rounds[0].getWinner() != null) return rounds[0].getWinner();
        return rounds[2].getWinner();
    }

    public Card getVira() {
        return vira;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setRounds(Round[] rounds) {
        this.rounds = rounds;
    }

}
