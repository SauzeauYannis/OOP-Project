package code.exit;

import code.enumeration.ExitKey;
import code.place.Place;

import java.util.EnumMap;
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

	public static EnumMap<ExitKey, Exit> generateAllExits(List<Place> placeList) {
		EnumMap<ExitKey, Exit> exitEnumMap = new EnumMap<>(ExitKey.class);

		int counter = 0;
		boolean isLock = false;

		for (ExitKey exit: ExitKey.values()) {
			// Mettre le if en commentaire pour unlock toutes les portes
			//if (counter > 5) isLock = true;
			exitEnumMap.put(exit,
					new Exit(placeList.get(counter), isLock));
			counter++;
		}

		return exitEnumMap;
	}

}