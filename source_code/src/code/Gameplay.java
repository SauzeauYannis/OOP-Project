package code;

import code.command.Command;
import code.command.Interpreter;
import code.character.Player;
import code.place.Place;

import java.util.List;
import java.util.Scanner;

public class Gameplay {

	public static final List<Command> commandList = Command.generateAllCommands();
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<Place> placeList = Place.generateAllPlaces();

		Player player = new Player("Benjapied Tablenuit", placeList.get(0), 1000);

		String[] commandTab;

		player.getPlace().getNpc().talk("Welcome to Gypsy's Carnival!\n" +
				"Type \"help\" to have the commands list");

		player.printHealth();
		player.printMoney();

		while (!player.getIsLose()) {
			System.out.println("Nombres de jeux finis : " + player.getGamesFinished());
			System.out.print(player);

			commandTab = scanner.nextLine().split(" ");

			Command command = Interpreter.interpretCommand(commandList, commandTab);

			command.executeCommand(player, commandTab);
		}
	}
}