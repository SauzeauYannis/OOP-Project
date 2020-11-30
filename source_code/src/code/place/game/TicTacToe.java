package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class TicTacToe extends Game {

    public TicTacToe(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public TicTacToe() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.TIC_TAC_TOE), Level.GOLD);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}