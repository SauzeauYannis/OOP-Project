package code.command;

import code.character.Player;

public class Go extends Command {

    public Go() {
        super("go",
                "go [location] : To go in the location specified by the command");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args.length > 1) {
            if (!player.goToPlace(args[1].toLowerCase())) {
                System.out.println("Please enter valid place !");
            }
        } else {
            player.getPlace().printExitPlaces();
        }
    }
}
