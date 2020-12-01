package code.Command;

import code.character.Player;

public class Quit extends Command {

    public Quit() {
        super("quit",
                "quit : To quit the game");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        System.exit(0);
    }
}
