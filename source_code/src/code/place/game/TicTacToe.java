package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game {

    final static int NEUTRAL = 0;
    final static int CROSS = 1;
    final static int CIRCLE = 2;

    final static int DEFAULT_SIZE = 3;
    final static int DEFAULT_REWARD = 10;


    /// Attributes ///

    private int[][] matrix;
    private int winner;


    /// Methods ///

    public TicTacToe(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
        this.matrix = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        this.winner = NEUTRAL;
    }

    public TicTacToe() {
        this("Tic Tac Toe",
                "This the game of the TicTacToe, you must to align three same symbols to horizontally, vertical or diagonal.",
                new NPC("Sagrat Opubice"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        System.out.println("--- Game launched ---");

        this.initMatrix();
        Scanner scan = Gameplay.scanner;
        Random rand = new Random();
        int beginner = headsOrTails(rand);
        int choosen;
        int i, j;

        this.getNpc().talk("Hello, now play with me and  ! \n" +
                "We well see who begin ! Choose 1 or 2.");

        choosen = scan.nextInt();

        while (choosen < 1 || choosen > 2) {
            this.getNpc().talk("What are you going ? I said choose between 1 or 2 ! Dumb kid ...\n" +
                    "So, which one ?");
            choosen = scan.nextInt();
        }

        if (choosen == beginner) {
            this.getNpc().talk("Right, you're the beginner\n" +
                    "So you're cross, and I take circle\n" +
                    "Now choose where you want to place you cross");
        } else {
            this.getNpc().talk("Nice, I'm the beginner. You're lost boy.\n" +
                    "So you're cross, and I take circle\n" +
                    "I'll choose my case ! ");

            this.npcTurn(rand);
        }

        while (this.winner == NEUTRAL) {
            this.playerTurn(scan);

            if(this.winner == NEUTRAL){
                this.npcTurn(rand);
            }

        }

        if(winner == CROSS){
            this.win(player, DEFAULT_REWARD);
        }
        else {
            this.lose(player);
        }

        System.out.println("--- Game finished ---");
    }

    private void initMatrix() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                this.matrix[i][j] = NEUTRAL;
            }
        }
    }

    private static int headsOrTails(Random rand) {
        return rand.nextInt(1) + 1;
    }

    private boolean setCase(int i, int j, int symbol) {
        if (this.matrix[i][j] == NEUTRAL) {
            this.matrix[i][j] = symbol;

            this.isWin(i, j, symbol);

            this.displayGame();

            return true;
        }
        else{
            return false;
        }
    }

    private void isWin(int i, int j, int symbol) {
        if ((this.matrix[i][0] == this.matrix[i][1] && this.matrix[i][1] == this.matrix[i][2])
                ||
                (this.matrix[0][j] == this.matrix[1][j] && this.matrix[1][j] == this.matrix[2][j])
                ||
                ((i == j) && (this.matrix[0][0] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[2][2]))
                ||
                ((i + j == 2) && this.matrix[2][0] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[0][2])
        ) {
            this.winner = symbol;
        }
    }

    private void npcTurn(Random rand){
        boolean stop = false;
        int i;
        int j;

        while(!stop){
            i = rand.nextInt(DEFAULT_SIZE);
            j = rand.nextInt(DEFAULT_SIZE);

            if(this.setCase(i, j, CIRCLE)){
                stop = true;
            }
        }
    }

    private void playerTurn(Scanner scan){
        boolean stop = false;
        int i;
        int j;

        while(!stop){

            i = scan.nextInt()-1;
            j = scan.nextInt()-1;

            if((i<0 || i>2 || j<0 || j>2)){
                System.out.println("Please choose valid case");
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
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                if(this.matrix[i][j] == CROSS){
                    System.out.print(" X ");
                }
                else if(this.matrix[i][j] == CIRCLE){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

}
