package commands;

import interfaces.Command;
import tools.CommandList;

public class MinByFullNameCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * Class that allows to create command "min_by_full_name" and execute it.
     */
    public MinByFullNameCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.min_by_full_name();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
