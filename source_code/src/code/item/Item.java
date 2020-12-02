package code.item;

import code.Interface.Describable;
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

	public void use(Player player) {
		player.loseMoney(this.price);
	}

	public abstract void printItem();

	public void buy(Player player) {
		player.loseMoney(this.price);
	}

}