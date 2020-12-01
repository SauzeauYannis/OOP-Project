package code;

import code.character.Player;
import code.enumeration.Command;
import code.enumeration.PlaceKey;
import code.place.Game;
import code.place.Place;

import java.util.EnumMap;
import java.util.Scanner;

public class Gameplay {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EnumMap<PlaceKey, Game> gameMap = Game.generateAllGames();

		EnumMap<PlaceKey, Place> placeMap = Place.generateAllPlaces(gameMap);

		Player player = new Player("Benjapied Tablenuit", placeMap.get(PlaceKey.CARNIVAL));

		String[] commandTab;

		player.getPlace().getNpc().talk("Welcome to Gypsy's Carnival!\n" +
				"Type help to have the commands list");

		while (!player.getIsLose()) {
			System.out.print("[" + player.getName() + "] : ");

			commandTab = scanner.nextLine().split(" ");

			switch (Command.stringToCommand(commandTab[0])) {
				case GO:
					if (commandTab.length > 1) {
						if (!player.goToPlace(commandTab[1].toLowerCase())) {
							System.out.println("Please enter valid place !");
						}
					} else {
						player.getPlace().printExitsPlace();
					}
					break;
				case HELP:
					if (commandTab.length > 1) {
						Command.helpCommand(
								Command.stringToCommand(commandTab[1])
						);
					} else {
						Command.printCommands();
					}
					break;
				case LOOK:
					player.getPlace().readDescription();
					break;
				case TAKE:
					System.out.println("TODO : take command");
					break;
				case QUIT:
					System.exit(0);
					break;
				case USE:
					System.out.println("TODO : use command");
					break;
				case PLAY:
					boolean isGame = false;
					for (Game game: gameMap.values()) {
						if (player.getPlace().getName().equals(game.getName())) {
							isGame = true;
							player.playGame(game, scanner);
						}
					}
					if (!isGame) {
						System.out.println("This place is not a game");
					}
					break;
				default:
					System.out.println("Unknown command\n" +
							"Type help for have the command list");
			}
		}
	}
}