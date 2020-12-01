package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

public class Hangman extends Game {

    public Hangman(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Hangman() {
        this("Hangman",
                "TODO : description",
                new NPC("Marina Lependu"),
                Level.PLATINUM);
    }

    @Override
    public void play(Player player) {
        System.out.println("Game launched");
    }
}