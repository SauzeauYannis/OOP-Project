package code.item;

import code.enumeration.Level;

public class Key extends Item {

	private Level level;

	// CONSTRUCTOR

	public Key(String name, int price, Level level) {
		super("Copper key", price);
		this.level = level;
		this.setDescription("TYPE: Key - " + level.toString() + " " + this.getName() + "\t| USE: This key allows you to unlock a " + level.toString() + " game.");
	}

	// GETTER

	public Level getLevel() {
		return level;
	}

	// METHODS

	@Override
	public void printItem() {
		System.out.print("OBJECT: " + level.toString() + " "  + this.getName() + "\t| PRICE: " + this.getPrice() + " coins \t| USE: This key allows you to unlock a " + level.toString() + " game.");
	}
}