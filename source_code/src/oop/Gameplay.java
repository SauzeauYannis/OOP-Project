package oop;

import oop.character.NPC;
import oop.character.Player;
import oop.place.Hub;
import oop.place.Place;
import oop.place.Shop;
import oop.place.game.*;

import java.util.*;

public class Gameplay {

    private List<Place> places;
	private Player player;

	public static void main(String[] args) {

	    NPC npc = new NPC("test NPC");

        Hub hub = new Hub(new NPC("GHES'UIN GUIDE"));
        System.out.println(hub.getName());
        System.out.println(hub.getNpc().getName());

        Player player = new Player("Benjapied Tablenuit", hub);
        System.out.println("Your name is : " + player.getName());

        Shop shop = new Shop(new NPC("Gésui’Hun Von Dheur"));
        System.out.println(shop.getName());
        System.out.println(shop.getNpc().getName());

        FindNumber findNumber = new FindNumber(npc);
        Hangman hangman = new Hangman(npc);
        HanoiTower hanoiTower = new HanoiTower(npc);
        Karaoke karaoke = new Karaoke(npc);
        QTE qte = new QTE(npc);
        Questions questions = new Questions(npc);
        Riddle riddle = new Riddle(npc);
        RockPaperScissors rockPaperScissors = new RockPaperScissors(npc);
        TicTacToe ticTacToe = new TicTacToe(npc);
	}

}