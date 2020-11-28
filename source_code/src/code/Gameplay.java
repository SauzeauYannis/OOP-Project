package code;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Command;
import code.enumeration.PlaceKey;
import code.place.Place;

import java.util.EnumMap;
import java.util.Scanner;

public class Gameplay {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EnumMap<PlaceKey, Place> placeMap = Place.generateAllPlaces();

		Player player = new Player("Benjapied Tablenuit", placeMap.get(PlaceKey.CARNIVAL));

		Command command;

		while (!player.getIsLose()) {
			System.out.println("Type something :");
			command = Command.stringToCommand(scanner.next());
			player.execCommand(command, scanner);
		}

/*		for (Place place: placeMap.values()) {
			place.setNpc(new NPC(place.getName() + " NPC"));
			System.out.println("Place : " + place.getName());
			System.out.println("NPC name is : " + place.getNpc().getName());
		}

		Player player = new Player("Benjapied Tablenuit", placeMap.get(PlaceKey.CARNIVAL));
		System.out.println("Your name is : " + player.getName());
		System.out.println("You are at : " + player.getPlace().getName());
		player.getPlace().printExitsPlace();
		player.changePlace(placeMap.get(PlaceKey.COPPER_HUB));
		player.getPlace().printExitsPlace();*/
	}

}