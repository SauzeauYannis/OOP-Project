package code.place;

import code.character.NPC;
import code.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Place {

	private List<Item> items;

	public Shop(NPC npc, String name) {
		super(npc, name);
		this.items = new ArrayList<>();
	}

	public Shop(NPC npc) {
		super(npc, "Shop");
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void printItemsList() {
		System.out.println("Items available :");
		for (Item item: this.items) {
			System.out.println(item.getName());
		}
	}
}