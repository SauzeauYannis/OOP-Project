package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game {

    /// Constants ///

    final static int NEUTRAL = 0;
    final static int CROSS = 1;
    final static int CIRCLE = 2;

    final static int DEFAULT_SIZE = 3;

    final static String[] sentences = {
            "Mmmmh, an interesting choice..",
            "Well, it's my turn now <3",
            "You know what you're doing darling!",
            "I find this party interesting.."
    };


    /// Attributes ///

    private final int[][] cases;
    private int winner;


    /// Methods ///

    public TicTacToe(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
        this.cases = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        this.winner = NEUTRAL;
    }

    public TicTacToe() {
        this("Tic Tac Toe",
                "| This the game of the TicTacToe, you must to align three same symbols to horizontally, vertical or diagonal.",
                new NPC("Sagrat Opubice"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        System.out.println("\n--- Game launched ---\n");

        this.initGame();
        Scanner scan = Gameplay.scanner;
        Random rand = new Random();
        int beginner = rand.nextInt(2) + 1;
        int chosen;

        this.getNpc().talk("Hello little darling,  how are you today? \n" +
                "What?! You want to play with me? Hahaha, alright darling ;)\n" +
                "We will see who begin  with a Heads or Tails! Choose 1 or 2.");

        System.out.println("-> Choice: ");
        System.out.print(player);
        chosen = scan.nextInt();

        while (chosen < 1 || chosen > 2) {
            this.getNpc().talk("What are you going? I said choose between 1 or 2! Darling...\n" +
                    "So, which one?");
            System.out.println("-> Choice:");
            System.out.print(player);
            chosen = scan.nextInt();
        }

        this.getNpc().talk("Ok, so the result is...\n=> " +
                beginner + "!!");

        if (chosen == beginner) {
            this.getNpc().talk("Right, you're the beginner!\n" +
                    "So you're cross, and I take circle.\n" +
                    "Now choose where you want to place you cross!");
        } else {
            this.getNpc().talk("Nice, I'm the beginner.\n" +
                    "So you're cross, and I take circle.\n" +
                    "I'll choose my case!  Good luck darling ;)");

            this.npcTurn(rand);
        }

        while (this.winner == NEUTRAL) {
            this.playerTurn(player, scan);

            if(this.winner == NEUTRAL){
                this.npcTurn(rand);
            }

        }

        if(winner == CROSS){
            this.getNpc().talk("Ooooh, you're pretty strong darling! <3\n" +
                    "You've deserve your reward, my little boy!\n" +
                    "I hope I can see you again, maybe to show you something... new ;)");

            this.win(player);
        }
        else {
            this.getNpc().talk("Tsss, sorry darling but you've lost this time...\n" +
                    "You're not as strong as I thought.\n" +
                    "Give me your money darling, an see you later to give it to me again ;)");

            this.lose(player);
        }

        scan.nextLine();

        System.out.println("\n--- Game finished ---\n");
    }

    private void initGame() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                this.cases[i][j] = NEUTRAL;
            }
        }

        this.winner = NEUTRAL;
    }

    private boolean setCase(int i, int j, int symbol) {
        if (this.cases[i][j] == NEUTRAL) {
            this.cases[i][j] = symbol;

            this.isWin(i, j, symbol);

            this.displayGame();

            return true;
        }
        else{
            return false;
        }
    }

    private void isWin(int i, int j, int symbol) {
        if ((this.cases[i][0] == this.cases[i][1] && this.cases[i][1] == this.cases[i][2])
                ||
                (this.cases[0][j] == this.cases[1][j] && this.cases[1][j] == this.cases[2][j])
                ||
                ((i == j) && (this.cases[0][0] == this.cases[1][1] && this.cases[1][1] == this.cases[2][2]))
                ||
                ((i + j == 2) && this.cases[2][0] == this.cases[1][1] && this.cases[1][1] == this.cases[0][2])
        ) {
            this.winner = symbol;
        }
    }

    private void npcTurn(Random rand){
        boolean stop = false;
        int i;
        int j;
        String sentence = sentences[rand.nextInt(sentences.length)];

        System.out.println("\n|| NPC turn ||\n");
        this.getNpc().talk(sentence);

        while(!stop){
            i = rand.nextInt(DEFAULT_SIZE);
            j = rand.nextInt(DEFAULT_SIZE);

            if(this.setCase(i, j, CIRCLE)){
                stop = true;
            }
        }
    }

    private void playerTurn(Player player, Scanner scan){
        boolean stop = false;
        int i;
        int j;

        System.out.println("\n|| Your turn ||\n" +
                "Type a sequence like this: \"2 2\", to put your symbol to the case (2,2)");

        while(!stop){

            System.out.println("-> Choose your case: ");
            System.out.print(player);

            i = scan.nextInt()-1;
            j = scan.nextInt()-1;

            if((i<0 || i>2 || j<0 || j>2)){
                System.out.println("Please choose valid case!\n(Between 1 and 3)");
            }
            else if(!this.setCase(i, j, CROSS)){
                System.out.println("This case is already use, choose an over one");
            }
            else {
                stop = true;
            }
        }
    }

    private void displayGame(){

        System.out.println();

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                if(this.cases[i][j] == CROSS){
                    System.out.print(" X ");
                }
                else if(this.cases[i][j] == CIRCLE){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
