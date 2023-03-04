package commands;
import interfaces.Command;
import tools.CommandList;

public class RemoveByIDCommand implements Command {
    CommandList collection;
    int id;

    public RemoveByIDCommand(CommandList collection, int id) {
        this.collection = collection;
        this.id = id;
    }

    @Override
    public void execute() {
        collection.remove_by_id(id);
    }
}
