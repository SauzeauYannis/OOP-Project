package code.place.game;

import code.character.Player;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class FindNumber extends Game {

    final static int MAX_INT = 9999;

    public FindNumber(String name, String description) {
        super(name, description);
    }

    public FindNumber() {
        super("Find number", PlaceKey.getPlaceDescription(PlaceKey.FIND_NUMBER));
    }

    @Override
    public void play(Player p) {
        Scanner scan = new Scanner( System.in );
        boolean stop = true;
        int choose;
        int rand = (int)(Math.random() * (MAX_INT));

        System.out.println("--- Game launched ---");
        System.out.println("-> You need to find a number between 0 and 9999");

        while(stop) {
            System.out.print("-> Choose a number :");

            choose = scan.nextInt();

            if (choose == -1) {
                this.lose(p);
                System.out.println("The number was " + rand + "\n");
                stop = false;
            }
            else if(choose > 9999 && choose < -1){
                System.out.println("Please entry a valid number, or '-1' if you want to give up");
            }
            else if (rand > choose) {
                System.out.println("It's more !");
            } else if (rand < choose) {
                System.out.println("It's less !");
            } else {
                this.win(p);
                stop = false;
            }
        }
    }

    @Override
    public void win(Player p) {
        System.out.println("You win!");
        p.earnMoney(10);
    }

    @Override
    public void lose(Player p) {
        System.out.println("You have given up !");
        p.loseMoney(1);
    }

    @Override
    public void readDescription() {
        super.readDescription();
    }

    @Override
    public void setDescription(String description) {

    }
}