public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        var oneCard = deck.takeOne();
        System.out.println(oneCard.cardAsString());

        var manyCards = deck.takeMany(3);
        for (Card card : manyCards){
            card.faceUp();
            System.out.println(card.cardAsString());
        }
    }
}
