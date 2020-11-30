package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class Riddle extends Game {

    public Riddle(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Riddle() {
        this("Riddle",
                "TODO : description",
                new NPC("Jean-Pierre Fougas"),
                Level.GOLD);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}