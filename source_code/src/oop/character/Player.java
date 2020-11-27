package oop.character;

import oop.item.Item;
import oop.place.Place;

import java.util.*;

public class Player extends Character {

	static final int MAX_HEALTH = 100;
	static final int DEFAULT_MONEY = 10;

	private List<Item> items;
	private int health;
	private int money;
	private boolean isLose;

	public Player(String name, Place p) {
		super(name, p);
		this.health = MAX_HEALTH;
		this.money = DEFAULT_MONEY;
		this.items = new ArrayList<>();
		this.isLose = false;
	}

	public void increaseHealth(int health) {
		if(this.health + health >= MAX_HEALTH){
			this.health = MAX_HEALTH;
		}
		else{
			this.health += health;
		}
	}

	public void decreaseHealth(int health) {
		this.health -= health;
		if(this.health <= 0){
			this.lose();
		}
	}

	public void earnMoney(int money) {
		this.money += money;
	}

	public void loseMoney(int money) {
		if(this.money - money <= 0){
			this.money = 0;
		}
		else{
			this.money -= money;
		}
	}

	public void lose(){
		this.isLose = true;
	}
}