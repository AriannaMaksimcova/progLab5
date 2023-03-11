package commands;

import interfaces.Command;
import tools.CommandList;

public class UpdateCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public UpdateCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    public void execute() {
        collection.update();
    }

    @Override
    public String toString() {
        return "UpdateIDCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

