package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Hangman extends Game {

    public Hangman(String name, String description, Level level) {
        super(name, description, level);
    }

    public Hangman() {
        super("Hangman", PlaceKey.getPlaceDescription(PlaceKey.HANGMAN), Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}