package code;

import code.command.Interpreter;
import code.character.Player;
import code.place.Place;

import java.util.List;
import java.util.Scanner;

// Main class of the program
public class Gameplay {

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<Place> placeList = Place.generateAllPlaces();

		Player player = new Player("Benjapied Tablenuit", placeList.get(7));

		player.getPlace().getNpc().talk("Welcome to Gypsy's Carnival!\n" +
				"Type \"help\" to have the commands list.");

		player.printHealth();
		player.printMoney();
		player.printGames();

		while (!player.getIsLose()) {
			System.out.print(player);

			Interpreter.interpretCommand(player, scanner.nextLine());
		}

		System.out.println("| Oh no you've have lose too much calories you can't continue!");
	}
}