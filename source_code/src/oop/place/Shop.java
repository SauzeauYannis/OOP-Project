package oop.place;

import oop.character.NPC;
import oop.item.Item;

import java.util.*;

public class Shop extends Place {

	private Collection<Item> items;

	public Shop(NPC npc, String name) {
		super(npc, name);
	}

	public Shop(NPC npc) {
		super(npc, "Shop");
	}
}