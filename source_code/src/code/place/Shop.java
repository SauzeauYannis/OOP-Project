package code.place;

import code.enumeration.Level;
import code.item.Food;
import code.item.Item;

import java.util.ArrayList;
import java.util.List;


public class Shop extends Place {

	private List<Item> items;

	// ABOUT FOOD ITEMS:
	protected static final String APPLE_CANDY = "Apple candy";
	protected static final String COTTON_CANDY = "Cotton candy";
	protected static final String CHOC_TUBE = "Chocolate eclair";
	protected static final int PRICE_AC = 5;
	protected static final int PRICE_CC = 10;
	protected static final int PRICE_CT = 15;
	protected static final int CAL_AC = 5;
	protected static final int CAL_CC = 15;
	protected static final int CAL_CT = 20;

	// ABOUT KEY ITEMS:
	protected static final String KEY = "key";
	protected static final Level CU = Level.COPPER;
	protected static final Level AU = Level.GOLD;
	protected static final Level PT = Level.PLATINUM;
	protected static final int PRICE_CU = 25;
	protected static final int PRICE_AU = 50;
	protected static final int PRICE_PT = 100;

	public Shop(String name, String description) {
		super(name, description);
		this.items = new ArrayList<>();

		this.items.add(new Food(APPLE_CANDY, PRICE_AC,CAL_AC));
		this.items.add(new Food(COTTON_CANDY, PRICE_CC,CAL_CC));
		this.items.add(new Food(CHOC_TUBE, PRICE_CT,CAL_CT));

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