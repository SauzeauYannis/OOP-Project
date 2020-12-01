package code.Command;

import code.character.Player;

public class Take extends Command {

    public Take() {
        super("take",
                "take [object] : To Add the object in your inventory");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        // TODO: 01-Dec-20
    }
}
