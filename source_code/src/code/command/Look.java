package code.command;

import code.character.Player;
import code.item.Item;
import code.place.Place;
import code.place.Shop;

// This class is a subclass of Command
public class Look extends Command {

    /***************
     * Constructor *
     ***************/

    public Look() {
        super("look",
                "| look <item> : To Read the description of the object or the place description if you have not specified an object");
    }

    /**********
     * Method *
     **********/

    @Override
    public void executeCommand(Player player, String[] args) {
        Place playerPlace = player.getPlace();
        if (args.length == 1) {
            playerPlace.readDescription();
        } else {
            String item = args[1].toLowerCase();
            if (playerPlace instanceof Shop) {
                Shop shop = (Shop) playerPlace;
                for (Item shopItem: shop.getItemList()) {
                    if (shopItem.getName().split(" ")[0].toLowerCase().equals(item)) {
                        shopItem.readDescription();
                        return;
                    }
                }
                System.out.println("| This item is not in the shop");
            } else {
                for (Item playerItem: player.getItems()) {
                    if (playerItem.getName().split(" ")[0].toLowerCase().equals(item)) {
                        playerItem.readDescription();
                        return;
                    }
                }
                System.out.println("| This item is not in your inventory");
            }
        }
    }
}
