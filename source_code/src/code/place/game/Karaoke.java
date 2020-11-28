package code.place.game;

import code.character.NPC;
import code.place.Game;

public class Karaoke extends Game {

    public Karaoke(NPC npc, String name) {
        super(npc, name);
    }

    public Karaoke(NPC npc) {
        super(npc, "Karaoke");
    }

    @Override
    public void play() {
        System.out.println("Game launched");
    }

    @Override
    public void win() {
        System.out.println("You win!");
    }

    @Override
    public void lose() {
        System.out.println("You lose!");
    }

    @Override
    public void readDescription() {

    }

    @Override
    public void setDescription(String description) {

    }
}