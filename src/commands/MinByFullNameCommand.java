package commands;

import tools.CommandList;

public class MinByFullNameCommand extends Command {
    /**
     * Class that allows to create command "min_by_full_name" and execute it.
     */
    public MinByFullNameCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.min_by_full_name();
    }
}
