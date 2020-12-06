package code.place.game;

import code.Gameplay;
import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.place.Game;
import java.util.Random;
import java.util.Scanner;

public class Questions extends Game {

    private final static int NB_ROUND = 5; //Must be <= nb of questions
    private final static int DEFAULT_REWARD = 5;

    // Here, correct answers are always put in index 1
    private final String[][] QUESTIONS_EASY = {
            {"Which famous dictator ruled the USSR from the mid-1920s to 1953 ?","Stalin","Lenin","Trotsky","Gorbachev"},
            {"In which country can we find Catalonia, Andalusia and Castile ?","Spain","Italy","France","Portugal"},
            {"Who said: The die is cast (Alea jacta est)?","Ceasar","Attila","Auguste","Vercingetorix"},
            {"Which country won the soccer world cup in 2014?","Germany","Argentina","Italy","Brazil"},
            {"Who was the god of war in Greek mythology?","Ares","Ares","Hades","Hermes"},
            {"In which Italian city is the action of Shakespeare's play Romeo and Juliet located?","Verona","Venice","Rome","Milan"},
            {"Which animal is a drosophila, used in genetic experiments?","A fly","A guinea pig","A goat","A rat"},
            {"In mathematics, how do we call the half-line that divides an angle into two equal angles?","bisector","median","mediator","fore height"}
    };
    private final String[][] QUESTIONS_DIFFICULT = {
            {"Where was Mozart born ?","Salzburg","Vienna","Turin","Venice"},
            {"What year is usually remembered as the year of the fall of the Western Roman Empire ?","476 AD","496 AD","387 AD","415 AD"},
            {"Which state in the United States has Montgomery as its capital ?","Alabama","New Mexico","California","Ohio"},
            {"Which animal is a drosophila, used in genetic experiments ?","A fly","A guinea pig","A goat","A rat"},
            {"Which architect designed and built the Hall of Mirrors at the Palace of Versailles ?","Jules Hardouin-Mansart","Louis Le Vau","André Le Nôtre","Bob the handyman"},
            {"What is the Chemical formula of methane ?","CH4","N2","SO2","CH3Cl"},
            {"Who invented the parachute ?", "Da Vinci","Montgolfier Brothers","Ader","Wright Brothers"},
            {"What is the capital of Zimbabwe ?", "Harare","Bulawayo","Mutare","Ouagadougou"}
    };


    public Questions(String name, String description, NPC npc, Level level) {
        super(name, description, npc, level);
    }

    public Questions() {
        this("Questions",
                "| In this game, your culture will be useful to find out the correct answer to questions.\n"  +
                        "| Type \"play\" to start the game.",
                new NPC("Samuel Outienne"),
                Level.PLATINUM);
    }

    public int getLengthQUESTEASY(){
        return this.QUESTIONS_EASY.length;
    }

    public int getLengthQUESTDIFF(){
        return this.QUESTIONS_DIFFICULT.length;
    }

    @Override
    public void play(Player player) {
        NPC npc = this.getNpc();
        Scanner scanner;

        System.out.println("\n--- Game launched ---\n");

        npc.talk("Laddies and Gentlemen, welcome to my stand! " +
                "Here your culture would be roughly tested...\n" +
                "To start, you have to choose the level of questions:\n" +
                "easy or difficult ?"
        );

        // To chose the level so to chose the string array we will work with
        String[][] QUESTIONS = getQUESTIONS(npc, player);

        npc.talk("Right. Get ready, get set, go!");

        // To initialize game
        int round = 1;
        boolean lose = false;
        boolean stop = false;

        int jackpot = 0;

        int[] quest_used = new int[NB_ROUND];

        while ((NB_ROUND + 1 > round) && (!stop) && (!lose)) {

            int id_quest;
            int answer = 0;
            int good_answer;

            // To chose a question that had not be already chosen
             do {
                id_quest = randNum(QUESTIONS.length);
            } while (!(isUsableQuestionId(id_quest,round-1,quest_used)));

            // Stocks id of used questions
            quest_used[round-1] = id_quest;

            // Asks if the player wants to continue
            if (round > 1) {
                stop = wantStop(jackpot, npc, player);
            }

            if (!stop) {
                if (round > 1) {
                    npc.talk("Let's move to the next question...");
                }

                System.out.println("\nROUND " + round + " :");

                // Displays question and answers
                good_answer = displayQuestionBoard(id_quest,QUESTIONS);

                while ((answer!=1) && (answer!=2) && (answer!=3) && (answer!=4)) {
                    System.out.println("\t(TAPE: \"1\", \"2\", \"3\" or \"4\")");
                    scanner = Gameplay.scanner;
                    System.out.print(player);
                    answer = scanner.nextInt();
                }

                if (answer != good_answer){
                    npc.talk("It was not the correct answer. Sorry, you lose the game and your jackpot.\n" +
                            "Next time will be the good one!");
                    lose = true;
                } else {
                    npc.talk("Well played! It was the correct answer.");
                }

                jackpot += DEFAULT_REWARD;
                jackpot *= round;
                round++;
            }
        }

        endGame(lose,round,npc);

        if (lose) {
            this.lose(player);
        } else {
            this.win(player, jackpot);
        }

        Gameplay.scanner.nextLine();

        System.out.println("\n--- Game finished ---\n");
    }

