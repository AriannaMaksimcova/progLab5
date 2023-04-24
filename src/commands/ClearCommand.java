package commands;

import tools.CommandList;

public class ClearCommand extends Command {
    /**
     * Class that allows to create command "clear" and execute it.
     */
    public ClearCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.clear();
    }


}
