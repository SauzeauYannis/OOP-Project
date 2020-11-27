package code.place.game;

import code.character.NPC;
import code.place.Game;

public class RockPaperScissors extends Game {

    public RockPaperScissors(NPC npc, String name) {
        super(npc, name);
    }

    public RockPaperScissors(NPC npc) {
        super(npc, "Rock paper and scissord");
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