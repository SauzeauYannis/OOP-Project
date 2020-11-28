package code.place.game;

import code.enumeration.PlaceKey;
import code.place.Game;

public class HanoiTower extends Game {

    public HanoiTower(String name, String description) {
        super(name, description);
    }

    public HanoiTower() {
        super("Hanoi Tower", PlaceKey.getPlaceDescription(PlaceKey.HANOI_TOWER));
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