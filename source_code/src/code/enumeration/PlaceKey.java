package code.enumeration;

public enum PlaceKey {

    CARNIVAL,
    COPPER_HUB,
    GOLD_HUB,
    PLATINUM_HUB,
    SHOP,
    FIND_NUMBER,
    HANGMAN,
    HANOI_TOWER,
    KARAOKE,
    QTE,
    QUESTIONS,
    RIDDLE,
    ROCK_PAPER_SCISSORS,
    TIC_TAC_TOE;

    public static String[] getPlaceAttribute(PlaceKey placeKey) {
        String[] attribute = new String[2];
        switch (placeKey) {
            case CARNIVAL:
                attribute[0] = "Carnival";
                attribute[1] = "This is the principal place of the carnival";
                break;
            case COPPER_HUB:
                attribute[0] = "Copper hub";
                attribute[1] = "This is the place where you can choose to go to a copper Game";
                break;
            case GOLD_HUB:
                attribute[0] = "Gold hub";
                attribute[1] = "This is the place where you can choose to go to a gold Game";
                break;
            case PLATINUM_HUB:
                attribute[0] = "Platinum hub";
                attribute[1] = "This is the place where you can choose to go to a platinum Game";
                break;
            case SHOP:
                attribute[0] = "Shop";
                attribute[1] = "This is the place where you can buy some food, like ChocoPipe";
                break;
            case FIND_NUMBER:
                attribute[0] = "Find Number";
                attribute[1] = "TODO : description";
                break;
            case HANGMAN:
                attribute[0] = "Hangman";
                attribute[1] = "TODO : description";
                break;
            case HANOI_TOWER:
                attribute[0] = "Hanoi tower";
                attribute[1] = "TODO : description";
                break;
            case KARAOKE:
                attribute[0] = "Karaoke";
                attribute[1] = "TODO : description";
                break;
            case QTE:
                attribute[0] = "QTE";
                attribute[1] = "TODO : description";
                break;
            case QUESTIONS:
                attribute[0] = "Questions";
                attribute[1] = "TODO : description";
                break;
            case RIDDLE:
                attribute[0] = "Riddle";
                attribute[1] = "TODO : description";
                break;
            case ROCK_PAPER_SCISSORS:
                attribute[0] = "Rock paper scissors";
                attribute[1] = "TODO : description";
                break;
            default:
                attribute[0] = "Tic Tac Toe";
                attribute[1] = "TODO : description";
        }
        return attribute;
    }
}
