package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveLastCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public RemoveLastCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.remove_last();
    }

    @Override
    public String toString() {
        return "RemoveLastCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
