package code.item;

import code.Interface.Describable;
import code.character.Player;

public abstract class Item implements Describable {

	private String name;
	private String description;
	private int price;

	public Item(String name, String description, int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	// GETTER
	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	// METHODS
	public void use() {

	}

	public void printItem(){
		System.out.print(this.getName() + "\t| Price: " + this.price + " coins");
	}

	public void buy(Player player) {

	}

}