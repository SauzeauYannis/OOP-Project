package code.Command;

import code.character.Player;

import java.util.List;

public class Interpreter {

    public static Command interpretCommand(List<Command> commandList, String[] commandTab) {

        String mainCommand = commandTab[0].toLowerCase();

        for (Command command: commandList) {
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
}