    public int randNum(int length){
        Random rd = new Random();rd.nextInt(length);
        return rd.nextInt(length);
    }

    private boolean wantStop(int jackpot, NPC npc, Player player) {
        Scanner scanner = Gameplay.scanner;
        scanner.nextLine();
        boolean stop = false;
        String response = "";

        System.out.println("Jackpot: " + jackpot + " coins.");
        npc.talk("Do you want to stop the game and cash your jackpot ?");

        while ((response.compareTo("YES")!=0) && (response.compareTo("NO")!=0)) {
           System.out.println("\t(TAPE: \"yes\" or \"no\")");
            System.out.print(player);
           response = scanner.nextLine();
           response = response.toUpperCase();
        }

        if (response.compareTo("YES")==0) {
           stop = true;
        }

       return stop;
    }

    private boolean isUsableQuestionId(int id_quest, int index, int[] quest_used) {
        boolean found = true;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                if (quest_used[i] == id_quest) {
                    found = false;
                    break;
                }
            }
        }
        return found;
    }

    private String[][] getQUESTIONS(NPC npc, Player player){
        Scanner scanner;

        String lvl_chosen = "";
        String[][] QUESTIONS;

        while ((lvl_chosen.compareTo("EASY")!=0) && (lvl_chosen.compareTo("DIFFICULT")!=0)) {
            System.out.println("\t(TAPE: \"easy\" or \"difficult\")");
            scanner = Gameplay.scanner;
            System.out.print(player);
            lvl_chosen = scanner.nextLine();
            lvl_chosen = lvl_chosen.toUpperCase();
        }

        if (lvl_chosen.compareTo("EASY")==0) {
            npc.talk("You choose \"easy\". Well, easily but surely!");
            QUESTIONS = new String[getLengthQUESTEASY()][];
            cloneEASY(QUESTIONS,getLengthQUESTEASY());
        } else {
            npc.talk("You choose \"difficult\". Such a warrior!");
            QUESTIONS = new String[getLengthQUESTDIFF()][5];
            cloneDIFFICULT(QUESTIONS,getLengthQUESTDIFF());
        }

        return QUESTIONS;
    }

    private int displayQuestionBoard(int id_quest, String[][] QUESTIONS) {
        String question = QUESTIONS[id_quest][0];
        System.out.println("\"" + question + "\"");

        int rd = randNum(100);
        int num_answer = 1;
        int num_corr = -1;
        for (int i = rd; i < rd + 6; i++) {
            int index = i % 5;
            if (index != 0) {
                switch (num_answer) {
                    case 1:
                    case 3:
                        System.out.print(num_answer +
                                " - " +
                                QUESTIONS[id_quest][index]);
                        if (index == 1) {
                            num_corr = num_answer;
                        }
                        break;
                    case 2:
                    case 4:
                        System.out.println("\t\t\t" +
                                num_answer +
                                " - " +
                                QUESTIONS[id_quest][index]);
                        if (index == 1) {
                            num_corr = num_answer;
                        }
                        break;
                    default:
                }
                num_answer++;
            }
        }
        return num_corr;
    }

    private void endGame(boolean lose, int round, NPC npc) {
        if (round==NB_ROUND+1) {
            npc.talk("A faultless! You win the ultimate reward. A real winner, congratulations!");
        } else if (!lose){
            npc.talk("You've made a good beginning but it is a wise decision!");
        }
        npc.talk("I hope I will see soon ! :)");
    }

    private void cloneEASY(String[][] target, int length) {
        for (int i = 0; i < length; i++) {
            target[i] = QUESTIONS_EASY[i].clone();
        }
    }


    private void cloneDIFFICULT(String[][] target, int length) {
        for (int i = 0; i < length; i++) {
            target[i] = QUESTIONS_DIFFICULT[i].clone();
        }
    }

}