package br.edu.ifsp;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Rank;
import br.edu.ifsp.deck.Suit;
import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Hand;
import br.edu.ifsp.game.Player;

public class Principal {
    public static void main(String[] args) {
        /*Card[] cardsRob = new Card[3];
        cardsRob[0] = Card.of(Rank.FIVE, Suit.DIAMONDS);
        cardsRob[1] = Card.of(Rank.TWO, Suit.SPADES);
        cardsRob[2] = Card.of(Rank.THREE, Suit.CLUBS);
        Card[] cardsMary = new Card[3];
        cardsMary[0] = Card.of(Rank.FIVE, Suit.HEARTS);
        cardsMary[1] = Card.of(Rank.JACK, Suit.SPADES);
        cardsMary[2] = Card.of(Rank.THREE, Suit.DIAMONDS);

        //Player class tests
        Player roberto = new Player("Roberto");
        roberto.setCards(cardsRob);
        Player mary = new Player("Mary");
        mary.setCards(cardsMary);

//        System.out.println(mary.chooseCard().toString());
//        System.out.println(mary.chooseCard().toString());
//        System.out.println(mary.chooseCard().toString());

        //Round class tests
        Card vira = Card.of(Rank.FOUR, Suit.HEARTS);
//        for (int i = 0; i < 3; i++) {
//            Round round = new Round(roberto.getName(), roberto.chooseCard(), mary.getName(), mary.chooseCard(), vira);
//            System.out.println(round.getWinner());
//        }

        //Hand class tests
        Hand hand = new Hand(roberto, mary);
        String winner = "";
        for (int i = 0; i < 3; i++){
            hand.playRound();
            winner = hand.getWinner();
            if (winner != null) {
                break;
            }
        }
        System.out.println(winner);*/
        Player roberto = new Player("Roberto");
        Player mary = new Player("Mary");
        Game game = new Game(roberto, mary);
        while (game.getWinner() == null){
            game.play();
        }
        System.out.println("winner of the Game: " + game.getWinner().getName());
    }
}
