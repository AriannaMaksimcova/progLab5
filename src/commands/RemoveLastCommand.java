package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveLastCommand implements Command {
    CommandList collection;

    public RemoveLastCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.remove_last();
    }
}
