package code.place.game;

import code.enumeration.PlaceKey;
import code.place.Game;

public class Questions extends Game {

    public Questions(String name, String description) {
        super(name, description);
    }

    public Questions() {
        super("Questions", PlaceKey.getPlaceDescription(PlaceKey.QUESTIONS));
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