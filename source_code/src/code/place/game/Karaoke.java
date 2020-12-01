package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

public class Karaoke extends Game {

    public Karaoke(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Karaoke() {
        this("Karaoke",
                "TODO : description",
                new NPC("Kharra Okey"),
                Level.PLATINUM);
    }

    @Override
    public void play(Player player) {
        System.out.println("Game launched");
    }
}