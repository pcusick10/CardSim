import java.util.ArrayList;

public class PlayerImpl implements Player{

    private ArrayList<Card> cards;
    private String name;
    private int stack;
    private int currentBet;

    public PlayerImpl(String name, int stack){
        this.name = name;
        this.stack = stack;
    }

    public PlayerImpl(String name){
        this(name, 10000);
    }
    
    public ArrayList<Card> getCards(){
        return this.cards;
    };

    public void addCard(Card card){
        this.cards.add(card);
    };

    public String getName(){
        return this.name;
    };

    public int getStack(){
        return this.stack;
    };

    public void setStack(int stack){
        this.stack = stack;
    };

    public int getCurrentBet(){
        return this.currentBet;
    };

    public void setCurrentBet(int currentBet){
        this.currentBet = currentBet;
    };
}
