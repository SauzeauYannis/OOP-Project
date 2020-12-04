package code.command;

import code.character.Player;

public class Play extends Command {

    public Play() {
        super("play",
                "play : To play the game if your in good place");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        player.playGame();
    }
}
