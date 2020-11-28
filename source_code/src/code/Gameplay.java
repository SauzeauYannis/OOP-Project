package code;

import code.character.NPC;
import code.character.Player;
import code.place.Place;
import code.place.Shop;
import code.place.game.*;

import java.util.*;

public class Gameplay {

	public static void main(String[] args) {

	    NPC npc = new NPC("test NPC");

        Place hub = new Place(new NPC("GHES'UIN GUIDE"), "Hub");
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

        System.out.println(findNumber.getName());
        System.out.println(hangman.getName());
        System.out.println(hanoiTower.getName());
        System.out.println(karaoke.getName());
        System.out.println(qte.getName());
        System.out.println(questions.getName());
        System.out.println(riddle.getName());
        System.out.println(rockPaperScissors.getName());
        System.out.println(ticTacToe.getName());
	}

}