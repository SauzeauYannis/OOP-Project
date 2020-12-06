package code.place;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;

public abstract class Game extends Place {

	public static int NB_GAMES = 0;
	private static final int COPPER_REWARD = 25;
	private static final int GOLD_REWARD = 50;
	private static final int PLATINUM_REWARD = 100;

	private Level level;
	private int reward;
	private boolean firstTime;

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
		this.firstTime = true;
		NB_GAMES++;
	}

	public Level getLevel() {
		return this.level;
	}

	public abstract void play(Player player);

	public void win(Player player, int money) {
		System.out.println("| You win a " +
				this.level.toString().toLowerCase() +
				" game!");

		System.out.println("| Here are " +
				money +
				" coins to reward you!");

		player.earnMoney(money);

		if(this.firstTime){
			player.increaseGameFinished();
			this.firstTime = false;
		}
	}

	public void win(Player player) {
		int money = (int)(Math.random()*this.reward) + 2;
		win(player, money);
	}

	public void lose(Player player) {
		int losingCalories = 10 + (int)(Math.random()*10);
		System.out.println("| You lose a " +
				this.level.toString().toLowerCase() +
				" game!");
		System.out.println("| You lose " + losingCalories + "calorie!");
		player.decreaseHealth(losingCalories);
	}
}