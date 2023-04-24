package commands;

import organizations.Organization;
import tools.CommandList;

public class AddCommand extends Command {
    /**
     * Class that allows to create command "add" and execute it.
     */
    public AddCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(Organization arg) {
        this.commandList.add(arg);
    }
}
