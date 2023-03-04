package commands;

import interfaces.Command;
import tools.CommandList;

public class ShowCommand implements Command {
    CommandList collection;

    public ShowCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.show();
    }
}
