package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class TicTacToe extends Game {

    public TicTacToe(String name, String description) {
        super(name, description);
    }

    public TicTacToe() {
        super("Tic Tac Toe", PlaceKey.getPlaceDescription(PlaceKey.TIC_TAC_TOE));
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}