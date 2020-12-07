package test.commandTest;

import code.character.Player;
import code.command.Command;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommandTest {

    Command command1;
    Command command2;
    Command command3;

    @Before
    public void setUp() {
        command1 = new Command("command 1",
                "command 1 description") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("execute command 1");
            }
        };
        command2 = new Command("command 2",
                "command 2 description") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("execute command 2");
            }
        };
        command3 = command1;
    }

    @Test
    public void getCommand() {
        assertEquals(command1.getCommand(), "command 1");
        assertEquals(command2.getCommand(), "command 2");
        assertSame(command3.getCommand(), command1.getCommand());
    }

    @Test
    public void generateAllCommands() {
        List<Command> commandList = Command.generateAllCommands();

        assertEquals(commandList.get(0).getCommand(), "go");
        assertEquals(commandList.get(1).getCommand(), "help");
        assertEquals(commandList.get(2).getCommand(), "look");
        assertEquals(commandList.get(3).getCommand(), "take");
        assertEquals(commandList.get(4).getCommand(), "quit");
        assertEquals(commandList.get(5).getCommand(), "use");
        assertEquals(commandList.get(6).getCommand(), "play");
        assertEquals(commandList.get(7).getCommand(), "inventory");
        assertEquals(commandList.get(8).getCommand(), "unlock");
    }
}