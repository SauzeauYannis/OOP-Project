package code.Command;

import code.character.Player;

public class Use extends Command {

    public Use() {
        super("use",
                "use [object] : To use the object selected");
    }

    @Override
    public void executeCommand(Player player, String[] args) {

    }
}
