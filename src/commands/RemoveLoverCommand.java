package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveLoverCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * CLass that allows to create command "remove_lover" and execute it.
     */
    public RemoveLoverCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg){
        commandList.remove_lower();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
