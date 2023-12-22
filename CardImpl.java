public class CardImpl implements Card {

    private Suit suit;
    private Rank rank;

    public CardImpl(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void printCard() {
        System.out.print(this.rank + " of " + this.suit);
    }
}
