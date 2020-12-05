package code.place;

import code.command.Interpreter;
import code.enumeration.Level;
import code.item.Food;
import code.item.Key;
import code.other.Describable;
import code.character.NPC;
import code.enumeration.ExitKey;
import code.exit.Exit;
import code.place.game.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

// This class implements an interface to force use a description
public class Place implements Describable {

	/*****************************
	 * Attributes and constructor
	 *****************************/

	// Attributes
	private final String name;
	private final String description;
	private final NPC npc;
	private final List<Exit> exitList;

	// Constructor
	public Place(String name, String description, NPC npc) {
		this.name = name;
		this.description = description;
		this.npc = npc;
		this.exitList = new ArrayList<>();
	}

	/**********
	 * Methods
	 **********/

	// Getters
	public String getName() {
		return this.name;
	}

	public NPC getNpc() {
		return this.npc;
	}

	public List<Exit> getExitList() {
		return this.exitList;
	}

	// Setters
	public void addExit(Exit exit) {
		this.exitList.add(exit);
	}

	// Override the method of Describable interface
	@Override
	public void readDescription() {
		System.out.println(this.description);
	}

	// To print the place next to the place
	public void printExitsPlace() {
		List<Exit> exitList = this.exitList;

		System.out.println("You can go to :");
		// Print each place of the exit in the exit list attribute
		for (Exit exit : exitList) {
			Place place = exit.getPlace();
			System.out.print("- " + place.getName());
			if (exit.isLock()) {
				System.out.println(" [lock]");
			} else {
				System.out.println(" [unlock]");
			}
		}

		// Print a advice to help the player
		String hintPlace = exitList.get(0).getPlace().getName();
		System.out.println("Try to typing \"go " +
				Interpreter.getFirstWord(hintPlace) +
				"\" to go to " +
				hintPlace
		);
	}

	// This method generate all places to return a list of them
	public static List<Place> generateAllPlaces() {
		List<Place> placeList = new ArrayList<>();

		NPC npcMain = new NPC("Gesui'hun Guyde");

		// Create instance of each place and add to the list
		placeList.add(new Place("Carnival",
						"This is the principal place of the carnival",
						npcMain));

		placeList.add(new Place("Copper hub",
						"This is the place where you can choose to go to a copper Game",
						npcMain));
		placeList.add(new Place("Gold hub",
						"This is the place where you can choose to go to a gold Game",
						npcMain));
		placeList.add(new Place("Platinum hub",
						"This is the place where you can choose to go to a platinum Game",
						npcMain));

		NPC npcShop = new NPC("Gesui'hun Von Deur");

		Shop keyShop = new Shop("Key shop",
				"This is the place where you can buy key to unlock the different games.\n",
				npcShop);
		keyShop.addItem(new Key("Copper key", 25, Level.COPPER));
		keyShop.addItem(new Key("Gold key", 50, Level.GOLD));
		keyShop.addItem(new Key("Platinum key", 100, Level.PLATINUM));
		placeList.add(keyShop);

		Shop foodShop = new Shop("Food shop",
				"This is the place where you can buy some food, like ChocoPipe.\n",
				npcShop);
		foodShop.addItem(new Food("Apple candy", 5, 5));
		foodShop.addItem(new Food("Cotton candy", 10, 15));
		foodShop.addItem(new Food("Chocolate eclair", 15, 20));
		placeList.add(foodShop);

		placeList.add(new FindNumber());
		placeList.add(new Hangman());
		placeList.add(new HanoiTower());
		placeList.add(new Karaoke());
		placeList.add(new QTE());
		placeList.add(new Questions());
		placeList.add(new Riddle());
		placeList.add(new RockPaperScissors());
		placeList.add(new TicTacToe());

		// Generate the exits
		EnumMap<ExitKey, Exit> exitEnumMap = Exit.generateAllExits(placeList);

		// Add exits to :

		// - Carnival
		placeList.get(0).addExit(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		placeList.get(0).addExit(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		placeList.get(0).addExit(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		placeList.get(0).addExit(exitEnumMap.get(ExitKey.EXIT_KEY_SHOP));
		placeList.get(0).addExit(exitEnumMap.get(ExitKey.EXIT_FOOD_SHOP));

		// - Copper hub
		placeList.get(1).addExit(exitEnumMap.get(ExitKey.EXIT_ROCK_PAPER_SCISSORS));
		placeList.get(1).addExit(exitEnumMap.get(ExitKey.EXIT_FIND_NUMBER));
		placeList.get(1).addExit(exitEnumMap.get(ExitKey.EXIT_QTE));
		placeList.get(1).addExit(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// - Gold hub
		placeList.get(2).addExit(exitEnumMap.get(ExitKey.EXIT_TIC_TAC_TOE));
		placeList.get(2).addExit(exitEnumMap.get(ExitKey.EXIT_RIDDLE));
		placeList.get(2).addExit(exitEnumMap.get(ExitKey.EXIT_HANOI_TOWER));
		placeList.get(2).addExit(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// - Platinum hub
		placeList.get(3).addExit(exitEnumMap.get(ExitKey.EXIT_QUESTIONS));
		placeList.get(3).addExit(exitEnumMap.get(ExitKey.EXIT_KARAOKE));
		placeList.get(3).addExit(exitEnumMap.get(ExitKey.EXIT_HANGMAN));
		placeList.get(3).addExit(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// - Shop
		placeList.get(4).addExit(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// - Rock paper scissors
		placeList.get(12).addExit(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		// - Find number
		placeList.get(5).addExit(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		// - QTE
		placeList.get(9).addExit(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));

		// - Tic Tac Toe
		placeList.get(13).addExit(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		// - Riddle
		placeList.get(11).addExit(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		// - Hanoi tower
		placeList.get(7).addExit(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));

		// - Questions
		placeList.get(10).addExit(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		// - Karaoke
		placeList.get(8).addExit(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		// - Hangman
		placeList.get(6).addExit(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));

		return placeList;
	}
}