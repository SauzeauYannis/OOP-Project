package code.place;

import code.Interface.Describable;
import code.character.NPC;
import code.enumeration.ExitKey;
import code.enumeration.PlaceKey;
import code.exit.Exit;
import code.place.game.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Place implements Describable {

	private final List<Exit> exitList;
	private NPC npc;
	private final String name;
	private String description;

	public Place(String name, String description) {
		this.name = name;
		this.exitList = new ArrayList<>();
		this.description = description;
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
		for(int i=0; i<this.exitList.size(); i++) {
			System.out.print("| " + i + " : ");
			this.exitList.get(i).printExit();
		}
	}

	public Exit getExit(int i){
		return this.exitList.get(i);
	}

	public int lengthExitList(){
		return this.exitList.size();
	}

	@Override
	public void readDescription() {
		System.out.println(this.description);
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	public static EnumMap<PlaceKey, Place> generateAllPlaces() {
		EnumMap<PlaceKey, Place> placeEnumMap = new EnumMap<>(PlaceKey.class);

		placeEnumMap.put(PlaceKey.CARNIVAL,
				new Place("Carnival", "This is the principal place of the carnival"));
		placeEnumMap.put(PlaceKey.COPPER_HUB,
				new Place("Copper Hub", "This is the place where you can choose to go to a copper Game"));
		placeEnumMap.put(PlaceKey.GOLD_HUB,
				new Place("Gold Hub", "This is the place where you can choose to go to a gold Game"));
		placeEnumMap.put(PlaceKey.PLATINUM_HUB,
				new Place("Platinum Hub", "This is the place where you can choose to go to a platinum Game"));
		placeEnumMap.put(PlaceKey.SHOP,
				new Shop());
		placeEnumMap.put(PlaceKey.FIND_NUMBER,
				new FindNumber());
		placeEnumMap.put(PlaceKey.HANGMAN,
				new Hangman());
		placeEnumMap.put(PlaceKey.HANOI_TOWER,
				new HanoiTower());
		placeEnumMap.put(PlaceKey.KARAOKE,
				new Karaoke());
		placeEnumMap.put(PlaceKey.QTE,
				new QTE());
		placeEnumMap.put(PlaceKey.QUESTIONS,
				new Questions());
		placeEnumMap.put(PlaceKey.RIDDLE,
				new Riddle());
		placeEnumMap.put(PlaceKey.ROCK_PAPER_SCISSORS,
				new RockPaperScissors());
		placeEnumMap.put(PlaceKey.TIC_TAC_TOE,
				new TicTacToe());

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