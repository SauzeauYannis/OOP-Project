package code.place;

import code.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Place {

	private List<Item> items;

	// ABOUT FOOD ITEMS:
	private static final String APPLE_CANDY = "Apple candy";
	private static final String COTTON_CANDY = "Cotton candy";
	private static final String CHOC_TUBE = "Chocolate eclair";
	private static final int PRICE_AC = 5;
	private static final int PRICE_CC = 10;
	private static final int PRICE_CT = 15;
	private static final int CAL_CT = 5;
	private static final int CAL_CC = 15;
	private static final int CAL_CT = 20;


	public Shop(String name) {
		super(name);
		this.items = new ArrayList<>();
	}

	public Shop() {
		super("Shop", "This is the place where you can buy some food, like ChocoPipe");
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