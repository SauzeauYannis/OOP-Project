package code.item;

public class Food extends Item {

	private int calorie;

	public Food(String name, String description, int price) {
		super(name, description, price);
	}


	public int getCalorie() {
		return this.calorie;
	}

	@Override
	public void readDescription() {

	}

	@Override
	public void setDescription(String description) {

	}

	@Override
	public void printItem() {
		super.printItem();

	}
}