package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class TicTacToe extends Game {

    public TicTacToe(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public TicTacToe() {
        this("Tic Tac Toe",
                "TODO : description",
                new NPC("Sagrat opubice"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        System.out.println("--- Game launched ---");
    }
}