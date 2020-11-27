package oop.item;

public class Food extends Item implements Buyable {

	private int calorie;
	private int price;

	public int getCalorie() {
		return this.calorie;
	}

	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public void buy() {

	}

	@Override
	public void readDescription() {

	}

	@Override
	public void setDescription(String description) {

	}
}