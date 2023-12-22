public interface Player extends Person {

    public int getStack();

    public void setStack(int stack);

    public int getCurrentBet();

    public void setCurrentBet(int currentBet);

    public boolean isBusted();

    public boolean getIsIn();

    public boolean checkBlackjack();
}