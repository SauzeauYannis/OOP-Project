package code.exit;

import code.enumeration.ExitKey;
import code.enumeration.PlaceKey;
import code.place.Place;

import java.util.EnumMap;

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
		isLock = true;
	}

	public void printExit() {
		System.out.print("Exit to " + this.place.getName());
		if (this.isLock) {
			System.out.println(" lock");
		} else {
			System.out.println(" unlock");
		}
	}

	public static EnumMap<ExitKey, Exit> generateAllExits(EnumMap<PlaceKey, Place> placeEnumMap) {
		EnumMap<ExitKey, Exit> exitEnumMap = new EnumMap<>(ExitKey.class);

		exitEnumMap.put(ExitKey.EXIT_CARNIVAL,
				new Exit(placeEnumMap.get(PlaceKey.CARNIVAL), false));
		exitEnumMap.put(ExitKey.EXIT_COPPER_HUB,
				new Exit(placeEnumMap.get(PlaceKey.COPPER_HUB), false));
		exitEnumMap.put(ExitKey.EXIT_GOLD_HUB,
				new Exit(placeEnumMap.get(PlaceKey.GOLD_HUB), false));
		exitEnumMap.put(ExitKey.EXIT_PLATINUM_HUB,
				new Exit(placeEnumMap.get(PlaceKey.PLATINUM_HUB), false));
		exitEnumMap.put(ExitKey.EXIT_SHOP,
				new Exit(placeEnumMap.get(PlaceKey.SHOP), false));
		exitEnumMap.put(ExitKey.EXIT_FIND_NUMBER,
				new Exit(placeEnumMap.get(PlaceKey.FIND_NUMBER), false));
		exitEnumMap.put(ExitKey.EXIT_HANGMAN,
				new Exit(placeEnumMap.get(PlaceKey.HANGMAN), true));
		exitEnumMap.put(ExitKey.EXIT_HANOI_TOWER,
				new Exit(placeEnumMap.get(PlaceKey.HANOI_TOWER), true));
		exitEnumMap.put(ExitKey.EXIT_KARAOKE,
				new Exit(placeEnumMap.get(PlaceKey.KARAOKE), true));
		exitEnumMap.put(ExitKey.EXIT_QTE,
				new Exit(placeEnumMap.get(PlaceKey.QTE), true));
		exitEnumMap.put(ExitKey.EXIT_QUESTIONS,
				new Exit(placeEnumMap.get(PlaceKey.QUESTIONS), true));
		exitEnumMap.put(ExitKey.EXIT_RIDDLE,
				new Exit(placeEnumMap.get(PlaceKey.RIDDLE), true));
		exitEnumMap.put(ExitKey.EXIT_ROCK_PAPER_SCISSORS,
				new Exit(placeEnumMap.get(PlaceKey.ROCK_PAPER_SCISSORS), true));
		exitEnumMap.put(ExitKey.EXIT_TIC_TAC_TOE,
				new Exit(placeEnumMap.get(PlaceKey.TIC_TAC_TOE), true));

		return exitEnumMap;
	}

}