package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class HanoiTower extends Game {

    public HanoiTower(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public HanoiTower() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.HANOI_TOWER), Level.GOLD);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}