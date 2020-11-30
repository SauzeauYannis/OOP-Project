package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class RockPaperScissors extends Game {

    public RockPaperScissors(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public RockPaperScissors() {
        this("Rock paper scissors",
                "TODO : description",
                new NPC("Pierre Dupuis"),
                Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}