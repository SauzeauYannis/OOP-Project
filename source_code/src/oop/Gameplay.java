package oop;

import oop.character.Player;
import oop.place.Place;

import java.util.*;

public class Gameplay {

	private List<Place> places;
	private Player player;

	public static void main(String[] args) {
	    Player player = new Player("Benjapied Tablenuit");
        System.out.println("Your name is : " + player.getName());
	}

}