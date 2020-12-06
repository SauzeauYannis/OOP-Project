package code.character;

import code.command.Interpreter;
import code.item.Item;
import code.place.Ending;
import code.place.Game;
import code.place.Place;
import code.exit.Exit;
import code.place.Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player extends Character {

	/// Constants ///

	static final int MAX_HEALTH = 100;
	static final int DEFAULT_MONEY = 50;


	/// Attributes ///

	private Place cur_place;
	private final List<Item> items;
	private int health;

	private int money;
	private boolean isLose;

	private int gamesFinished;


	/// Methods ///

	public Player(String name, Place p, int money) {
		super(name);
		this.cur_place = p;
		this.health = MAX_HEALTH;
		this.money = money;
		this.items = new ArrayList<>();
		this.isLose = false;
		this.gamesFinished = 0;
	}

	public Player(String name, Place p) {
		this(name, p, DEFAULT_MONEY);
	}

	private void lose(){
		this.isLose = true;
	}

	public void printHealth() {
		System.out.println("| You have " +
				this.health +
				"/" +
				MAX_HEALTH +
				" calories.");
	}

	public void printMoney() {
		System.out.println("| You have " +
				this.money +
				" coins.");
	}

	public void printGames() {
		System.out.println("| You have finish " +
				this.gamesFinished + "/" + Game.NB_GAMES +
				" games.");
	}

	public void printInventory() {
		if (this.items.isEmpty()) {
			System.out.println("| You haven't anything in your inventory!\n" +
					"| Go to the shop to buy items.");
		} else {
			this.items.sort(Comparator.comparing(Item::getName));
			System.out.println("| In you inventory you have :");
			for (Item item: this.items) {
				System.out.println("-" + item.getName());
			}
		}
	}

	public boolean increaseHealth(int health) {
		if (this.health == MAX_HEALTH) {
			System.out.println("| You're calorie are always at max");
			return false;
		}
		else if (this.health + health >= MAX_HEALTH){
			this.health = MAX_HEALTH;
		}
		else{
			this.health += health;
		}
		printHealth();
		return true;
	}

	public void decreaseHealth(int health) {
		this.health -= health;
		if(this.health <= 0){
			this.lose();
		} else {
			printHealth();
		}
	}

	public void earnMoney(int money) {
		this.money += money;
		printMoney();
	}

	public void loseMoney(int money) {
		if(this.money - money <= 0){
			this.money = 0;
		}
		else{
			this.money -= money;
		}
		printMoney();
	}

	public boolean goToPlace(String location) {
		for (Exit exit: this.cur_place.getExitList()) {
			Place place = exit.getPlace();
			String placeName = place.getName();
			if (location.equals(Interpreter.getFirstWord(placeName))) {
				if (exit.isLock()) {
					if (place instanceof Game) {
						Game game = (Game) place;
						String level = game.getLevel().toString();
						System.out.println("| You can't go to " +
								placeName +
								", this game is lock!\n" +
								"| If you have a " +
								level +
								" key in your inventory, type \"use " +
								level +
								"\" to unlock the first lock game.\n" +
								"| Else go to the shop to buy it.");
					} else if (place instanceof Ending) {
						System.out.println("You don't know why but this place attracts you but it's lock.\n" +
								"Try to type \"unlock sparkling\" to to get inside.");
					}
				} else {
					place.getNpc().talk("Welcome to " + placeName + "!");
					changePlace(place);
				}
				return true;
			}
		}
		return false;
	}

	private void changePlace(Place place){
		this.cur_place = place;
		if (place instanceof Shop) {
			Shop shop = (Shop) place;
			shop.printItemsList();
		} else if (place instanceof Ending) {
			Ending ending = (Ending) place;
			ending.credit();
		}
	}

	public void playGame() {
		if (this.cur_place instanceof Game) {
			Game game = (Game) this.cur_place;
			game.play(this);
		} else {
			System.out.println("| You are not in a game");
		}
	}

	public void addItem(Item item) {
		int price = item.getPrice();
		if (price > this.money) {
			System.out.println("| You haven't any money to buy this item");
		} else {
			this.items.add(item);
			System.out.println("| " + item.getName() +
					" is now in your inventory.");
			this.loseMoney(price);
		}
	}

	public void removeItem(Item item) {
		this.items.remove(item);
		System.out.println("| You have lose one " +
				item.getName().toLowerCase());
	}

	public void increaseGameFinished(){
		this.gamesFinished += 1;
		printGames();
	}

	/// Accessors ///

	public Place getPlace(){
		return this.cur_place;
	}

	public boolean getIsLose(){
		return this.isLose;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public int getGamesFinished(){
		return this.gamesFinished;
	}
}