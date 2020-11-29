package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Riddle extends Game {

    public Riddle(String name, String description, Level level) {
        super(name, description, level);
    }

    public Riddle() {
        super("Riddle", PlaceKey.getPlaceDescription(PlaceKey.QUESTIONS), Level.GOLD);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}