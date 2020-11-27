package oop;

import oop.character.NPC;
import oop.character.Player;
import oop.place.Hub;
import oop.place.Place;
import oop.place.Shop;

import java.util.*;

public class Gameplay {

    private List<Place> places;
	private Player player;

	public static void main(String[] args) {

        Hub hub = new Hub(new NPC("GHES'UIN GUIDE", null));

        System.out.println(hub.getName());

        System.out.println(hub.getNpc().getName());

        Shop shop = new Shop(new NPC("Gésui’Hun Von Dheur", null));

        Player player = new Player("Benjapied Tablenuit", hub);
        System.out.println("Your name is : " + player.getName());
	}

}