package commands;

import interfaces.Command;
import tools.CommandList;

public class MinByFullNameCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public MinByFullNameCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute() {
        collection.min_by_full_name();
    }

    @Override
    public String toString() {
        return "MinByFullNameCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
