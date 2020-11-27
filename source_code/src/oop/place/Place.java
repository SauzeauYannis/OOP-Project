package oop.place;

import oop.Describable;
import oop.character.NPC;
import oop.exit.Exit;

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
	}

	public String getName() {
		return "Place : " + this.name;
	}

	public NPC getNpc() {
		return this.npc;
	}

	private void addExits(Exit e) {
		this.exits.add(e);
	}
	
	private void printExitsPlace() {
		for (Exit e:
			 this.exits) {
			System.out.println(e.getPlace().name); //place
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