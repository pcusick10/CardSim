import java.util.ArrayList;

public class DeckImpl implements Deck {
    private ArrayList<Card> cards;
    private ArrayList<Boolean> isCardDealt;
    private int numCards;

    public DeckImpl() {
        this.initializeCards();
        this.isCardDealt = new ArrayList<>(52);
        for (int i = 0; i < isCardDealt.size(); i++) {
            isCardDealt.add(false);
        }
        this.numCards = 52;
    }

    private void initializeCards() {
        this.cards = new ArrayList<>(52);
        for (int i = 0; i < cards.size(); i++) {
            Suit currentSuit = Suit.SPADES;
            Rank currentRank = Rank.ACE;
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        currentSuit = Suit.SPADES;
                        break;
                    case 1:
                        currentSuit = Suit.CLUBS;
                        break;
                    case 2:
                        currentSuit = Suit.HEARTS;
                        break;
                    case 3:
                        currentSuit = Suit.DIAMONDS;
                        break;
                }
                for (int k = 0; k < 13; k++) {
                    switch (k) {
                        case 0:
                            currentRank = Rank.TWO;
                            break;
                        case 1:
                            currentRank = Rank.THREE;
                            break;
                        case 2:
                            currentRank = Rank.FOUR;
                            break;
                        case 3:
                            currentRank = Rank.FIVE;
                            break;
                        case 4:
                            currentRank = Rank.SIX;
                            break;
                        case 5:
                            currentRank = Rank.SEVEN;
                            break;
                        case 6:
                            currentRank = Rank.EIGHT;
                            break;
                        case 7:
                            currentRank = Rank.NINE;
                            break;
                        case 8:
                            currentRank = Rank.TEN;
                            break;
                        case 9:
                            currentRank = Rank.JACK;
                            break;
                        case 10:
                            currentRank = Rank.QUEEN;
                            break;
                        case 11:
                            currentRank = Rank.KING;
                            break;
                        case 12:
                            currentRank = Rank.ACE;
                            break;
                    }
                    this.cards.add(new CardImpl(currentSuit, currentRank));
                }
            }
        }
    }

    public int getNumCards() {
        return this.numCards;
    }

    public void shuffle() {
        for (int i = 0; i < this.isCardDealt.size(); i++) {
            this.isCardDealt.set(i, false);
        }
        this.numCards = 52;
    }

    public boolean canDealCard(int index) {
        return !isCardDealt.get(index);
    }

    public Card dealCard(int index) {
        this.isCardDealt.set(index, true);
        this.numCards--;
        return this.cards.get(index);
    }
}
