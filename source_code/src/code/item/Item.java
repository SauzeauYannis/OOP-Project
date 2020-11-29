package code.item;

import code.Interface.Describable;
import code.character.Player;

public abstract class Item implements Describable {

	private final String name;
	private final int price;
	private int occurrence;
	private String description;

	public Item(String name, int price, int occurrence, String description) {
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

	public int getOccurrence() {
		return occurrence;
	}

	public String getDescription() {
		return description;
	}

	// OTHER METHODS

	@Override
	public void readDescription() {
		System.out.println(this.getDescription());
	}

	public void incrementOccurrence(){
		this.occurrence++;
	}

	public void decrementOccurrence(){
		this.occurrence--;
	}

	public void use(Player player) {
		player.loseMoney(this.price);
	}
	public void printItem(){
	}

	public void buy(Player player) {
		player.loseMoney(this.price);
	}

}