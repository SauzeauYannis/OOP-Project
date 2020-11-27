package oop.character;

import oop.item.Item;

import java.util.*;

public class Player extends Character {

	private Collection<Item> items;
	private int health;
	private int money;

	/**
	 * @param name
	 */
	public Player(String name) {
		super(name);
	}

	/**
	 * 
	 * @param health
	 */
	public void increaseHealth(int health) {
		// TODO - implement oop.character.Player.increaseHealth
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param health
	 */
	public void decreaseHealth(int health) {
		// TODO - implement oop.character.Player.decreaseHealth
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param money
	 */
	public void earnMoney(int money) {
		// TODO - implement oop.character.Player.earnMoney
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param money
	 */
	public void loseMoney(int money) {
		// TODO - implement oop.character.Player.loseMoney
		throw new UnsupportedOperationException();
	}

}