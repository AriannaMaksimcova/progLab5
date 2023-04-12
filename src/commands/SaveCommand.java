package commands;

import interfaces.Command;
import tools.CommandList;

public class SaveCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;

    /**
     * CLass that allows to create command "save" and execute it.
     */
    public SaveCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.save();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
