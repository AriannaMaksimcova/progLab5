package commands;

import tools.CommandList;

public class UpdateCommand extends Command {
    /**
    * CLass that allows to create command "update" and execute it.
    */
    public UpdateCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }
    @Override
    public void execute(String arg) {
        commandList.update(arg);
    }
}

