public interface BlackJack {
    
    public Person getDealer();

    public void setDealer(Person dealer);

    public Player[] getPlayers();

    public void setPlayers(Player[] players);

    public Player currentPlayer();

    public int getNumDecks();

    public void setNumDecks();
}
