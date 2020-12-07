package code.item;

import code.character.Player;
import code.enumeration.Level;
import code.exit.Exit;
import code.place.Game;
import code.place.Place;

public class Key extends Item {

	/*****************************
	 * Attributes and constructor
	 *****************************/

	//ATTRIBUTES
	final private Level level;

	// CONSTRUCTOR
	public Key(String name, int price, Level level) {
		super(name,
				price,
				"TYPE: KEY\t| OBJECT: " +
						name +
						"\t| PRICE: " +
						price +
						" coins \t| USE: Unlock a " +
						level.toString() +
						" game.");
		this.level = level;
	}

	/**********
	 * Methods
	 **********/

	// GETTER
	public Level getLevel() {
		return this.level;
	}

	// OVERRIDE METHODS
	@Override
	public void use(Player player) {
		Place nextPlace = player.getPlace().getExitList().get(1).getPlace();
		if (nextPlace instanceof Game) {
			Game game = (Game) nextPlace;
			if (this.level == game.getLevel()) {
				for (Exit exit: player.getPlace().getExitList()) {
					if (exit.isLock()) {
						exit.unlock();
						player.removeItem(this);
						return;
					}
				}
				System.out.println("All games are always unlock");
			} else {
				System.out.println("You haven't a " +
						this.level.toString() +
						" key.\nGo to the shop to buy one");
			}
		} else {
			System.out.println("You need to be in front of the game to unlock it");
		}
	}
}