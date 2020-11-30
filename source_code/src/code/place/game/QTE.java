package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class QTE extends Game {

    public QTE(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public QTE() {
        this("QTE",
                "TODO : description",
                new NPC("Ethoufet Kwallah"),
                Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}