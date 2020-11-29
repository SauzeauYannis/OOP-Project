package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class Riddle extends Game {

    public Riddle(String name, String description) {
        super(name, description);
    }

    public Riddle() {
        super("Riddle", PlaceKey.getPlaceDescription(PlaceKey.QUESTIONS));
    }

    @Override
    public void play(Player p, Scanner scanner) {
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