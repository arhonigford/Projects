import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Uno {

    /**
     * nPlayers: Number of players in the game
     * player: Current Player
     * playerHand[][]: List of Players and their hands
     * currentCard: Keeps track of the card on top of the discard pile
     * CARDS_IN_DECK: Total cards in the deck
     * START_HAND: Initial hand size
     * direction: Direction of the play
     * winner: Stores the winner of game
     */
    public static int nPlayers;
    public static int currentPlayer;
    public static UnoCard playerHand[][];
    public static UnoCard currentCard;
    public static final int CARDS_IN_DECK = 112;
    public static final int START_HAND = 7;
    public static boolean direction = true; // true for regular direction, false for reverse direction
    public static int winner;

    /**
     * @param nPlayers
     */
    public Uno(int nPlayers) {
        playerHand = new UnoCard[nPlayers][CARDS_IN_DECK];
        currentPlayer = 0;
        this.nPlayers = nPlayers;
        currentCard = new UnoCard();

    }

    /**
     *
     */
    public static void distributeCards() {
        for (int i = 0; i < nPlayers; i++) {
            for (int j = 0; j < START_HAND; j++) {
                playerHand[i][j] = new UnoCard();
            }
        }
    }

    /**
     * @param p
     * @param idx
     */
    public static void removeCardFromHand(int p, int idx) {

        int endIndex = cardsLeft(p);
        for (int i = idx; i < endIndex; i++) {
            playerHand[p][i] = playerHand[p][i + 1];
        }
        playerHand[p][endIndex-1] = null;
    }

    /**
     * @param p
     */
    public static void printHandOfPlayer(int p) {
        System.out.println("Player " + (currentPlayer + 1) + "'s Hand:");
        int count = 1;
        for (UnoCard u : playerHand[p]) {
            if (u == null)
                break;
            System.out.println(count + ": " + u.color + " " + u.card);
            count++;
        }
        System.out.println("0: Draw a card | Skip turn");
    }

    /**
     * @param p
     * @return
     */
    public static int cardsLeft(int p) {
        int index = 0;
        while (playerHand[p][index] != null)
            index++;
        return index;
    }

    /**
     *
     */
    public static void handleWild(Scanner s) {
        while(true) {
            System.out.println("Color changes to?");
            System.out.println("1. Red" + "\n" + "2. Green" + "\n" + "3. Yellow" + "\n" + "4. Blue");
            String ans = s.nextLine();
            if (ans.equals("1")) {
                currentCard.color = COLOR.RED;
                break;
            } else if (ans.equals("2")) {
                currentCard.color = COLOR.GREEN;
                break;
            } else if (ans.equals("3")) {
                currentCard.color = COLOR.YELLOW;
                break;
            } else if (ans.equals("4")) {
                currentCard.color = COLOR.BLUE;
                break;
            }
        }
    }

    /**
     *
     */
    public static void nextPlayer() {
        if (direction) {
            if (currentPlayer == nPlayers - 1)
                currentPlayer = 0;
            else
                currentPlayer++;
        } else {
            if (currentPlayer == 0)
                currentPlayer = nPlayers - 1;
            else
                currentPlayer--;
        }
    }

    /**
     *
     */
    public static void handleWildDraw4(Scanner s) {
        handleWild(s);
        int index = 0;

        nextPlayer();
        while (playerHand[currentPlayer][index] != null)
                index++;
        System.out.println("Player " + (currentPlayer + 1) + " must draw 4 cards!");
        playerHand[currentPlayer][index] = new UnoCard();
        playerHand[currentPlayer][index + 1] = new UnoCard();
        playerHand[currentPlayer][index + 2] = new UnoCard();
        playerHand[currentPlayer][index + 3] = new UnoCard();
        nextPlayer();



    }

    /**
     *
     */
    public static void handleSkip() {
        nextPlayer();
        System.out.println("Player " + (currentPlayer + 1) + "'s turn has been skipped!");
        nextPlayer();

    }

    /**
     *
     */
    public static void handleReverse() {
        System.out.println("The game has been reversed!");
        if (direction)
            direction = false;
        else
            direction = true;
    }

    /**
     *
     */
    public static void handleDraw2() {
        int index = 0;
        System.out.println("Player " + printNextPlayer(currentPlayer) + " has to draw 2 cards!");
        while (playerHand[printNextPlayer(currentPlayer) - 1][index] != null)
            index++;
        playerHand[printNextPlayer(currentPlayer) - 1][index] = new UnoCard();
        playerHand[printNextPlayer(currentPlayer) - 1][index + 1] = new UnoCard();
        nextPlayer();

    }

    public static int printNextPlayer(int cPlayer) {
        if (direction) {
            if (cPlayer == nPlayers - 1)
                cPlayer = 0;
            else
                cPlayer++;
        } else {
            if (cPlayer == 0)
                cPlayer = nPlayers - 1;
            else
                cPlayer--;
        }
        return cPlayer + 1;
    }

    public static int PreviousPlayer() {
        int previousPlayer = 0;
        if (direction) {
            if (currentPlayer == nPlayers - 1)
                previousPlayer = 0;
            else
                previousPlayer++;
        } else {
            if (currentPlayer == 0)
                previousPlayer = nPlayers - 1;
            else
                previousPlayer--;
        }
        return previousPlayer;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean done = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players are there?");
        nPlayers = scan.nextInt();
        scan.nextLine();
        Uno uno = new Uno(nPlayers);
        System.out.println();
        System.out.println("Shuffling and Adding Cards to Hands..." + "\n");
        distributeCards();
        System.out.println("First Card: ");
        UnoCard firstCard = new UnoCard();
        while (firstCard.isWild() || firstCard.isWildDraw4() || firstCard.isSkip() || firstCard.isReverse() || firstCard.isDraw2())
            firstCard = new UnoCard();
        currentCard = firstCard;
        System.out.println(currentCard.color + " " + currentCard.card + "\n");
        int count = 0;
        int pass = 0;
        while (!done) {
            if (count != 0 && (!currentCard.isSkip())) {
                System.out.println("Current Card:");
                System.out.println(currentCard.color + " " + currentCard.card + "\n");
            }
            count++;
            printHandOfPlayer(currentPlayer);
            System.out.println();
            System.out.println("Your choice?");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 0) {
                if (pass == 0) {
                    int index = 0;
                    while (playerHand[currentPlayer][index] != null)
                        index++;
                    playerHand[currentPlayer][index] = new UnoCard();
                }
                else {
                    pass = -1;
                    nextPlayer();
                }
                pass++;
            } else {
                UnoCard u = playerHand[currentPlayer][choice - 1];
                removeCardFromHand(currentPlayer,choice - 1);
                if (currentCard.isPlayable(u)) {
                    if (u.isDraw2()) {
                        handleDraw2();
                        currentCard = u;
                        System.out.println("Played " + u.color + " " + u.card);
                    } else if (u.isReverse()) {
                        handleReverse();
                        currentCard = u;
                        System.out.println("Played " + u.color + " " + u.card);
                    } else if (u.isSkip()) {
                        handleSkip();
                        currentCard = u;
                    } else if (u.isWild()) {
                        currentCard = u;
                        System.out.println("Played " + u.card);
                        handleWild(scan);
                    } else if (u.isWildDraw4()) {
                        currentCard = u;
                        System.out.println("Played " + u.card);
                        handleWildDraw4(scan);
                    } else {
                        System.out.println("Played " + u.color + " " + u.card);
                        currentCard = u;
                    }
                    System.out.println();
                    if (currentCard.isSkip() || currentCard.isWildDraw4()) {
                        if (playerHand[PreviousPlayer()][0] == null) {
                            winner = currentPlayer;
                            System.out.println("Player " + winner + " wins!");
                            done = true;
                        }
                    }
                    else {
                        if (playerHand[currentPlayer][0] == null) {
                            winner = currentPlayer + 1;
                            System.out.println("Player " + winner + " wins!");
                            done = true;
                        }
                        nextPlayer();
                    }
                    pass = 0;
                } else {
                    System.out.println("INVALID CHOICE!");
                }
            }


        }

    }

}
