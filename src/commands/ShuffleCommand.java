package commands;

import interfaces.Command;
import tools.CommandList;

public class ShuffleCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;

    /**
     * CLass that allows to create command "shuffle" and execute it.
     */
    public ShuffleCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.shuffle();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
