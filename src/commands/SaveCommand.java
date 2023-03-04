package commands;

import interfaces.Command;
import tools.CommandList;

public class SaveCommand implements Command {
    CommandList collection;

    public SaveCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.save();
    }
}
