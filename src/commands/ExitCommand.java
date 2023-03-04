package commands;

import interfaces.Command;
import tools.CommandList;

public class ExitCommand implements Command {
    CommandList collection;

    public ExitCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.exit();
    }
}
