package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Hangman extends Game {

    public Hangman(String name, String description) {
        super(name, description);
    }

    public Hangman() {
        super("Hangman", PlaceKey.getPlaceDescription(PlaceKey.HANGMAN));
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}