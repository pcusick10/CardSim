public class BlackJackImpl implements BlackJack{

    private int numDecks;
    private Deck[] decks;
    private Player[] players;
    private Person dealer;
    private Player currentPlayer;
    
    public BlackJackImpl(Player[] players, Deck[] decks, Person dealer) {
        this.numDecks = decks.length;
        this.decks = decks;
        this.players = players;
        this.dealer = dealer;
    }

    public Person getDealer(){
        return this.dealer;
    }

    public Player[] getPlayers(){
        return this.players;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }

    public int getNumDecks(){
        return this.numDecks;
    }

    public void shuffle(){
        for (Deck d : this.decks){
            d.shuffle();
        }
    }
}
