import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to CardSim! (Blackjack)");
        Person d = new PersonImpl("Dealer");
        BlackJack game = new BlackJackImpl(initializePlayers(s), initializeDecks(s), d);
        System.out.println("Starting...");
        boolean playerStillIn = true;
        while (playerStillIn) {
            System.out.println("How much would you like to bet?");
            initialBetting(game.getPlayers(), s);
            deal(game.getPlayers(), d, game.getDecks(), 2);
            game.printTable();

            playerStillIn = false;
            for (Player p : game.getPlayers()) {
                if (p.getIsIn()) {
                    playerStillIn = true;
                    break;
                }
            }
        }

    }

    public static Player[] initializePlayers(Scanner s) {

        System.out.print("How many players would you like? ");
        boolean invalidNum = true;
        int numPlayers = 0;
        while (invalidNum) {
            numPlayers = s.nextInt();
            if (0 < numPlayers || 7 > numPlayers) {
                invalidNum = false;
            } else {
                System.out.print("Please answer using a number from 1-6. ");
                numPlayers = s.nextInt();
            }
        }

        Player[] players = new Player[numPlayers];
        int i = 0;
        String name = "";
        while (i < numPlayers) {
            System.out.print("What will be the name of Player " + (i + 1) + "? ");
            boolean invalidName = true;
            while (invalidName) {
                name = s.nextLine();
                if (!name.trim().isEmpty()) {
                    invalidName = false;
                } else {
                    System.out.print("Invalid name, please so not use empty names, try again. ");
                }
            }
            players[i] = new PlayerImpl(name);
            i++;
        }

        return players;
    }

    public static Deck[] initializeDecks(Scanner s) {

        System.out.print("How many decks would you like to play with? ");
        int numDecks = 0;
        boolean invalidNum = true;
        while (invalidNum) {
            numDecks = s.nextInt();
            if (0 < numDecks || 7 > numDecks) {
                invalidNum = false;
            } else {
                System.out.print("Please answer using a number from 1-6. ");
                numDecks = s.nextInt();
            }
        }

        Deck[] decks = new Deck[numDecks];
        int i = 0;
        while (i < numDecks) {
            decks[i] = new DeckImpl();
            i++;
        }

        return decks;
    }

    public static void deal(Player[] players, Person dealer, Deck[] decks, int numCards) {
        for (Player p : players) {
            int i = 0;
            while (i < numCards) {
                p.addCard(randomCardGenerator(decks));
                i++;
            }
        }
        int j = 0;
        while (j < numCards) {
            dealer.addCard(randomCardGenerator(decks));
            j++;
        }
    }

    public static Card randomCardGenerator(Deck[] decks) {
        int numDecks = decks.length;
        while (true) {
            int randomDeck = (int) (numDecks * Math.random());
            int randdomCard = (int) (52 * Math.random());
            if (decks[randomDeck].canDealCard(randdomCard)) {
                return decks[randomDeck].dealCard(randdomCard);
            }
        }
    }

    public static void initialBetting(Player[] players, Scanner s) {
        for (Player p : players) {
            System.out.print(p.getName() + ": ");
            p.setCurrentBet(s.nextInt());
            System.out.print("\n");
        }
    }

    public static void playerActions(BlackJack b, Scanner s) {
        for (Player p : b.getPlayers()) {
            if (p.checkBlackjack()) {
                System.out.println("BLACKJACK BABY!!!");
            } else {
                System.out.print(p.getName() + ", would you like to hit(H) or stand(S)? ");
                boolean isValid = false;
                String action = "";
                while (!isValid) {
                    action = s.nextLine();
                    if (action.equals("H") || action.equals("S")) {
                        isValid = true;
                    } else {
                        System.out.print("Invalid response, try again to hit(H) or stand(S). ");
                    }
                }
                switch (action) {
                    case "H":
                        p.addCard(randomCardGenerator(b.getDecks()));
                        break;
                    case "S":
                        break;
                }
                if (p.isBusted()) {

                }
            }

        }
    }

    public static void hit(Player p) {
        p.addCard(randomCardGenerator(null));
    }
}