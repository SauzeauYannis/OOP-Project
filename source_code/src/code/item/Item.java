package code.item;

import code.other.Describable;
import code.character.Player;

public abstract class Item implements Describable {

	private final String name;
	private final int price;
	private final String description;

	public Item(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	// GETTERS

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	// OTHER METHODS

	@Override
	public void readDescription() {
		System.out.println(this.description);
	}

	public abstract void use(Player player);

	public void printItem() {
		System.out.println("-" +
				this.getName() +
				" " +
				this.getPrice() +
				" coins.");
	}
}