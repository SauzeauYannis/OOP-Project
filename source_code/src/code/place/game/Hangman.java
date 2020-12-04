package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Random;
import java.util.Scanner;

public class Hangman extends Game {

    private final static int DEFAULT_REWARD = 10;
    private final static int NB_TRY = 5;

    private final String[] WORDS = {
            "Apple",
            "Pear",
            "Pineapple",
            "Peach",
            "Pumpkin",
            "Strawberry",
            "Apricot",
            "Eggplant",
            "Cherry",
            "Banana",
            "Avocado",
            "Lime",
            "Melon",
            "Watermelon",
            "Fig",
            "Tomato",
            "Artichoke",
            "Asparagus",
            "Broccoli"
    };

    public Hangman(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Hangman() {
        this("Hangman",
                "In this game, you have to found the word the stand owner is thinking of by giving him letters.\n" +
                        "Type \"play\" to start the game.",
                new NPC("Marina Lependu"),
                Level.PLATINUM);
    }

    private int getLengthWORDS(){
        return this.WORDS.length;
    }

    @Override
    public void play(Player player) {
        NPC npc = this.getNpc();
        Scanner scanner;

        System.out.println("--- Game launched ---");

        npc.talk("ZZzzzZZZ... Wha... Sh... Hello! ^^'\n" +
                "I wasn't sleeping... Well, I'm Mrs.Lependu and welcome to my stand! \n" +
                "The hangman game here is about fruits and vegetables...\n" +
                "I hope you've reviewed your voc!\n" +
                "Ok, let's play!\n" +
                "Try to find the word... " +
                "You have " + NB_TRY + " guesses. Good luck!");

        //To choose randomly a word from the words array
        String word = this.randWORDS();

        //To show the word in underscores form
        String wordToFind = word.replaceAll("[A-Z]", "_ ");

        int trials = 0;
        int trials_left = NB_TRY;

        String guess;
        char letter;

        // To store and know if a letter was already guessed
        String lettersFound = "";
        boolean letterFound;

        // Here starts the game code
        while (wordToFind.contains("_") && (trials_left>0)) {

            System.out.println(wordToFind);

            if (trials_left != NB_TRY)
                npc.talk("You have " + trials_left + " guesses left.");

            npc.talk("What is your guess ?");
            scanner = Gameplay.scanner;

            guess = scanner.nextLine();
            guess = guess.toUpperCase();

            letter = guess.charAt(0);
            letter = Character.toUpperCase(letter);

            letterFound = this.isLetterFound(lettersFound,letter,npc);

            if (!letterFound) {

                lettersFound += letter;

                if ((word.indexOf(letter)) != -1) {
                    npc.talk("Well done! " +
                            letter +
                            " is in the word!");

                    for (int i = 0; i < word.length(); i++) {

                        if (word.charAt(i) == letter && wordToFind.charAt(i) != letter) {
                            // To have the right element in index i
                            wordToFind = wordToFind.replaceAll("_ ", "1");
                            String tmp = wordToFind.substring(0, i)
                                    + letter
                                    + wordToFind.substring(i + 1);
                            tmp = tmp.replaceAll("1", "_ ");
                            wordToFind = tmp;
                        }
                    }
                } else {
                    npc.talk(letter + " is not in the word.");
                    trials_left--;
                }
                trials++;
            }
        }

        boolean win = this.checkWin(trials_left, wordToFind,trials,npc);

        System.out.println("--- Game ended ---");

        if(win)
            this.win(player,DEFAULT_REWARD);
        else
            this.lose(player);

    }

    public boolean isLetterFound(String lettersFound, char letter, NPC npc){
        boolean letterFound;
        if ((lettersFound.indexOf(letter)) != -1) {
            npc.talk("You have already guessed this letter.");
            letterFound = true;
        } else {
            letterFound = false;
        }
        return letterFound;
    }

    public String randWORDS(){
        Random rd = new Random();
        int rd_num = rd.nextInt(this.getLengthWORDS());
        String word = WORDS[rd_num];
        return word.toUpperCase();
    }

    public boolean checkWin(int trials_left, String wordToFind,int trials, NPC npc){
       boolean win = false;
        if (trials_left<1){
            npc.talk("You reached the number of incorrect guesses. Sorry you lose! :/");
        }
        else {
            npc.talk("Here we are! The word is: " +
                    wordToFind +
                    "\n What a winner! Work done in " +
                    trials +
                    " trials. Congrats dude! ;)");
            win = true;
        }
        return win;
    }
}