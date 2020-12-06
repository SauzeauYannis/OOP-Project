package code.place;

import code.Gameplay;
import code.character.NPC;
import code.command.Interpreter;

import java.util.concurrent.TimeUnit;

public class Ending extends Place{

    private static final String[] NPC_TALK = {
            "Congratulations, you have won this game!",
            "We hope you enjoyed it!",
            "Created by:",
            "Henintsoa Andrianarivony",
            "Samuel Goubeau",
            "Yannis Sauzeau"
    };

    public Ending(){
        super("Sparkling caravan",
        "This is the last place of this game",
                new NPC("Gesui'hun Diheu"));
    }

    public void credit() {
        for (String sentence: NPC_TALK) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception exception) {
                System.err.println("Error during sleep program in QTE");
            }
            this.getNpc().talk(sentence);
        }
        System.out.println("Press a key to exit");
        Gameplay.scanner.nextLine();
        System.exit(0);
    }
}
