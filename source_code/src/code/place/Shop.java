package code.place;

import code.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Place {

	private List<Item> items;

	public Shop(String name) {
		super(name);
		this.items = new ArrayList<>();
	}

	public Shop() {
		super("Shop");
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