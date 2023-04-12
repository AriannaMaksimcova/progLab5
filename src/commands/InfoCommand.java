package commands;

import interfaces.Command;
import tools.CommandList;

public class InfoCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;
    /**
     * Class that allows to create command "info" and execute it.
     */
    public InfoCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.info();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
