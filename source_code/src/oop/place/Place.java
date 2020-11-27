package oop.place;

import oop.Describable;
import oop.character.NPC;
import oop.exit.Exit;
import oop.exit.ExitLocked;
import oop.exit.ExitOpened;

import java.util.*;

public abstract class Place implements Describable {

	private final List<Exit> exits;
	private final NPC npc;
	private final String name;
	private String description;

	public Place(NPC npc, String name) {
		this.npc = npc;
		this.name = name;
		this.exits = new ArrayList<>();
		this.addExits(new ExitOpened());
		this.addExits(new ExitLocked());
	}

	public String getName() {
		return this.name;
	}

	public void talkToNPC() {
		npc.talk();
	}

	private void addExits(Exit e) {
		this.exits.add(e);
	}
	
	private void printExitsPlace() {
		for (Exit e:
			 this.exits) {
			System.out.println(e); //place
		}
	}

	@Override
	public void readDescription() {
		System.out.println(this.description);
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}
}