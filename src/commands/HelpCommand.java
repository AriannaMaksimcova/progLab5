package commands;

import interfaces.Command;
import tools.*;

public class HelpCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * Class that allows to create command "help" and execute it.
     */
    public HelpCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.help();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
