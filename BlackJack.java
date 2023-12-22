public interface BlackJack {
    
    public Person getDealer();

    public Player[] getPlayers();

    public Player getCurrentPlayer();

    public void setCurrentPlayer(Player player);

    public int getNumDecks();

    public Deck[] getDecks();

    public void shuffle();
    
    public void printTable();

    public void hit(Player player);

    public void stand(Player player);
}
