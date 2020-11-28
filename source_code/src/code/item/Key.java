package code.item;

import code.enumeration.Level;

public class Key extends Item {

	final private Level level;

	// CONSTRUCTOR

	public Key(String name, int price, Level level) {
		super(name, price);
		this.level = level;
		this.setDescription("TYPE: Key - " + level.toString() + " " + this.getName() + "\t| USE: This key allows you to unlock a " + level.toString() + " game.");
	}

	// GETTER

	public Level getLevel() {
		return level;
	}

	// OTHER METHODS

	@Override
	public void printItem() {
		System.out.println("TYPE: KEY\t| OBJECT: " + this.getLevel().toString() + " "  + this.getName() + "\t| PRICE: " + this.getPrice() + " coins \t| USE: This key allows you to unlock a " + this.getLevel().toString() + " game.");
	}
}