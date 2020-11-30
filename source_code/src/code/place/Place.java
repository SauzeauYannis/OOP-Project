package code.place;

import code.Interface.Describable;
import code.character.NPC;
import code.enumeration.ExitKey;
import code.enumeration.PlaceKey;
import code.exit.Exit;

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

	public static EnumMap<PlaceKey, Place> generateAllPlaces(EnumMap<PlaceKey, Game> gameEnumMap) {
		EnumMap<PlaceKey, Place> placeEnumMap = new EnumMap<>(PlaceKey.class);

		NPC npc_main = new NPC("Gesui'hun Guyde");

		placeEnumMap.put(PlaceKey.CARNIVAL,
				new Place("Carnival",
						"This is the principal place of the carnival",
						npc_main));

		placeEnumMap.put(PlaceKey.COPPER_HUB,
				new Place("Copper hub",
						"This is the place where you can choose to go to a copper Game",
						npc_main));
		placeEnumMap.put(PlaceKey.GOLD_HUB,
				new Place("Gold hub",
						"This is the place where you can choose to go to a gold Game",
						npc_main));
		placeEnumMap.put(PlaceKey.PLATINUM_HUB,
				new Place("Platinum hub",
						"This is the place where you can choose to go to a platinum Game",
						npc_main));		placeEnumMap.put(PlaceKey.SHOP,
				new Shop());
		placeEnumMap.put(PlaceKey.FIND_NUMBER,
				gameEnumMap.get(PlaceKey.FIND_NUMBER));
		placeEnumMap.put(PlaceKey.HANGMAN,
				gameEnumMap.get(PlaceKey.HANGMAN));
		placeEnumMap.put(PlaceKey.HANOI_TOWER,
				gameEnumMap.get(PlaceKey.HANOI_TOWER));
		placeEnumMap.put(PlaceKey.KARAOKE,
				gameEnumMap.get(PlaceKey.KARAOKE));
		placeEnumMap.put(PlaceKey.QTE,
				gameEnumMap.get(PlaceKey.QTE));
		placeEnumMap.put(PlaceKey.QUESTIONS,
				gameEnumMap.get(PlaceKey.QUESTIONS));
		placeEnumMap.put(PlaceKey.RIDDLE,
				gameEnumMap.get(PlaceKey.RIDDLE));
		placeEnumMap.put(PlaceKey.ROCK_PAPER_SCISSORS,
				gameEnumMap.get(PlaceKey.ROCK_PAPER_SCISSORS));
		placeEnumMap.put(PlaceKey.TIC_TAC_TOE,
				gameEnumMap.get(PlaceKey.TIC_TAC_TOE));

		EnumMap<ExitKey, Exit> exitEnumMap = Exit.generateAllExits(placeEnumMap);

		placeEnumMap.get(PlaceKey.CARNIVAL).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		placeEnumMap.get(PlaceKey.CARNIVAL).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		placeEnumMap.get(PlaceKey.CARNIVAL).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		placeEnumMap.get(PlaceKey.CARNIVAL).addExits(exitEnumMap.get(ExitKey.EXIT_SHOP));

		placeEnumMap.get(PlaceKey.COPPER_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_ROCK_PAPER_SCISSORS));
		placeEnumMap.get(PlaceKey.COPPER_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_FIND_NUMBER));
		placeEnumMap.get(PlaceKey.COPPER_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_QTE));
		placeEnumMap.get(PlaceKey.COPPER_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		placeEnumMap.get(PlaceKey.GOLD_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_TIC_TAC_TOE));
		placeEnumMap.get(PlaceKey.GOLD_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_RIDDLE));
		placeEnumMap.get(PlaceKey.GOLD_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_HANOI_TOWER));
		placeEnumMap.get(PlaceKey.GOLD_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		placeEnumMap.get(PlaceKey.PLATINUM_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_QUESTIONS));
		placeEnumMap.get(PlaceKey.PLATINUM_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_KARAOKE));
		placeEnumMap.get(PlaceKey.PLATINUM_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_HANGMAN));
		placeEnumMap.get(PlaceKey.PLATINUM_HUB).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		placeEnumMap.get(PlaceKey.SHOP).addExits(exitEnumMap.get(ExitKey.EXIT_CARNIVAL));

		placeEnumMap.get(PlaceKey.ROCK_PAPER_SCISSORS).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		placeEnumMap.get(PlaceKey.FIND_NUMBER).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));
		placeEnumMap.get(PlaceKey.QTE).addExits(exitEnumMap.get(ExitKey.EXIT_COPPER_HUB));

		placeEnumMap.get(PlaceKey.TIC_TAC_TOE).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		placeEnumMap.get(PlaceKey.RIDDLE).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));
		placeEnumMap.get(PlaceKey.HANOI_TOWER).addExits(exitEnumMap.get(ExitKey.EXIT_GOLD_HUB));

		placeEnumMap.get(PlaceKey.QUESTIONS).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		placeEnumMap.get(PlaceKey.KARAOKE).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));
		placeEnumMap.get(PlaceKey.HANGMAN).addExits(exitEnumMap.get(ExitKey.EXIT_PLATINUM_HUB));

		return placeEnumMap;
	}
}