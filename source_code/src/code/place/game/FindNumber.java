package code.place.game;

import code.character.Player;
import code.enumeration.Level;
import code.enumeration.PlaceKey;
import code.place.Game;

import java.util.Scanner;

public class FindNumber extends Game {

    final static int MAX_INT = 999;
    final static int STOP = -1;
    final static int DEFAULT_ATTEMPT = 10;

    private int attempt;

    public FindNumber(String name, String description, int attempt, Level level) {
        super(name, description, level);
        this.attempt = attempt;
    }

    public FindNumber() {
        this("Find number", PlaceKey.getPlaceDescription(PlaceKey.FIND_NUMBER), DEFAULT_ATTEMPT, Level.COPPER);
    }

    @Override
    public void play(Player player, Scanner scanner) {
        int choose;
        int rand = (int)(Math.random()*(MAX_INT));

        System.out.println("--- Game launched ---");
        System.out.println("-> You need to find a number between 0 and " +
                MAX_INT +
                " in " +
                this.attempt +
                " attempts");

        for (int i = this.attempt; i > 0; i--) {
            System.out.print("-> Choose a number : ");

            choose = scanner.nextInt();

            if(choose > MAX_INT || choose < STOP) {
                System.out.println("Please entry a valid number, or '-1' if you want to give up");
            } else {
                this.attempt--;
                if (choose == STOP || this.attempt == 0) {
                    System.out.println("The number was " + rand);
                    this.lose(player);
                    break;
                } else {
                    if (rand > choose) {
                        System.out.println("It's more !");
                    } else if (rand < choose) {
                        System.out.println("It's less !");
                    } else {
                        this.win(player, 10);
                        break;
                    }
                    System.out.println("You only have " +
                            this.attempt +
                            " attempts left");
                }
            }
        }
    }
}