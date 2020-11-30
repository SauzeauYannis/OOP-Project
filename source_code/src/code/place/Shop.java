package code.place;

import code.enumeration.Level;
import code.item.Food;
import code.item.Item;
import code.item.Key;
import code.place.game.Karaoke;

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

	// CONSTRUCTOR

	public Shop(String[] placeAttribute) {
		super(placeAttribute);
		this.items = new ArrayList<>();

		this.items.add(new Food(APPLE_CANDY, 1, PRICE_AC, CAL_AC));
		this.items.add(new Food(COTTON_CANDY, 1,PRICE_CC, CAL_CC));
		this.items.add(new Food(CHOC_TUBE, 1,PRICE_CT, CAL_CT));
		this.items.add(new Key(KEY, 1,PRICE_CU, CU));
		this.items.add(new Key(KEY, 1,PRICE_AC, AU));
		this.items.add(new Key(KEY, 1,PRICE_PT, PT));
	}

	// SETTERS

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void printItemsList() {
		System.out.println("Items available :");
		for (Item item: this.items) {
			item.printItem();
		}
	}
}