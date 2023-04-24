package commands;

import tools.CommandList;

public class InfoCommand extends Command {
    /**
     * Class that allows to create command "info" and execute it.
     */
    public InfoCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.info();
    }
}
