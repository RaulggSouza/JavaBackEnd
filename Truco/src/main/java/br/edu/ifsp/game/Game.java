package br.edu.ifsp.game;

public class Game {
    private final Player player1;
    private final Player player2;
    private Hand[] hands;
    private int handsPlayed;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        hands = new Hand[30];
        hands[0] = new Hand(player1, player2);
        handsPlayed = 0;
    }

    public void play(){
        Hand hand = hands[handsPlayed];
        player1.setChosenCardIndex(0);
        player2.setChosenCardIndex(0);

        while (!hand.isDone()){
            hand.playRound();
        }

        if (hand.getWinner() == null) {
            System.out.println("Tie");
            return;
        }

        Player playerWinner = (hand.getWinner().equals(player1.getName()) ? player1 : player2);
        playerWinner.incrementScore();
        System.out.println("Winner of the Hand: "+playerWinner.getName());

        increaseHandsPlayedCounter();
        hands[handsPlayed] = new Hand(player1, player2);
    }

    public boolean isDone(){
        return player1.getScore() == 12 || player2.getScore() == 12;
    }

    public Player getWinner(){
        if (!isDone()) return null;
        return player1.getScore() == 12 ? player1 : player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Hand[] getHands() {
        return hands;
    }

    public void setHands(Hand[] hands) {
        this.hands = hands;
    }

    public int getHandsPlayed() {
        return handsPlayed;
    }

    private void increaseHandsPlayedCounter() {
        this.handsPlayed++;
    }
}
