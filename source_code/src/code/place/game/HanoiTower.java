package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

public class HanoiTower extends Game {

    public HanoiTower(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public HanoiTower() {
        this("Hanoi tower",
                "TODO : description",
                new NPC("Geoffrey Kofred"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        System.out.println("Game launched");
    }
}