package code.place.game;

import code.enumeration.PlaceKey;
import code.place.Game;

public class RockPaperScissors extends Game {

    public RockPaperScissors(String name, String description) {
        super(name, description);
    }

    public RockPaperScissors() {
        super("Rock paper and scissors", PlaceKey.getPlaceDescription(PlaceKey.ROCK_PAPER_SCISSORS));
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