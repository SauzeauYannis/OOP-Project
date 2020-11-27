package code.place;

import code.character.NPC;
import code.item.Item;

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