package code.place;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;

public abstract class Game extends Place {

	private static final int COPPER_REWARD = 10;
	private static final int GOLD_REWARD = 20;
	private static final int PLATINUM_REWARD = 30;

	private Level level;
	private int reward;
	// private int difficulty;

	public Game(String name, String description, NPC npc) {
		super(name, description, npc);
	}

	public Game(String name, String description, NPC npc, Level level) {
		this(name, description, npc);
		this.level = level;
		switch (this.level) {
			case COPPER:
				this.reward = COPPER_REWARD;
				break;
			case GOLD:
				this.reward = GOLD_REWARD;
				break;
			default:
				this.reward = PLATINUM_REWARD;
		}
	}

	public Level getLevel() {
		return this.level;
	}

	public abstract void play(Player player);

	public void win(Player player) {
		int money = (int)(Math.random()*this.reward) + 2;

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