package code.command;

import code.character.Player;

// This class is a subclass of Command
public class Go extends Command {

    /***************
     * Constructor *
     ***************/

    public Go() {
        super("go",
                "| go <location> : To go in the location specified by the command");
    }

    /**********
     * Method *
     **********/

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
