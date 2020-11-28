package code.place.game;

import code.character.NPC;
import code.place.Game;

public class FindNumber extends Game {

    public FindNumber(String name, String description) {
        super(name, description);
    }

    public FindNumber() {
        super("Find number", "TODO - faire the description");
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