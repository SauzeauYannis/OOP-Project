package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

public class Karaoke extends Game {

    public Karaoke(String name, String description) {
        super(name, description);
    }

    public Karaoke() {
        super("Karaoke", PlaceKey.getPlaceDescription(PlaceKey.HANOI_TOWER));
    }

    @Override
    public void play(Player p) {
        System.out.println("Game launched");
    }

    @Override
    public void win(Player p) {
        System.out.println("You win!");
    }

    @Override
    public void lose(Player p) {
        System.out.println("You lose!");
    }

    @Override
    public void readDescription() {

    }

    @Override
    public void setDescription(String description) {

    }
}