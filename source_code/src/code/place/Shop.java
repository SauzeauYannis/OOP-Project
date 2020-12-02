package code.place;

import code.character.NPC;
import code.enumeration.Level;
import code.item.Food;
import code.item.Item;
import code.item.Key;

import java.util.ArrayList;
import java.util.List;


public class Shop extends Place {

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
	protected static final String CU_Key = "Copper key";
	protected static final String AU_Key = "Gold key";
	protected static final String PT_Key = "Platinum key";
	protected static final Level CU = Level.COPPER;
	protected static final Level AU = Level.GOLD;
	protected static final Level PT = Level.PLATINUM;
	protected static final int PRICE_CU = 25;
	protected static final int PRICE_AU = 50;
	protected static final int PRICE_PT = 100;

	private final List<Item> items;

	public List<Item> getItems() {
		return this.items;
	}

	// CONSTRUCTOR

	public Shop() {
		super("Shop",
				"This is the place where you can buy some food, like ChocoPipe.\n" +
				"To have more information about one item, type \"look <item>\" (Example: look apple for information about apple candy).\n" +
				"To buy an item, type \"take <item>\" (Example: take copper to buy a copper key).",
				new NPC("Gesui'hun Von Deur"));
		this.items = new ArrayList<>();

		this.items.add(new Food(APPLE_CANDY, PRICE_AC, CAL_AC));
		this.items.add(new Food(COTTON_CANDY, PRICE_CC, CAL_CC));
		this.items.add(new Food(CHOC_TUBE, PRICE_CT, CAL_CT));
		this.items.add(new Key(CU_Key, PRICE_CU, CU));
		this.items.add(new Key(AU_Key, PRICE_AU, AU));
		this.items.add(new Key(PT_Key, PRICE_PT, PT));
	}

	public void printItemsList() {
		this.getNpc().talk("Here are items available in my shop:");
		for (Item item: this.items) {
			item.printItem();
		}
		this.getNpc().talk("Type \"look\" for more information");
	}
}