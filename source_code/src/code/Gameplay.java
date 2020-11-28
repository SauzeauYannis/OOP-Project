package code;

import code.character.NPC;
import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Place;

import java.util.EnumMap;

public class Gameplay {

	public static void main(String[] args) {

        Player player = new Player("Benjapied Tablenuit", null);
        System.out.println("Your name is : " + player.getName());

		EnumMap<PlaceKey, Place> placeMap = Place.generateAllPlaces();

		for (Place place: placeMap.values()) {
			place.setNpc(new NPC(place.getName() + " NPC"));
			System.out.println(place.getName());
			System.out.println(place.getNpc().getName());
		}
	}

}