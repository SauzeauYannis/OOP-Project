package code.place;

import code.Interface.Describable;
import code.character.NPC;
import code.enumeration.ExitKey;
import code.exit.Exit;
import code.place.game.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Place implements Describable {

	private final List<Exit> exitList;
	private NPC npc;
	private final String name;
	private final String description;

	public Place(String name, String description, NPC npc) {
		this.name = name;
		this.exitList = new ArrayList<>();
		this.description = description;
		this.npc = npc;
	}

	public List<Exit> getExitList() {
		return this.exitList;
	}

	public String getName() {
		return this.name;
	}

	public void setNpc(NPC npc) {
		this.npc = npc;
	}

	public NPC getNpc() {
		return this.npc;
	}

	private void addExits(Exit e) {
		this.exitList.add(e);
	}
	
	public void printExitsPlace() {
		System.out.println("You can go to :");
		for (Exit exit : this.exitList) {
			System.out.print("- " + exit.getPlace().getName());
			if (exit.isLock()) {
				System.out.println(" [lock]");
			} else {
				System.out.println(" [unlock]");
			}
		}
		String hintPlace = this.exitList.get(0).getPlace().getName();
		System.out.println("Try to typing \"go " +
				hintPlace.split(" ")[0].toLowerCase() +
				"\" to go to " +
				hintPlace
		);
	}

	public Exit getExit(int i){
		return this.exitList.get(i);
	}

	public int lengthExitList() {
		return this.exitList.size();
	}

	@Override
	public void readDescription() {
		System.out.println(this.description);
	}

	public static List<Place> generateAllPlaces() {
		List<Place> placeList = new ArrayList<>();

		NPC npc_main = new NPC("Gesui'hun Guyde");

		placeList.add(new Place("Carnival",
						"This is the principal place of the carnival",
						npc_main));

		placeList.add(new Place("Copper hub",
						"This is the place where you can choose to go to a copper Game",
						npc_main));
		placeList.add(new Place("Gold hub",
						"This is the place where you can choose to go to a gold Game",
						npc_main));
		placeList.add(new Place("Platinum hub",
						"This is the place where you can choose to go to a platinum Game",
						npc_main));
		placeList.add(new Shop());
		placeList.add(new FindNumber());
		placeList.add(new Hangman());
		placeList.add(new HanoiTower());
		placeList.add(new Karaoke());
		placeList.add(new QTE());
		placeList.add(new Questions());
		placeList.add(new Riddle());
		placeList.add(new RockPaperScissors());
		placeList.add(new TicTacToe());

		EnumMap<ExitKey, Exit> exitEnumMap = Exit.generateAllExits(placeList);

		// Carnival
		placeList.get(0).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		placeList.get(0).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		placeList.get(0).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		placeList.get(0).addExits(exitEnumMap.get(ExitKey.EXIT_SHOP));

		// Copper hub
		placeList.get(1).addExits(exitEnumMap.get(ExitKey.EXIT_ROCK_PAPER_SCISSORS));
		placeList.get(1).addExits(exitEnumMap.get(ExitKey.EXIT_FIND_NUMBER));
		placeList.get(1).addExits(exitEnumMap.get(ExitKey.EXIT_QTE));
		placeList.get(1).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// Gold hub
		placeList.get(2).addExits(exitEnumMap.get(ExitKey.EXIT_TIC_TAC_TOE));
		placeList.get(2).addExits(exitEnumMap.get(ExitKey.EXIT_RIDDLE));
		placeList.get(2).addExits(exitEnumMap.get(ExitKey.EXIT_HANOI_TOWER));
		placeList.get(2).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// Platinum hub
		placeList.get(3).addExits(exitEnumMap.get(ExitKey.EXIT_QUESTIONS));
		placeList.get(3).addExits(exitEnumMap.get(ExitKey.EXIT_KARAOKE));
		placeList.get(3).addExits(exitEnumMap.get(ExitKey.EXIT_HANGMAN));
		placeList.get(3).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// Shop
		placeList.get(4).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		// Rock paper scissors
		placeList.get(12).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		// Find number
		placeList.get(5).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		// QTE
		placeList.get(9).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));

		// Tic Tac Toe
		placeList.get(13).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		// Riddle
		placeList.get(11).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		// Hanoi tower
		placeList.get(7).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));

		// Questions
		placeList.get(10).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		// Karaoke
		placeList.get(8).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		// Hangman
		placeList.get(6).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));

		return placeList;
	}
}