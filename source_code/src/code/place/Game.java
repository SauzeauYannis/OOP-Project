package code.place;

import code.character.Player;
import code.enumeration.Level;

public abstract class Game extends Place {

	private Level level;
	private int difficulty;

	public Game(String name, String description) {
		super(name, description);
	}

	public abstract void play(Player p);

	public abstract void win(Player p);

	public abstract void lose(Player p);
}