package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveLoverCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public RemoveLoverCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg){
        collection.remove_lower();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
