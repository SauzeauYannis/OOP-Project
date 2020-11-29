package code.place;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.game.*;

import java.util.EnumMap;
import java.util.Scanner;

public abstract class Game extends Place {

	private Level level;
	private int difficulty;

	public Game(String name, String description) {
		super(name, description);
	}

	public abstract void play(Player p, Scanner scanner);

	public abstract void win(Player p);

	public abstract void lose(Player p);

	public static EnumMap<PlaceKey, Game> generateAllGames() {
		EnumMap<PlaceKey, Game> gameEnumMap = new EnumMap<>(PlaceKey.class);

		gameEnumMap.put(PlaceKey.FIND_NUMBER,
				new FindNumber());
		gameEnumMap.put(PlaceKey.HANGMAN,
				new Hangman());
		gameEnumMap.put(PlaceKey.HANOI_TOWER,
				new HanoiTower());
		gameEnumMap.put(PlaceKey.KARAOKE,
				new Karaoke());
		gameEnumMap.put(PlaceKey.QTE,
				new QTE());
		gameEnumMap.put(PlaceKey.QUESTIONS,
				new Questions());
		gameEnumMap.put(PlaceKey.RIDDLE,
				new Riddle());
		gameEnumMap.put(PlaceKey.ROCK_PAPER_SCISSORS,
				new RockPaperScissors());
		gameEnumMap.put(PlaceKey.TIC_TAC_TOE,
				new TicTacToe());

		return gameEnumMap;
	}
}