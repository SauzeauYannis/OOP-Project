package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Hangman extends Game {

    public Hangman(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public Hangman() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.HANGMAN), Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}