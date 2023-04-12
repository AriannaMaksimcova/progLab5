package commands;
import interfaces.Command;
import tools.CommandList;

public class RemoveByIDCommand implements Command {
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * CLass that allows to create command "remove_by_id" and execute it.
     */
    public RemoveByIDCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        commandList.remove_by_id(arg);
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
