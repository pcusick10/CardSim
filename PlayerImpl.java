import java.util.ArrayList;

public class PlayerImpl implements Player {

    private ArrayList<Card> cards;
    private String name;
    private int stack;
    private int currentBet;
    private boolean isIn;

    public PlayerImpl(String name, int stack) {
        this.cards = new ArrayList<>();
        this.name = name;
        this.stack = stack;
        this.isIn = true;
    }

    public PlayerImpl(String name) {
        this(name, 10000);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    };

    public void addCard(Card card) {
        this.cards.add(card);
    };

    public String getName() {
        return this.name;
    };

    public int getStack() {
        return this.stack;
    };

    public void setStack(int stack) {
        this.stack = stack;
    };

    public int getCurrentBet() {
        return this.currentBet;
    };

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    };

    public boolean isBusted() {
        if (this.checkValue() > 21) {
            return true;
        }
        return false;
    }

    public boolean getIsIn() {
        return this.isIn;
    }

    public int checkValue(){
        int value = 0;
        int aces = 0;
        for (Card c : this.cards){
            switch (c.getRank()) {
                case Rank.TWO:
                    value += 2;
                    break;
                case Rank.THREE:
                    value += 3;
                    break;
                case Rank.FOUR:
                    value += 4;
                    break;
                case Rank.FIVE:
                    value += 5;
                    break;
                case Rank.SIX:
                    value += 6;
                    break;
                case Rank.SEVEN:
                    value += 7;
                    break;
                case Rank.EIGHT:
                    value += 8;
                    break;
                case Rank.NINE:
                    value += 9;
                    break;
                case Rank.TEN:
                    value += 10;
                    break;
                case Rank.JACK:
                    value += 10;
                    break;
                case Rank.QUEEN:
                    value += 10;
                    break;
                case Rank.KING:
                    value += 10;
                    break;
                case Rank.ACE:
                    aces++;
                    break;
            }
        }
        if (aces == 0){
            return value;
        }
        else {
            int elevens = aces;
            int ones = 0;
            while (elevens >= 0) {
                if (((11*elevens) + (ones) + value) <= 21){
                    return ((11*elevens) + (ones) + value);
                }
            }
            return value + aces;
        }
    }

    public boolean checkBlackjack(){
        if (this.cards.size() == 2 && this.checkValue() == 21){
            return true;
        }
        return false;
    }
}
