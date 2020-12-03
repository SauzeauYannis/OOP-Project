package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Timer;
import java.util.TimerTask;

public class QTE extends Game {

    private final static int DEFAULT_REWARD = 10;

    private final String[] NPC_TALK = {
            "Start slowly with this first punch!\n",
            "Okay now faster with this second punch!\n",
            "You're fast but you can't be more fast for this last punch\n"
    };
    private final String[] ROUND = {
            "todo mettre une citation de rap gitan pour phrase 1",
            "todo mettre une citation de rap gitan pour phrase 2",
            "todo mettre une citation de rap gitan pour phrase 3"
    };
    private final int[] TIME = {
            20,
            15,
            10
    };

    public QTE(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public QTE() {
        this("QTE",
                "TODO : description",
                new NPC("Ethoufet Kwallah"),
                Level.COPPER);
    }

    @Override
    public void play(Player player) {
        NPC npc = this.getNpc();
        int round = 0;

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                lose(player);
            }
        };

        System.out.println("--- Game launched ---");
        npc.talk("Yo! Welcome to my stand bro!\n" +
                "I am the fastest rapper of this carnival!\n" +
                "Try to repeat that I say in a limited time");

        while (round < 3) {
            npc.talk(NPC_TALK[round] +
                    "\"" + ROUND[round] + "\" in " + TIME[round] + "s");
            Timer timer = new Timer();
            timer.schedule(timerTask, (TIME[round] * 1000L));
            String playerSentence = Gameplay.scanner.nextLine();
            if (playerSentence.equalsIgnoreCase(ROUND[round])) {
                npc.talk("Well played for this round!");
            } else {
                npc.talk("I am the best!");
                this.lose(player);
                return;
            }
            timer.cancel();
            round++;
        }

        this.win(player, (int)(Math.random()*DEFAULT_REWARD) + 1);
    }

/*    private static class MyTimer {

        int second;

        public MyTimer(int second) {
            this.second = second;
        }

        public void decrease() {
            try {
                Thread.sleep(1000);
            } catch (Exception exception) {
                Thread.currentThread().interrupt();
            }
            this.second--;
        }

        public boolean isFinish() {
            return this.second == 0;
        }
    }*/
}