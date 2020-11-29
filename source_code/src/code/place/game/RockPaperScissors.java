package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class RockPaperScissors extends Game {

    public RockPaperScissors(String name, String description, Level level) {
        super(name, description, level);
    }

    public RockPaperScissors() {
        super("Rock paper and scissors", PlaceKey.getPlaceDescription(PlaceKey.ROCK_PAPER_SCISSORS), Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}