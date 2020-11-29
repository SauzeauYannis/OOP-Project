package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class QTE extends Game {

    public QTE(String name, String description, Level level) {
        super(name, description, level);
    }

    public QTE() {
        super("QTE", PlaceKey.getPlaceDescription(PlaceKey.QTE), Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}