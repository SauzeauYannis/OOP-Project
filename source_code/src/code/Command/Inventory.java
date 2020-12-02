package code.Command;

import code.character.Player;

public class Inventory extends Command{
    public Inventory() {
        super("inventory",
                "inventory : Print your inventory");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        player.printInventory();
    }
}
