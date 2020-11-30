package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class RockPaperScissors extends Game {

    public RockPaperScissors(String[] placeAttribute, Level level) {
        super(placeAttribute, level);
    }

    public RockPaperScissors() {
        super(PlaceKey.getPlaceAttribute(PlaceKey.ROCK_PAPER_SCISSORS), Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        System.out.println("Game launched");
    }
}