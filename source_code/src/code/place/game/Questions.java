package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Questions extends Game {

    public Questions(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public Questions() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.QUESTIONS), Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}