public interface Deck {

    public boolean canDealCard(int index);

    public Card dealCard(int index);

    public void shuffle();
}
