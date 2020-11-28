package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

public class QTE extends Game {

    public QTE(String name, String description) {
        super(name, description);
    }

    public QTE() {
        super("QTE", PlaceKey.getPlaceDescription(PlaceKey.QTE));
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