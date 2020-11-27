package oop.character;

import oop.place.Place;

public abstract class Character{

	/// Attributes ///

	private final String name;
	private Place place;


	/// Methods ///

	public Character(String name, Place p){
		this.name = name;
		this.place = p;
	}


	/// Accessors ///

	public String getName(){
		return this.name;
	}

	public Place getPlace(){
		return this.place;
	}

}