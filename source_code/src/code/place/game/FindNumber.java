package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class FindNumber extends Game {

    private final static int MAX_INT = 999;
    private final static int STOP = -1;
    private final static int DEFAULT_ATTEMPT = 10;

    public FindNumber(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public FindNumber() {
        this("Find Number",
                "In this game you need to find a number think by the man who is in front of you.\n" +
                "Type \"play\" to start the game",
                new NPC("Vincent Faygaf"),
                Level.COPPER);
    }

    @Override
    public void play(Player player) {
        Scanner scanner = Gameplay.scanner;

        int attempt = DEFAULT_ATTEMPT;

        int choose;
        int rand = (int)(Math.random()*(MAX_INT));

        System.out.println("--- Game launched ---");

        this.getNpc().talk("You need to find my number between 0 and " +
                MAX_INT +
                " in " +
                DEFAULT_ATTEMPT +
                " attempts");

        while (attempt > 0) {
            System.out.print("-> Choose a number : ");

            try {
                choose = scanner.nextInt();
            } catch (Exception exception) {
                scanner.nextLine();
                choose = MAX_INT + 1;
                this.getNpc().talk("You need to write a number!");
            }

            if(choose > MAX_INT || choose < STOP) {
                System.out.println("Please entry a valid number, or '-1' if you want to give up");
            } else {
                attempt--;
                if (choose == STOP || attempt == 0) {
                    this.getNpc().talk("The number was " + rand);
                    this.lose(player);
                    break;
                } else {
                    if (rand > choose) {
                        this.getNpc().talk("It's more!");
                    } else if (rand < choose) {
                        this.getNpc().talk("It's less!");
                    } else {
                        this.win(player);
                        break;
                    }
                    this.getNpc().talk("You only have " +
                            attempt +
                            " attempts left");
                }
            }
        }

        scanner.nextLine();
    }
}