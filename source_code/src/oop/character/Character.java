package oop.character;

import oop.place.Place;

public abstract class Character{

	/// Attributes ///

	private final String name;


	/// Methods ///

	public Character(String name){
		this.name = name;
	}


	/// Accessors ///

	public String getName() {
		return this.name;

	}
}