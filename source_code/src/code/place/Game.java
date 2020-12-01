package code.place;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.game.*;

import java.util.EnumMap;

public abstract class Game extends Place {

	private Level level;
	// private int difficulty;

	public Game(String name, String description, NPC npc) {
		super(name, description, npc);
	}

	public Game(String name, String description, NPC npc, Level level) {
		this(name, description, npc);
		this.level = level;
	}

	public Level getLevel() {
		return this.level;
	}

	public abstract void play(Player player);

	public void win(Player player, int money) {
		System.out.println("You win a " +
				this.level.toString().toLowerCase() +
				" game");
		System.out.println("Here are " +
				money +
				" coins to reward you");
		player.earnMoney(money);
	}

	public void lose(Player player) {
		System.out.println("You lose a " +
				this.level.toString().toLowerCase() +
				" game");
		System.out.println("You lose 10 calorie");
		player.decreaseHealth(10);
	}

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