package code.item;

public class Food extends Item {

	private final int calorie;

	// CONSTRUCTOR

	public Food(String name, int price, int calorie) {
		super(name,
				price,
				"TYPE: FOOD\t| OBJECT: " +
						name +
						"\t| PRICE: " +
						price +
						" coins \t| USE: +" +
						calorie +
						" to calorie");
		this.calorie = calorie;
	}

	// GETTER

	public int getCalorie() {
		return this.calorie;
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