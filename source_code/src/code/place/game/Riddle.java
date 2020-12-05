package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Riddle extends Game {

    /// Constants ///

    final static int DEFAULT_ATTEMPTS = 3;

    final static String[][] RIDDLES ={
            {"What is the summation between 1 and 2 ?", "3"},
            {"What answer Zebi if his professor ask who want to the b ?","can I do the b"},
            {"If I am mute, blind and deaf, how many senses do I have left ?", "3"},
            {"if 1 equals 5, 2 equals 25, 3 equals 605, 4 equals 10855, 5 equals what ?", "1"},
            {"You have this suite : 2 3 5 ? 11 ", "7"}
    };


    /// Attributes ///

    private int attempts;


    /// Methods ///

    public Riddle(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
        this.attempts = DEFAULT_ATTEMPTS;
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

        Scanner scan = Gameplay.scanner;
        Random rand = new Random();
        boolean stop = false;
        String[] riddle = RIDDLES[rand.nextInt(RIDDLES.length)];
        String answer;

        this.attempts = DEFAULT_ATTEMPTS;

        System.out.println("--- Game launched ---");

        this.getNpc().talk("Oh oh oh, greetings traveler ! I hope you aren't so tired to be arrived here !\n" +
                "Because you will be probationned, by my self ! You should find the right answer to my riddle.\n" +
                "But you know, I am a professional in this domain ! I have 50 years ... bla bla bla ...\n" +
                "... but I am remember this guy, Ethoufet Kwallah, my first rival in ... bla bla bla ...\n" +
                "... and this is how I am became what I am today ! Wait you're sleeping during my story ?!\n" +
                "Ooooh, like each time. Ok so, are you ready ?\n");

        while(attempts != 0){

            System.out.print("-> Choice (yes or no) : ");
            answer = scan.nextLine().toLowerCase();

            if(answer.equals("yes") || answer.equals("no")){
                if(answer.equals("no")){
                    this.getNpc().talk("Oh...Ok...So, goodbye kid. I hope you will change\n" +
                            " your opinion, and come back traveler ...");
                }
                else {
                    this.getNpc().talk("Oh oh perfect ! Ok ok, let's begin\n" +
                            "Sit down, calm down and listen :\n");

                    System.out.println("|[ " + riddle[0] + " ]|\n");

                    this.getNpc().talk("So traveler, what is your answer ? O.O");

                    while(attempts != 0){
                        System.out.print("-> Answer : ");

                        answer = scan.nextLine().toLowerCase();

                        if(answer.equals(riddle[1].toLowerCase())){
                            this.getNpc().talk("INCREDIBLE TRAVELER !!!!\n" +
                                    "You are a true Hercule Kourge ! (it isn't Poirot ?)\n" +
                                    "You have deserved your reward traveler ! Take it !");
                            this.win(player);
                            attempts = 0;
                        }
                        else if(attempts > 1){
                            attempts -= 1;

                            this.getNpc().talk("Ok traveler, this isn't the end ! You can take sometime\n" +
                                    "to say a new proposal");
                            System.out.println("| Attempts left : " + attempts + "\n");
                        }
                        else {
                            attempts -= 1;

                            this.getNpc().talk("Oh no traveler, this isn't the good answer ...\n" +
                                    "I am so sorry to tell you this, but ...\n" +
                                    "this is the end, you lose ...");

                            this.lose(player);
                        }
                    }

                }
            }
            else{
                this.getNpc().talk("What did you said ? Sorry but I am an old man you know ... bla bla bla ...\n" +
                        "... and this is how I am became what I am today ! OH ! So-Sorry, I have started again.\n" +
                        "So ?\n");
            }
        }

    }
}