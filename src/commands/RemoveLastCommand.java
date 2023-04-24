package commands;

import tools.CommandList;

public class RemoveLastCommand extends Command {
    /**
     * CLass that allows to create command "remove_last" and execute it.
     */
    public RemoveLastCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.remove_last();
    }
}
