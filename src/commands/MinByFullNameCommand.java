package commands;

import interfaces.Command;
import tools.CommandList;

public class MinByFullNameCommand implements Command {
    CommandList collection;

    public MinByFullNameCommand(CommandList collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.min_by_full_name();
    }
}
