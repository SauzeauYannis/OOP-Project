package code.character;

import code.enumeration.Command;
import code.enumeration.PlaceKey;
import code.item.Item;
import code.place.Game;
import code.place.Place;
import code.exit.Exit;
import code.place.game.FindNumber;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

public class Player extends Character {

	/// Constants ///

	static final int MAX_HEALTH = 100;
	static final int DEFAULT_MONEY = 10;


	/// Attributes ///

	private Place cur_place;
	private List<Item> items;
	private int health;
	private int money;
	private boolean isLose;


	/// Methods ///

	public Player(String name, Place p) {
		super(name);
		this.cur_place = p;
		this.health = MAX_HEALTH;
		this.money = DEFAULT_MONEY;
		this.items = new ArrayList<>();
		this.isLose = false;
	}

	private void lose(){
		this.isLose = true;
	}

	private void printHealth() {
		System.out.println("You have now " +
				this.health +
				" calories");
	}

	private void printMoney() {
		System.out.println("You have now " +
				this.money +
				" coins");
	}

	public void increaseHealth(int health) {
		if(this.health + health >= MAX_HEALTH){
			this.health = MAX_HEALTH;
		}
		else{
			this.health += health;
		}
		printHealth();
	}

	public void decreaseHealth(int health) {
		this.health -= health;
		if(this.health <= 0){
			this.lose();
		}
		printHealth();
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
			if (location.equals(exit.getPlace().getName().split(" ")[0].toLowerCase())) {
				if (exit.isLock()) {
					System.out.println("You can't go there, this place is closed !");
				} else {
					changePlace(exit.getPlace());
				}
				return true;
			}
		}
		return false;
	}

	private void changePlace(Place place){
		this.cur_place = place;
		System.out.println("You go to : " + place.getName());
	}

	public void playGame(Game game, Scanner scanner) {
		game.play(this, scanner);
		scanner.nextLine();
	}

	public void addItems(String name) {
	}

	/// Accessors ///

	public Place getPlace(){
		return this.cur_place;
	}

	public int getHealth(){
		return this.health;
	}

	public int getMoney(){
		return this.money;
	}

	public Item getItemPos(int i){
		return this.items.get(i);
	}

	public boolean getIsLose(){
		return this.isLose;
	}

}