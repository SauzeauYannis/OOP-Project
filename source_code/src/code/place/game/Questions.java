package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Questions extends Game {

    public Questions(String name, String description) {
        super(name, description);
    }

    public Questions() {
        super("Questions", PlaceKey.getPlaceDescription(PlaceKey.QUESTIONS));
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}