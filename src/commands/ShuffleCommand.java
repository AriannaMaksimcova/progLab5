package commands;

import interfaces.Command;
import tools.CommandList;

public class ShuffleCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public ShuffleCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.shuffle();
    }

    @Override
    public String toString() {
        return "ShuffleCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
