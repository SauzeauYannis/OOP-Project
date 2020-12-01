package code;

import code.Command.Command;
import code.Command.Interpreter;
import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;
import code.place.Place;

import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

public class Gameplay {

	public static final List<Command> commandList = Command.generateAllCommands();
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		EnumMap<PlaceKey, Game> gameMap = Game.generateAllGames();

		EnumMap<PlaceKey, Place> placeMap = Place.generateAllPlaces(gameMap);

		Player player = new Player("Benjapied Tablenuit", placeMap.get(PlaceKey.CARNIVAL));

		String[] commandTab;

		player.getPlace().getNpc().talk("Welcome to Gypsy's Carnival!\n" +
				"Type help to have the commands list");

		while (!player.getIsLose()) {
			System.out.print("[" + player.getName() + "] : ");

			commandTab = scanner.nextLine().split(" ");

			Command command = Interpreter.interpretCommand(commandList, commandTab);

			command.executeCommand(player, commandTab);
		}
	}
}