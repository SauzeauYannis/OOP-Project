package oop.item;

import oop.Describable;

public abstract class Item implements Describable {

	private String name;
	private String description;

	public String getName() {
		return this.name;
	}

	public void use() {
		// TODO - implement oop.item.Item.use
		throw new UnsupportedOperationException();
	}

}