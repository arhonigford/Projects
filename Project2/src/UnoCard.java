import java.util.Random;

public class UnoCard {

    public COLOR color;
    public CARD card;

    public UnoCard() {
        Random rand = new Random();
        int num = rand.nextInt(15);
        int col = rand.nextInt(3);
        if (num == 0)
            card = CARD.ZERO;
        else if (num == 1)
            card = CARD.ONE;
        else if (num == 2)
            card = CARD.TWO;
        else if (num == 3)
            card = CARD.THREE;
        else if (num == 4)
            card = CARD.FOUR;
        else if (num == 5)
            card = CARD.FIVE;
        else if (num == 6)
            card = CARD.SIX;
        else if (num == 7)
            card = CARD.SEVEN;
        else if (num == 8)
            card = CARD.EIGHT;
        else if (num == 9)
            card = CARD.NINE;
        else if (num == 10)
            card = CARD.SKIP;
        else if (num == 11)
            card = CARD.REVERSE;
        else if (num == 12)
            card = CARD.DRAW_2;
        else if (num == 13)
            card = CARD.WILD;
        else if (num == 14)
            card = CARD.WILD_DRAW4;
        if (col == 0)
            color = COLOR.BLUE;
        else if (col == 1)
            color = COLOR.GREEN;
        else if(col == 2)
            color = COLOR.YELLOW;
        else
            color = COLOR.RED;

    }
    
     public UnoCard(CARD card, COLOR color) {
        this.card = card;
        this.color = color;
    }

    public boolean isWild() {
        if(card.equals(CARD.WILD))
            return true;
        return false;
    }

    public boolean isWildDraw4() {
        if(card.equals(CARD.WILD_DRAW4))
            return true;
        return false;
    }

    public boolean isDraw2() {
        if(card.equals(CARD.DRAW_2))
            return true;
        return false;
    }

    public boolean isReverse() {
        if(card.equals(CARD.REVERSE))
            return true;
        return false;
    }

    public boolean isSkip() {
        if(card.equals(CARD.SKIP))
            return true;
        return false;
    }

    public boolean isPlayable(UnoCard nextCard) {
        if (nextCard == null)
            return false;
        else if(nextCard.color.equals(color))
            return true;
        else if (nextCard.card.equals(card))
            return true;
        else if (nextCard.isWild())
            return true;
        else if (nextCard.isWildDraw4())
            return true;
        else
            return false;
    }

}
