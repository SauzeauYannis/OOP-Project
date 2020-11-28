package code.item;

import code.Interface.Describable;

public abstract class Item implements Describable {

	private String name;
	private String description;
	private int price;

	public String getName() {
		return this.name;
	}

	public void use() {
		// TODO - implement oop.item.Item.use
		throw new UnsupportedOperationException();
	}

	public int getPrice() {
		return this.price;
	}

	public void buy() {

	}

}