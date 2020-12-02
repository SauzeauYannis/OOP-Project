package code.Command;

import code.character.Player;
import code.item.Item;
import code.place.Place;
import code.place.Shop;

public class Take extends Command {

    public Take() {
        super("take",
                "take [item] : To Add the object in your inventory");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args.length > 1) {
            Place place = player.getPlace();
            if (place instanceof Shop) {
                String item = args[1].toLowerCase();
                Shop shop = (Shop) place;
                for (Item shopItem: shop.getItems()) {
                    if (shopItem.getName().split(" ")[0].toLowerCase().equals(item)) {
                        player.addItems(shopItem);
                        return;
                    }
                }
            } else {
                System.out.println("You need to go in a shop to take items.");
            }
        } else {
            System.out.println("You need to have a 2nd argument.\n" +
                    "Type \"help take\" for more information.");
        }
    }
}
