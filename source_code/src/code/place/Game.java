package code.place;

import code.enumeration.Level;
import code.character.NPC;

public abstract class Game extends Place {

	private Level level;
	private int difficulty;

	public Game(String name) {
		super(name);
	}

	public abstract void play();

	public abstract void win();

	public abstract void lose();

}