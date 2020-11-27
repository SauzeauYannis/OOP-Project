package oop.place;

import oop.character.NPC;
import oop.item.Item;

import java.util.*;

public class Shop extends Place {

	private Collection<Item> items;

	public Shop(NPC npc, String name) {
		super(npc, name);
	}

	@Override
	public void readDescription() {

	}

	@Override
	public void setDescription(String description) {

	}
}