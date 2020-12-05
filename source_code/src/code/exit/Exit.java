package code.exit;

import code.place.Game;
import code.place.Place;

import java.util.ArrayList;
import java.util.List;

public class Exit {

	private final Place place;
	private boolean isLock;

	public Exit(Place place, boolean isLock) {
		this.place = place;
		this.isLock = isLock;
	}

	public Place getPlace() {
		return place;
	}

	public boolean isLock() {
		return isLock;
	}

	public void unlock() {
		isLock = false;
		String place = this.place.getName();
		System.out.println(place +
				" is now unlock.\n" +
				"Type \"go " +
				place.split(" ")[0].toLowerCase() +
				"\" to play this game!");
	}

	public static List<Exit> generateAllExits(List<Place> placeList) {
		List<Exit> exitList = new ArrayList<>();
		boolean isLock;

		for (Place place: placeList) {
			isLock = place instanceof Game;

			exitList.add(new Exit(place, isLock));
		}

		return exitList;
	}

}