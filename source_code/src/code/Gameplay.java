package code;

import code.Command.Command;
import code.Command.Interpreter;
import code.character.Player;
import code.place.Place;

import java.util.List;
import java.util.Scanner;

public class Gameplay {

	public static final List<Command> commandList = Command.generateAllCommands();
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<Place> placeList = Place.generateAllPlaces();

		Player player = new Player("Benjapied Tablenuit", placeList.get(0));

		String[] commandTab;

		player.getPlace().getNpc().talk("Welcome to Gypsy's Carnival!\n" +
				"Type help to have the commands list");

		player.printHealth();
		player.printMoney();

		while (!player.getIsLose()) {
			System.out.print("[" + player.getName() + "] : ");

			commandTab = scanner.nextLine().split(" ");

			Command command = Interpreter.interpretCommand(commandList, commandTab);

			command.executeCommand(player, commandTab);
		}
	}
}