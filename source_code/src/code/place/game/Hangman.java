package code.place.game;

import code.character.NPC;
import code.place.Game;

public class Hangman extends Game {

    public Hangman(NPC npc, String name) {
        super(npc, name);
    }

    public Hangman(NPC npc) {
        super(npc, "Hangman");
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