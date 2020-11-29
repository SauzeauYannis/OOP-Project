package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Karaoke extends Game {

    public Karaoke(String name, String description, Level level) {
        super(name, description, level);
    }

    public Karaoke() {
        super("Karaoke", PlaceKey.getPlaceDescription(PlaceKey.HANOI_TOWER), Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}