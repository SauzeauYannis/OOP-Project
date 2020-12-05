package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class RockPaperScissors extends Game {

    private final String[] ROSHAMBO = {
            "rock",
            "paper",
            "scissors"
    };

    private int playerPoint;
    private int NPCPoint;

    public RockPaperScissors(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public RockPaperScissors() {
        this("Rock paper scissors",
                "In this game you need to beat at roshambo the man who is in front of you.\n" +
                        "Type \"play\" to start the game",
                new NPC("Pierre Dupuis"),
                Level.COPPER);
    }

    @Override
    public void play(Player player) {
        playerPoint = 0;
        NPCPoint = 0;

        System.out.println("--- Game launched ---");
        System.out.println("To play, type one of this proposition :");
        for (String proposition: ROSHAMBO) {
            System.out.println("-" + proposition);
        }
        System.out.println("Good luck!");

        this.getNpc().talk("I am unbeatable in that game!\n" +
                "I take you in 3 rounds");

        while (playerPoint < 3 && NPCPoint < 3) {
            this.getNpc().talk("\nRo..\nSham..\nBo!");

            String playerTurn = getPlayerTurn();
            int NPCTurn = getNPCTurn();

            checkWinner(playerTurn, NPCTurn);

            printPoint(player.getName());
            printPoint(this.getNpc().getName());
        }

        if (playerPoint == 3) {
            this.win(player);
        } else {
            this.lose(player);
        }

        Gameplay.scanner.nextLine();
    }

    private void printPoint(String name) {
        System.out.println("-" +
                name +
                " : " +
                playerPoint +
                " points");
    }

    private void checkWinner(String playerTurn, int NPCTurn) {
        NPC npc = this.getNpc();
        if (playerTurn.equals(ROSHAMBO[NPCTurn])) {
            npc.talk("Draw, I'll get you in the next round!");
        } else if (playerTurn.equals(ROSHAMBO[(NPCTurn+1)%3])) {
            npc.talk("I lose, it's impossible you cheated!");
            playerPoint++;
        } else {
            npc.talk("I win, i'm too strong for you!");
            NPCPoint++;
        }
    }

    private int getNPCTurn() {
        int rand = (int)(Math.random()*3);

        this.getNpc().talk(ROSHAMBO[rand]);

        return rand;
    }

    private String getPlayerTurn() {
        Scanner scanner = Gameplay.scanner;

        String playerTurn = scanner.next();

        while (!checkPlayerTurn(playerTurn)) {
            playerTurn = scanner.next();
        }

        return playerTurn;
    }

    private boolean checkPlayerTurn(String playerTurn) {
        for (String proposition: ROSHAMBO) {
            if (playerTurn.equals(proposition)) {
                return true;
            }
        }
        return false;
    }
}