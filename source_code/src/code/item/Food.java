package code.item;

public class Food extends Item {

	private final int calorie;

	// CONSTRUCTOR

	public Food(String name, int price, int calorie) {
		super(name,
				price,
				"TYPE: Food - " + name + "\t| INTAKE: +" + calorie + " to HP");
		this.calorie = calorie;
	}

	// GETTER

	public int getCalorie() {
		return this.calorie;
	}


	// OTHER METHODS

	@Override
	public void printItem() {
		System.out.println("TYPE: FOOD\t| OBJECT: " + this.getName() + "\t| PRICE: " + this.getPrice() + " coins \t| INTAKE: +" + this.getCalorie() + " to HP");
	}
}