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
                description = "TODO : description";
                break;
            case COPPER_HUB:
                description = "TODO : description";
                break;
            case GOLD_HUB:
                description = "TODO : description";
                break;
            case PLATINUM_HUB:
                description = "TODO : description";
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
