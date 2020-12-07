package code.command;

import code.character.Player;
import code.item.Item;

// This class is a subclass of Command
public class Use extends Command {

    public Use() {
        super("use",
                "| use <object> : To use the object selected");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args.length > 1) {
            String item = args[1].toLowerCase();
            for (Item playerItem: player.getItems()) {
                if (playerItem.getName().split(" ")[0].toLowerCase().equals(item)) {
                    playerItem.use(player);
                    return;
                }
            }
            System.out.println("| You have not " + item + " in your inventory");
        } else {
            System.out.println("| ou need to have a 2nd argument.\n" +
                    "| Type \"help use\" for more information.");
        }
    }
}
