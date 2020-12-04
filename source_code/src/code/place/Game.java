package code.place;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;

public abstract class Game extends Place {

	private Level level;
	private int reward;
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
}