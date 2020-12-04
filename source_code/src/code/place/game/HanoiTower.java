package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;
import java.util.Stack;

public class HanoiTower extends Game {

    private final static int DEFAULT_REWARD = 15;
    private final static int DISK_NUMBER = 3;

    private String[][] game;
    private Stack<Integer> aPillar;
    private Stack<Integer> bPillar;
    private Stack<Integer> cPillar;

    public HanoiTower(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public HanoiTower() {
        this("Hanoi tower",
                "You are in front of a person who needs help to solve a puzzle.\n" +
                        "Type \"play\" to help him.",
                new NPC("Edwardo Nald"),
                Level.GOLD);
    }

    @Override
    public void play(Player player) {
        Scanner scanner = Gameplay.scanner;
        NPC npc = this.getNpc();
        String command;
        String[] commandTab;

        System.out.println("--- Game launched ---");

        npc.talk("Hi young man, I'm really annoyed by this problem, can you help me?\n" +
                "I have three pillars in front of me and I have to pass the three discs from pillar A to pillar C using pillar B.\n" +
                "You have to respect these 2 rules in order not to lose:\n" +
                "-You can only move one disc at a time.\n" +
                "-You can only move a disk to an empty slot or a smaller disk.");

        initialize();
        printPillars();

        npc.talk("To start type \"a c\" to move disc from A to C");

        System.out.print(player);
        command = scanner.nextLine();

        while (!command.equalsIgnoreCase("A C")) {
            System.out.println("Type \"a c\"");
        }
        commandTab = command.toLowerCase().split(" ");
        moveDisk(commandTab[0], commandTab[1]);

        printPillars();

        while (!isWin()) {
            System.out.print(player);
            command = scanner.nextLine();

            while (!checkCommand(command)) {
                command = scanner.nextLine();
            }

            commandTab = command.toLowerCase().split(" ");

            if (!canMove(commandTab[0])) {
                npc.talk("You need to choose a non empty pillar!");
                continue;
            }

            if (moveDisk(commandTab[0], commandTab[1])) {
                printPillars();
            } else {
                npc.talk("Oh no you've lose!");
                this.lose(player);
                return;
            }

            npc.talk("Very good, what is your next move?");
        }

        npc.talk("Oh thanks a lot!");
        this.win(player, DEFAULT_REWARD);
    }

    private boolean checkCommand(String cmd) {
        String[] cmdTab = cmd.toLowerCase().split(" ");
        String match = "[abc]";
        if (cmdTab.length >= 2) {
            return cmdTab[0].matches(match) && cmdTab[1].matches(match) && !cmdTab[0].equals(cmdTab[1]);
        } else {
            return false;
        }
    }

    private boolean isWin() {
        return this.cPillar.size() == 3;
    }

    private boolean canMove(String src) {
        return !getPillar(src).empty();
    }

    private boolean moveDisk(String src, String dest) {
        int disk;
        boolean isWin;
        Stack<Integer> srcPillar = getPillar(src);
        Stack<Integer> destPillar = getPillar(dest);
        int srcLength = srcPillar.size();

        disk = srcPillar.pop();

        if (destPillar.empty()) {
            isWin = true;
        } else {
            isWin = disk < destPillar.peek();
        }

        if (!isWin) {
            return false;
        } else {
            destPillar.push(disk);
            changeGame(src, dest, srcLength, destPillar.size());
            return true;
        }
    }

    private void changeGame(String src, String dest, int srcLength, int destLength) {
        int s = src.charAt(0) - 97;
        int d = dest.charAt(0) - 97;

        String tmp = this.game[DISK_NUMBER-srcLength][s];
        this.game[DISK_NUMBER-srcLength][s] = this.game[DISK_NUMBER-destLength][d];
        this.game[DISK_NUMBER-destLength][d] = tmp;
    }

    private Stack<Integer> getPillar(String pillar) {
        if (pillar.equals("a")) {
            return aPillar;
        } else if (pillar.equals("b")) {
            return bPillar;
        } else {
            return cPillar;
        }
    }

    private void initialize() {
        this.game = new String[DISK_NUMBER][DISK_NUMBER];

        for (int i = 0; i < DISK_NUMBER; i++) {
            for (int j = 0; j < DISK_NUMBER; j++) {
                if (j == 0) {
                    this.game[i][j] = Integer.toString(i+1);
                } else {
                    this.game[i][j] = "|";
                }
            }
        }

        this.aPillar = new Stack<>();
        this.bPillar = new Stack<>();
        this.cPillar = new Stack<>();

        for (int i = DISK_NUMBER; i > 0; i--) {
            aPillar.push(i);
        }
    }

    private void printPillars() {
        for (int i = 0; i < DISK_NUMBER; i++) {
            for (int j = 0; j < DISK_NUMBER; j++) {
                System.out.print(this.game[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-\t-\t-\t");
        System.out.println("a\tb\tc\t");
    }
}