package code.item;

import code.enumeration.Level;

public class Key extends Item {

	final private Level level;

	// CONSTRUCTOR

	public Key(String name, int price, Level level) {
		super(name,
				price,
				"TYPE: KEY\t| OBJECT: " +
						name +
						"\t| PRICE: " +
						price +
						" coins \t| USE: Unlock a " +
						level.toString() +
						" game.");
		this.level = level;
	}

	// GETTER

	public Level getLevel() {
		return level;
	}

	// OTHER METHODS

	@Override
	public void printItem() {
		System.out.println("-" +
				this.getName() +
				" " +
				this.getPrice() +
				" coins.");
	}
}