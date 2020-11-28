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

    public static String getPlaceDescription(PlaceKey placeKey) {
        String description;
        switch (placeKey) {
            case CARNIVAL:
                description = "This is the principal place of the carnival";
                break;
            case COPPER_HUB:
                description = "This is the place where you can choose to go to a copper Game";
                break;
            case GOLD_HUB:
                description = "This is the place where you can choose to go to a gold Game";
                break;
            case PLATINUM_HUB:
                description = "This is the place where you can choose to go to a platinum Game";
                break;
            case SHOP:
                description = "TODO : description";
                break;
            case FIND_NUMBER:
                description = "TODO : description";
                break;
            case HANGMAN:
                description = "TODO : description";
                break;
            case HANOI_TOWER:
                description = "TODO : description";
                break;
            case KARAOKE:
                description = "TODO : description";
                break;
            case QTE:
                description = "TODO : description";
                break;
            case QUESTIONS:
                description = "TODO : description";
                break;
            case RIDDLE:
                description = "TODO : description";
                break;
            case ROCK_PAPER_SCISSORS:
                description = "TODO : description";
                break;
            default:
                description = "TODO : description";
        }
        return description;
    }
}
