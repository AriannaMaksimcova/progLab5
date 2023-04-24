package commands;

import tools.CommandList;

public class SaveCommand extends Command {
    /**
     * CLass that allows to create command "save" and execute it.
     */
    public SaveCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.save();
    }
}
