package oop.place;

import oop.Level;
import oop.character.NPC;

public abstract class Game extends Place {

	private Level level;
	private int difficulty;

	public Game(NPC npc, String name) {
		super(npc, name);
	}

	public void play() {
		// TODO - implement oop.place.Game.play
		throw new UnsupportedOperationException();
	}

	public void win() {
		// TODO - implement oop.place.Game.win
		throw new UnsupportedOperationException();
	}

	public void lose() {
		// TODO - implement oop.place.Game.lose
		throw new UnsupportedOperationException();
	}

}