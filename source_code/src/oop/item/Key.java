package oop.item;

import oop.Level;

public class Key extends Item implements Buyable {

	private Level level;
	private int price;

	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public void buy() {

	}
}