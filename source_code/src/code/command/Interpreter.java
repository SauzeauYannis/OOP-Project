package code.command;

import code.character.Player;

import java.util.List;

// This class is an abstract class
public abstract class Interpreter {

    // Static method to interpret
    public static Command interpretCommand(String[] commandTab) {

        String mainCommand = commandTab[0].toLowerCase();

        for (Command command: Command.commandList) {
            if (command.getCommand().equals(mainCommand)) {
                return command;
            }
        }

        return new Command("unknown", "") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("Unknown command\n" +
                        "Type help for have the command list");
            }
        };
    }

    public static String getFirstWord(String sentence) {
        return sentence.split(" ")[0].toLowerCase();
    }
}
