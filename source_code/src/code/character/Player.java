package code.character;

import code.enumeration.Command;
import code.item.Item;
import code.place.Place;
import code.exit.Exit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Character {

	/// Constants ///

	static final int MAX_HEALTH = 100;
	static final int DEFAULT_MONEY = 10;


	/// Attributes ///

	private Place cur_place;
	private List<Item> items;
	private int health;
	private int money;
	private boolean isLose;


	/// Methods ///

	public Player(String name, Place p) {
		super(name);
		this.cur_place = p;
		this.health = MAX_HEALTH;
		this.money = DEFAULT_MONEY;
		this.items = new ArrayList<>();
		this.isLose = false;
	}

	private void lose(){
		this.isLose = true;
	}

	public void increaseHealth(int health) {
		if(this.health + health >= MAX_HEALTH){
			this.health = MAX_HEALTH;
		}
		else{
			this.health += health;
		}
	}

	public void decreaseHealth(int health) {
		this.health -= health;
		if(this.health <= 0){
			this.lose();
		}
	}

	public void earnMoney(int money) {
		this.money += money;
	}

	public void loseMoney(int money) {
		if(this.money - money <= 0){
			this.money = 0;
		}
		else{
			this.money -= money;
		}
	}

	public void changePlace(Place place){
		this.cur_place = place;
		System.out.println("You go to : " + place.getName());
	}

	public void execCommand(Command command, Scanner scanner) {
		String[] s = scanner.nextLine().split(" ");
		switch (command) {
			case GO:
				if (s.length == 2) {
					int pos = Integer.parseInt(s[1]);
					if(this.cur_place.lengthExitList() > pos){
						Exit e = this.cur_place.getExit(pos);
						if(e.isLock()){
							System.out.println("You can't go there, this place is closed !");
						}
						else{
							this.cur_place = e.getPlace();
						}
					}
					else{
						System.out.println("Please enter valid place !");
					}
				} else if (s.length > 2){
					System.out.println("Please enter just one place !");
				} else {
					this.cur_place.printExitsPlace();
				}
				break;
			case HELP:
				if (s.length == 2) {
					Command.helpCommand(
							Command.stringToCommand(s[1])
					);
				} else if (s.length > 2){
					System.out.println("Please enter valid command !");
				} else {
					Command.printCommands();
				}
				break;
			case LOOK:
				System.out.println("TODO : look command");
				break;
			case TAKE:
				System.out.println("TODO : take command");
				break;
			case QUIT:
				System.exit(0);
				break;
			case USE:
				System.out.println("TODO : use command");
				break;
			default:
				System.out.println("Unknown command\n" +
						"Type help for have the command list");
		}
	}

	/// Accessors ///

	public Place getPlace(){
		return this.cur_place;
	}

	public int getHealth(){
		return this.health;
	}

	public int getMoney(){
		return this.money;
	}

	public Item getItemPos(int i){
		return this.items.get(i);
	}

	public boolean getIsLose(){
		return this.isLose;
	}
}