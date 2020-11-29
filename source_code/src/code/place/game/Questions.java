package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Questions extends Game {

    public Questions(String name, String description, Level level) {
        super(name, description, level);
    }

    public Questions() {
        super("Questions", PlaceKey.getPlaceDescription(PlaceKey.QUESTIONS), Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}