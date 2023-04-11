package commands;
import interfaces.Command;
import tools.CommandList;

public class RemoveByIDCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public RemoveByIDCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        collection.remove_by_id(arg);
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
