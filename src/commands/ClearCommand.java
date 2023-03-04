package commands;

import interfaces.Command;
import tools.CommandList;

public class ClearCommand implements Command {
    CommandList collection;

    public ClearCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.clear();
    }
}
