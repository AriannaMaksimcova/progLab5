package commands;

import interfaces.Command;
import tools.CommandList;

public class ShowCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;

    /**
     * CLass that allows to create command "show" and execute it.
     */
    public ShowCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.show();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
