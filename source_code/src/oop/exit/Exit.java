package oop.exit;

import oop.place.Place;

public abstract class Exit {

	private final Place place;
	private boolean isOpen;

	public Exit(Place place) {
		this.place = place;
		this.isOpen = false;
	}

	public void open() {
		// TODO - implement oop.exit.Exit.open
		this.isOpen = true;
	}

	public void close() {
		// TODO - implement oop.exit.Exit.close
		this.isOpen = false;
	}

	public void go() {
		// TODO - implement oop.exit.Exit.go
		// this.
	}


	public Place getPlace() {
		return place;
	}
}