import java.util.ArrayList;

public class PersonImpl implements Person{

    private String name;
    private ArrayList<Card> cards;

    public PersonImpl(String n){
        this.name = n;
        this.cards = new ArrayList<Card>();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }
}
