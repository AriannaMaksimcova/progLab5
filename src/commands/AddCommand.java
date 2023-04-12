package commands;

import interfaces.Command;
import tools.CommandList;

public class AddCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;

    /**
     * Class that allows to create command "add" and execute it.
     */
    public AddCommand(String name, String description, CommandList commandList) {
        this.name = name;
        this.description = description;
        this.commandList = commandList;
    }

    @Override
    public void execute(String arg) {
        commandList.add();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
