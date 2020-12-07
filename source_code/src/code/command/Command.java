package code.command;

import code.character.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    /******************************
     * Attributes and constructor *
     ******************************/

    /// Attributes ///
    private final String command;
    private final String help;

    /// Constructor ///
    public Command(String command, String help) {
        this.command = command;
        this.help = help;
    }

    /***********
     * Methods *
     ***********/

    public String getCommand() {
        return command;
    }

    public abstract void executeCommand(Player player, String[] args);

    public void printHelp() {
        System.out.println(this.help);
    }

    public static List<Command> generateAllCommands() {
        List<Command> commandList = new ArrayList<>();

        commandList.add(new Go());
        commandList.add(new Help());
        commandList.add(new Look());
        commandList.add(new Take());
        commandList.add(new Quit());
        commandList.add(new Use());
        commandList.add(new Play());
        commandList.add(new Inventory());
        commandList.add(new Unlock());

        return commandList;
    }
}
