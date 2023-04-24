package commands;

import tools.CommandList;

public class RemoveByIDCommand extends Command {
    /**
     * CLass that allows to create command "remove_by_id" and execute it.
     */
    public RemoveByIDCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.remove_by_id(arg);
    }
}
