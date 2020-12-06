package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Random;
import java.util.Scanner;

public class Karaoke extends Game {

    private final static int NB_TRY = 3;

    private final String[][] LYRICS = {
            //{"I believe I can fly! I believe I can touch the ___!","sky"},
            {"___ _ ____ meet you! And this is crazy!", "Hey i just"},
            {"Boom! Boom! Boom! Boom! I want you in my ____ !", "room"},
            {"Arouf Gangsta, _______ même dans ton trou !","partout"},
            {"Ta les boules, ta les _______, ta les crottes de nez qui pendent!", "glandes"},
            {"___ __ _____! RS4 gris nardo, bien sûr qu'ils m'ont raté ! (gros, bien sûr)", "oui ma gatée" },
            {"Jeunes renoies sauvages! Elles ont du ______ dans l'oesophage! (Bendo na bendo!)", "sperme"},
            //{"Tape tape dans tes mains, ______ ____ ____!", "petit ours brun"}
    };

    private final String[] COMMENTARY = {
            "(This one is unmissable!)",
            "(Singing this one since my mother's womb!)",
            "(It's a gift...)",
            "(Seriously? I could guess without listening!)",
            "(My dad taught me this one.)",
            "(It's my grandma's favorite song!)",
            "(It's a classic one.)"
    };

    public Karaoke(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Karaoke() {
        this("Karaoke",
                "In this game, your music culture will be useful to find out the missing lyrics.\n" +
                        "Type \"play\" to start the game.",
                new NPC("Kharra Okey"),
                Level.PLATINUM);
    }

    private int getLengthSENTENCES(){
        return this.LYRICS.length;
    }

    private int getLengthCOMMENTARY(){
        return this.LYRICS.length;
    }

    @Override
    public void play(Player player) {
        NPC npc = this.getNpc();
        Scanner scanner;

        System.out.println("--- Game launched ---");

        npc.talk("Laddies and Gentlemen, welcome to my stand! " +
                "Here your music culture would be roughly tested...\n" +
                "You have " + NB_TRY + " guesses. Good luck!\n" +
                "Get ready, get set, go!\n");

        //To choose randomly a word from the words array
        int index = randNum(this.getLengthSENTENCES());
        String sentence = LYRICS[index][0];
        String word = LYRICS[index][1];
        word = word.toUpperCase();

        int trials_left = NB_TRY;
        String guess = "";

        while ((guess.compareTo(word)!=0) && (trials_left>0)) {

            if (trials_left != NB_TRY) {
                npc.talk(guess + " is not what I expected... Maybe a typing mistake?");
                npc.talk("You still have " + trials_left + " trial(s) to find it. Think carefully...\n");
            }

            npc.talk("Find the word to complete the song :" );
            System.out.println("\"" + sentence + "\"");

            if (trials_left == NB_TRY) {
                int rd_index = randNum(this.getLengthCOMMENTARY());
                npc.talk(COMMENTARY[rd_index]);
            }

            npc.talk("What is your guess ?");
            scanner = Gameplay.scanner;

            guess = scanner.nextLine();
            guess = guess.toUpperCase();

            trials_left--;
        }
        boolean win = this.checkWin(trials_left, word,npc);

        System.out.println("--- Game ended ---");

        if(win)
            this.win(player);
        else
            this.lose(player);
    }

    public int randNum(int length){
        Random rd = new Random();rd.nextInt(length);
        return rd.nextInt(length);
    }

    private boolean checkWin(int trials_left, String word, NPC npc){
        boolean win = false;
        if (trials_left<1){
            npc.talk("Sorry for your lack of culture :/ (You're a miss...)");
        }
        else {
            npc.talk("Here we are! \"" +
                    word + "\" was the missing lyric." +
                    "\n Hell yeah, you find it ! What a singer ! ;)");
            win = true;
        }
        return win;
    }
}