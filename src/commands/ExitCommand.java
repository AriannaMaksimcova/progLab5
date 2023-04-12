package commands;

import interfaces.Command;
import tools.CommandList;

public class ExitCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * Class that allows to create command "exit" and execute it.
     */
    public ExitCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.exit();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
