package code.place.game;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

public class Riddle extends Game {

    /// Constants ///

    final static String[][] riddles ={
            {"What is the summation between 1 and 139281938 ?", "139281939"}
    };


    /// Attributes ///




    /// Methods ///

    public Riddle(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Riddle() {
        this("Riddle",
                "| Here you need to answer to a riddle. You have only ??? attempts !\n" +
                        "| Turn on your brain, and make it work hard !",
                new NPC("Jean-Pierre Fougas"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        System.out.println("--- Game launched ---");

        this.getNpc().talk("Oh oh oh, greetings traveler ! I hope you aren't so tired to be arrived here !\n" +
                "Because you will be probationned, by my self ! You should find the right answer to my riddle.\n" +
                "But you know, I am a professional in this domain ! I have 50 years ... bla bla bla ...\n" +
                "... but I am remember this guy, Ethoufet Kwallah, my first rival in ... bla bla bla ...\n" +
                "... and this is how I am became what I am today ! Wait you're sleeping during my story ?!\n" +
                "Ooooh, like each time. Ok, so let's begin\n");



    }
}