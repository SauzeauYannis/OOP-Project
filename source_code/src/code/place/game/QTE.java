package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class QTE extends Game {

    public QTE(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public QTE() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.QTE), Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}