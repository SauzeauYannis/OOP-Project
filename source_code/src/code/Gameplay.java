package code;

import code.character.NPC;
import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Place;

import java.util.EnumMap;

public class Gameplay {

	public static void main(String[] args) {

		EnumMap<PlaceKey, Place> placeMap = Place.generateAllPlaces();

		for (Place place: placeMap.values()) {
			place.setNpc(new NPC(place.getName() + " NPC"));
			System.out.println("Place : " + place.getName());
			System.out.println("NPC name is : " + place.getNpc().getName());
		}

		Player player = new Player("Benjapied Tablenuit", placeMap.get(PlaceKey.CARNIVAL));
		System.out.println("Your name is : " + player.getName());
		System.out.println("You are at : " + player.getPlace().getName());
		player.getPlace().printExitsPlace();
		player.changePlace(placeMap.get(PlaceKey.COPPER_HUB));
		player.getPlace().printExitsPlace();
	}

}