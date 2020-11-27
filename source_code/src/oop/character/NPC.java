package oop.character;

import oop.place.Place;

public class NPC extends Character {

	/// Methods ///

	public NPC(String name, Place p) {
		super(name, p);
	}

	public void talk() throws InterruptedException {

		// TODO - À modifier bien évidement

		for(int i=0; i<5; i++){
			System.out.print("Loading, please wait .");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print("\r");
		}
		System.out.println("Tu peux partir, j'ai rien à te dire.");
	}
}