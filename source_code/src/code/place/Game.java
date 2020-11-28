package code.place;

import code.enumeration.Level;

public abstract class Game extends Place {

	private Level level;
	private int difficulty;

	public Game(String name, String description) {
		super(name, description);
	}

	public abstract void play();

	public abstract void win();

	public abstract void lose();
}