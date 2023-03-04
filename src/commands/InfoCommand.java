package commands;

import interfaces.Command;
import tools.CommandList;

public class InfoCommand implements Command {
    CommandList collection;

    public InfoCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.info();
    }
}
