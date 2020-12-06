package code.command;

import code.character.Player;

public class Inventory extends Command{
    public Inventory() {
        super("inventory",
                "inventory : Print your inventory");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        player.printInventory();
        player.printMoney();
        player.printHealth();
        player.printGames();
    }
}
