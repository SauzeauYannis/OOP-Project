package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;

import java.util.Scanner;

public class HanoiTower extends Game {

    private final static int DEFAULT_REWARD = 15;
    private final static int DISK_NUMBER = 3;

    private final String[] diskNum = {"3", "2", "1"};
    private String[] aPillar = new String[DISK_NUMBER];
    private String[] bPillar = new String[DISK_NUMBER];
    private String[] cPillar = new String[DISK_NUMBER];

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

        System.out.println("--- Game launched ---");

        npc.talk("Hi young man, I'm really annoyed by this problem, can you help me?\n" +
                "I have three pillars in front of me and I have to pass the three discs from pillar A to pillar C using pillar B.\n" +
                "You have to respect these 2 rules in order not to lose:\n" +
                "-You can only move one disc at a time.\n" +
                "-You can only move a disk to an empty slot or a smaller disk.");

        initialize();
        printPillars();

        npc.talk("To start type \"A C\" to move disc from A to C");

        while (!scanner.nextLine().equalsIgnoreCase("A C")) {
            System.out.println("Type \"A C\"");
        }

        System.out.println("--- Game finished ---");
    }

    private boolean moveDisk(String cmd) {
        String[] cmdTab = cmd.toLowerCase().split(" ");
        return true;
    }

    private void initialize() {
        for (int i = 0; i < DISK_NUMBER; i++) {
            this.aPillar[i] = this.diskNum[i];
            this.bPillar[i] = "|";
            this.cPillar[i] = "|";
        }
    }

    private void printPillars() {
        for (int i = (DISK_NUMBER - 1); i >= 0; i--) {
            System.out.println(this.aPillar[i] + "\t"  + this.bPillar[i] + "\t" + this.cPillar[i] + "\t");
        }
        System.out.println("_\t_\t_\t");
        System.out.println("A\tB\tC\t");
    }

    private void swap(String[] src, String[] dest, int srcPos, int destPos) {
        String srcString = src[srcPos];
        src[srcPos] = dest[destPos];
        dest[destPos] = srcString;
    }
}