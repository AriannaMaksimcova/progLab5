package commands;

import interfaces.Command;
import tools.CommandList;

public class ClearCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;
    /**
     * Class that allows to create command "clear" and execute it.
     */
    public ClearCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.clear();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
