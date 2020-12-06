package code.command;

import code.character.Player;
import code.exit.Exit;
import code.item.Item;
import code.item.Key;
import code.place.Ending;
import code.place.Game;
import code.place.Place;

import java.util.List;

public class Unlock extends Command{

    public Unlock() {
        super("unlock",
                "unlock [game] : to unlock the game sectioned");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args.length > 1) {
            List<Exit> exitList = player.getPlace().getExitList();
            Exit lastExit = exitList.get(exitList.size()-1);
            Place nextPlace = lastExit.getPlace();
            if (nextPlace instanceof Game) {
                for (Exit exit: exitList) {
                    if (exit.getPlace().getName().split(" ")[0].equalsIgnoreCase(args[1])) {
                        if (exit.isLock()) {
                            Game game = (Game) exit.getPlace();
                            for (Item item: player.getItems()) {
                                if (item instanceof Key) {
                                    Key key = (Key) item;
                                    if (key.getLevel() == game.getLevel()) {
                                        exit.unlock();
                                        player.removeItem(item);
                                        return;
                                    }
                                }
                            }
                            System.out.println("You haven't a " +
                                    game.getLevel().toString() +
                                    " key.\nGo to the shop to buy one.");
                        } else {
                            System.out.println("This game is always unlock!");
                        }
                        return;
                    }
                }
                System.out.println("Unknown game.\n" +
                        "Type \"go\" to have the list of game you can unlock.");
            } else if (nextPlace instanceof Ending) {
                if (lastExit.isLock()) {
                    if (player.getGamesFinished() == Game.NB_GAMES) {
                        lastExit.unlock();
                        System.out.println("Congratulations, you've unlocked all the locations.");
                    } else {
                        System.out.println("This place is unlockable only when you have won all the games.");
                    }
                } else {
                    System.out.println("This place is always unlock!");
                }
            } else {
                System.out.println("You need to be in front of the game to unlock it.");
            }
        } else {
            System.out.println("You need to have a 2nd argument.\n" +
                    "Type \"help unlock\" for more information.");
        }
    }
}
