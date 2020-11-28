package code.enumeration;

public enum Command {
    GO,
    HELP,
    LOOK,
    TAKE,
    QUIT,
    USE,
    PLAY,
    UNKNOWN;

    public static void printCommands() {
        System.out.println("Command list :");
        for (Command command: Command.values()) {
            if (command != Command.UNKNOWN) {
                System.out.println("- " + command.toString().toLowerCase());
            }
        }
        System.out.println("Type help [command] to more information");
    }

    public static Command stringToCommand(String string) {
        Command command;
        switch (string) {
            case "go":
                command = Command.GO;
                break;
            case "help":
                command = Command.HELP;
                break;
            case "look":
                command = Command.LOOK;
                break;
            case "take":
                command = Command.TAKE;
                break;
            case "quit":
                command = Command.QUIT;
                break;
            case "use":
                command = Command.USE;
                break;
            case "play":
                command = Command.PLAY;
                break;
            default:
                command = Command.UNKNOWN;
        }
        return command;
    }

    public static void helpCommand(Command command) {
        switch (command) {
            case GO:
                System.out.println("go [location] : To go in the location specified by the command");
                break;
            case HELP:
                System.out.println("help [command] : To have the list of the available command or to have an help on a specified command");
                break;
            case LOOK:
                System.out.println("look [object] : To Read the description of the object or the place description if you have not specified an object");
                break;
            case TAKE:
                System.out.println("take [object] : To Add the object in your inventory");
                break;
            case QUIT:
                System.out.println("quit : To quit the game");
                break;
            case USE:
                System.out.println("use [object] : To use the object selected");
                break;
            case PLAY:
                System.out.println("play [object] : To play the game if your in good place");
                break;
            default:
                System.out.println(command + " : Not a command");
        }
    }
}
