package code.enumeration;

import code.exit.Exit;

public enum ExitKey {
    EXIT_CARNIVAL,
    EXIT_COPPER_HUB,
    EXIT_GOLD_HUB,
    EXIT_PLATINUM_HUB,
    EXIT_SHOP,
    EXIT_FIND_NUMBER,
    EXIT_HANGMAN,
    EXIT_HANOI_TOWER,
    EXIT_KARAOKE,
    EXIT_QTE,
    EXIT_QUESTIONS,
    EXIT_RIDDLE,
    EXIT_ROCK_PAPER_SCISSORS,
    EXIT_TIC_TAC_TOE,
    EXIT_UNKNOWN;

    public static ExitKey stringToExitkey(String s){
        ExitKey eKey;
        switch(s){
            case "carnival":
                eKey = ExitKey.EXIT_CARNIVAL;
                break;
            case "copper_hub":
                eKey = ExitKey.EXIT_COPPER_HUB;
                break;
            case "gold_hub":
                eKey = ExitKey.EXIT_GOLD_HUB;
                break;
            case "platinum_hub":
                eKey = ExitKey.EXIT_PLATINUM_HUB;
                break;
            case "shop":
                eKey = ExitKey.EXIT_SHOP;
                break;
            case "find_number":
                eKey = ExitKey.EXIT_FIND_NUMBER;
                break;
            case "hangman":
                eKey = ExitKey.EXIT_HANGMAN;
                break;
            case "hanoi_tower":
                eKey = ExitKey.EXIT_HANOI_TOWER;
                break;
            case "karaoke":
                eKey = ExitKey.EXIT_KARAOKE;
                break;
            case "qte":
                eKey = ExitKey.EXIT_QTE;
                break;
            case "questions":
                eKey = ExitKey.EXIT_QUESTIONS;
                break;
            case "riddle":
                eKey = ExitKey.EXIT_RIDDLE;
                break;
            case "rock_paper_scissors":
                eKey = ExitKey.EXIT_ROCK_PAPER_SCISSORS;
                break;
            case "tic_tac_toe":
                eKey = ExitKey.EXIT_TIC_TAC_TOE;
                break;
            default:
                eKey = ExitKey.EXIT_UNKNOWN;
        }
        return eKey;
    }

}
