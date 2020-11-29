package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Karaoke extends Game {

    public Karaoke(String name, String description) {
        super(name, description);
    }

    public Karaoke() {
        super("Karaoke", PlaceKey.getPlaceDescription(PlaceKey.HANOI_TOWER));
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}