package oop.place.game;

import oop.character.NPC;
import oop.place.Game;

public class Riddle extends Game {

    public Riddle(NPC npc, String name) {
        super(npc, name);
    }

    public Riddle(NPC npc) {
        super(npc, "Riddle");
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