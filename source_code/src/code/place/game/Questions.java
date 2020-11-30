package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class Questions extends Game {

    public Questions(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Questions() {
        this("Questions",
                "TODO : description",
                new NPC("Samuel Outienne"),
                Level.PLATINUM);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}