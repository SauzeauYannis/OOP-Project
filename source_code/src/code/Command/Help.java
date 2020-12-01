package code.Command;

import code.Gameplay;
import code.character.Player;
import java.util.List;

public class Help extends Command{

    public Help() {
        super("help",
                "help [command] : To have the list of the available command or to have an help on a specified command");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        List<Command> commandList = Gameplay.commandList;
        if (args.length > 1) {
            for (Command command: commandList) {
                if (command.getCommand().equals(args[1].toLowerCase())) {
                    command.printHelp();
                    break;
                }
            }
        } else {
            System.out.println("Command list :");
            for (Command command: commandList) {
                System.out.println("- " + command.getCommand());
            }
            System.out.println("Type help [command] to more information");
        }
    }
}
