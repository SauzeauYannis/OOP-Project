package code.item;

public class Food extends Item {

	private int calorie;

	// CONSTRUCTOR

	public Food(String name, int price, int calorie) {
		super(name, price);
		this.calorie = calorie;
		this.setDescription("TYPE: Food - " + this.getName() + "\t| INTAKE: +" + this.calorie + " to HP");
	}

	// GETTER

	public int getCalorie() {
		return this.calorie;
	}


	// METHODS

	@Override
	public void printItem() {
		System.out.print("OBJECT: " + this.getName() + "\t| PRICE: " + this.getPrice() + " coins \t| INTAKE: +" + this.getCalorie() + " to HP");
	}
}