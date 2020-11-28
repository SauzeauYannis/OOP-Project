package code.place;

import code.Interface.Describable;
import code.character.NPC;
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

	public Place(String name) {
		this.name = name;
		this.exitList = new ArrayList<>();
	}

	public String getName() {
		return "Place : " + this.name;
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
	
	private void printExitsPlace() {
		for (Exit e:
			 this.exitList) {
			System.out.println(e.getPlace().name); //place
		}
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
				new Place("Carnival"));
		placeEnumMap.put(PlaceKey.COPPER_HUB,
				new Place("Copper Hub"));
		placeEnumMap.put(PlaceKey.GOLD_HUB,
				new Place("Gold Hub"));
		placeEnumMap.put(PlaceKey.PLATINUM_HUB,
				new Place("Platinum Hub"));
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

		return placeEnumMap;
	}
}