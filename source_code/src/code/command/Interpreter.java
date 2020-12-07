package code.command;

import code.character.Player;

// This class is an abstract class
public abstract class Interpreter {

    public static void interpretCommand(Player player, String command) {
        Command cmd = getCommand(command);
        cmd.executeCommand(player, command.split(" "));
    }

    // Static method to interpret a command
    private static Command getCommand(String command) {

        String mainCommand = getFirstWord(command);

        for (Command cmd: Command.commandList) {
            if (cmd.getCommand().equals(mainCommand)) {
                return cmd;
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

    // Static method to get the first word of a sentence in lower case
    public static String getFirstWord(String sentence) {
        return sentence.split(" ")[0].toLowerCase();
    }
}
