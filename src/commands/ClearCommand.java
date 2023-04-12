package commands;

import interfaces.Command;
import tools.CommandList;

public class ClearCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * Class that allows to create command "clear" and execute it.
     */
    public ClearCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.clear();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
