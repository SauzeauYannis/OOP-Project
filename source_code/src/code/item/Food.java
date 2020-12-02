package code.item;

import code.character.Player;

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

	// OTHER METHODS

	@Override
	public void use(Player player) {
		if (player.increaseHealth(this.calorie)) {
			player.removeItem(this);
		}
	}
}