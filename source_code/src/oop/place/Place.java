package oop.place;

import oop.Describable;
import oop.character.NPC;
import oop.exit.Exit;

import java.util.*;

public abstract class Place implements Describable {

	private Collection<Exit> exits;
	private NPC npc;
	private String name;
	private String description;

	public String getName() {
		return this.name;
	}

}