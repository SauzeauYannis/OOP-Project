package code.item;

import code.enumeration.Level;

public class Key extends Item {

	private Level level;

	public Key(String name, String description, int price) {
		super(name, description, price);
	}

	@Override
	public void readDescription() {

	}

	@Override
	public void setDescription(String description) {

	}
}