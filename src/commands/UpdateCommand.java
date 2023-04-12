package commands;

import interfaces.Command;
import tools.CommandList;

public class UpdateCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
    * CLass that allows to create command "update" and execute it.
    */
    public UpdateCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg) {
        commandList.update(arg);
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}

