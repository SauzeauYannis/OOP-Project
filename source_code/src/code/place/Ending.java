package code.place;

import code.Gameplay;
import code.character.NPC;

import java.util.concurrent.TimeUnit;

public class Ending extends Place{

    /****************************
     * Attribute and constructor
     ****************************/

    // Class attribute
    private static final String[] NPC_TALK = {
            "Congratulations, you have won this game!",
            "We hope you enjoyed it!",
            "Created by:",
            "Henintsoa Andrianarivony",
            "Samuel Goubeau",
            "Yannis Sauzeau"
    };

    // Constructor
    public Ending(){
        super("Sparkling caravan",
        "This is the last place of this game",
                new NPC("Gesui'hun Diheu"));
    }

    /*********
     * Method
     *********/

    // To print the credits
    public void printCredits() {
        // Print each noc sentence with 2 seconds intervals
        for (String sentence: NPC_TALK) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception exception) {
                System.err.println("Error during sleep program in QTE");
            }
            this.getNpc().talk(sentence);
        }

        System.out.println("| Press enter to exit");

        // Wait enter
        Gameplay.scanner.nextLine();

        // Quit the program
        System.exit(0);
    }
}
