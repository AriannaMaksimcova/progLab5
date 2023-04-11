package commands;

import interfaces.Command;
import tools.CommandList;

public class ExitCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public ExitCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.exit();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
