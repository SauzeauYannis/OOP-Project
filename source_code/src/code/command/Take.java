package code.command;

import code.character.Player;
import code.item.Item;
import code.place.Place;
import code.place.Shop;

// This class is a subclass of Command
public class Take extends Command {

    /***************
     * Constructor *
     ***************/

    public Take() {
        super("take",
                "| take <item> : To Add the object in your inventory");
    }

    /**********
     * Method *
     **********/

    @Override
    public void executeCommand(Player player, String[] args) {
        // Check if a 2nd argument is past
        if (args.length > 1) {
            Place place = player.getPlace();
            if (place instanceof Shop) {
                String item = args[1].toLowerCase();
                Shop shop = (Shop) place;
                for (Item shopItem: shop.getItemList()) {
                    if (shopItem.getName().split(" ")[0].toLowerCase().equals(item)) {
                        player.addItem(shopItem);
                        return;
                    }
                }
            } else {
                System.out.println("| You need to go in a shop to take items.");
            }
        } else { // If there is only one argument
            System.out.println("| You need to have a 2nd argument.\n" +
                    "| Type \"help take\" for more information.");
        }
    }
}
