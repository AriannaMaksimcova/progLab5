package commands;

import tools.CommandList;

public class ShowCommand extends Command {

    /**
     * CLass that allows to create command "show" and execute it.
     */
    public ShowCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.show();
    }
}
