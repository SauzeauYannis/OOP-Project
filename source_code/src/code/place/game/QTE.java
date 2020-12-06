package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QTE extends Game {

    private final String[] NPC_TALK = {
            "Start slowly with this first punch!\n",
            "Okay now faster with this second punch!\n",
            "You're fast but you can't be more fast for this last punch!\n"
    };
    private final String[] ROUND = {
            "You drink wine i drink the blood of your dead",
            "You eat chocopipe during i eat hedgehog",
            "I am all even in your hole"
    };
    private final int[] TIME = {
            25,
            20,
            15
    };

    public QTE(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public QTE() {
        this("QTE",
                "| You are in front of the faster gipsy's rapper.\n" +
                "| Type \"play\" to start the game.",
                new NPC("Ethoufet Kwallah"),
                Level.COPPER);
    }

    @Override
    public void play(Player player) {
        NPC npc = this.getNpc();
        int round = 0;

        System.out.println("\n--- Game launched ---\n");

        npc.talk("Yo! Welcome to my stand bro!\n" +
                "I am the fastest rapper of this carnival!\n" +
                "Try to repeat that I say in a limited time!");

        while (round < 3) {
            npc.talk(NPC_TALK[round] +
                    "You have " + TIME[round] + "s to write the punch, good luck!");
            for (int i = 3; i > 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception exception) {
                    System.err.println("Error during sleep program in QTE");
                }
                npc.talk(Integer.toString(i));
            }
            npc.talk(ROUND[round]);

            Date start = new Date();
            System.out.print(player);
            String playerSentence = Gameplay.scanner.nextLine();
            Date end = new Date();

            if (playerSentence.equalsIgnoreCase(ROUND[round])) {
                int second = (int)((end.getTime() - start.getTime()) / 1000);
                if (second < TIME[round]) {
                    npc.talk(second +
                            "s.\nWell played for this round!");
                } else {
                    npc.talk(second +
                            "s.\nToo slow for me!");
                    this.lose(player);
                    return;
                }
            } else {
                npc.talk("It was not my punch!\n" +
                        "I am the best!");
                this.lose(player);
                return;
            }
            round++;
        }

        this.win(player);

        System.out.println("\n--- Game finished ---\n");
    }
}