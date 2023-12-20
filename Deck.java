public interface Deck {

    public int getNumCards();

    public boolean canDealCard(int index);

    public Card dealCard(int index);

    public void shuffle();
}
