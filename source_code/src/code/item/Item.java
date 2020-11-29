package code.item;

import code.Interface.Describable;
import code.character.Player;

public abstract class Item implements Describable {

	private final String name;
	private String description;
	private final int price;

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

	public String getDescription() {
		return description;
	}

	// OTHER METHODS

	@Override
	public void readDescription() {
		System.out.println(this.getDescription());
	}

	public void use() {
	}
	public void printItem(){
	}

	public void buy(Player player) {
	}

}