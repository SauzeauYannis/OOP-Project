package code.Command;

import code.character.Player;

public class Look extends Command {

    public Look() {
        super("look",
                "look [object] : To Read the description of the object or the place description if you have not specified an object");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        player.getPlace().readDescription();
    }
}
