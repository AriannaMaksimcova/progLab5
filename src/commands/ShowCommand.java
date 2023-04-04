package commands;

import interfaces.Command;
import tools.CommandList;

public class ShowCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public ShowCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.show();
    }

    @Override
    public String toString() {
        return "ShowCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
