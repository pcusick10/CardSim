public interface BlackJack {
    
    public Person getDealer();

    public Player[] getPlayers();

    public Player getCurrentPlayer();

    public void setCurrentPlayer(Player player);

    public int getNumDecks();

    public void shuffle();
    
}
