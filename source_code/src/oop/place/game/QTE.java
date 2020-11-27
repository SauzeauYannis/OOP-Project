package oop.place.game;

import oop.character.NPC;
import oop.place.Game;

public class QTE extends Game {

    public QTE(NPC npc, String name) {
        super(npc, name);
    }

    public QTE(NPC npc) {
        super(npc, "QTE");
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