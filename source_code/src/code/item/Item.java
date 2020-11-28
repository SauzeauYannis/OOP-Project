package code.item;

import code.Interface.Describable;
import code.character.Player;

public abstract class Item implements Describable {

	private String name;
	private String description;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
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

	// SETTERS

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	// METHODS

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