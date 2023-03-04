package commands;

import interfaces.Command;
import tools.CommandList;

public class ShuffleCommand implements Command {
    CommandList collection;

    public ShuffleCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.shuffle();
    }
}
