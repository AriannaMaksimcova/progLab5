package commands;

import organizations.Organization;
import tools.CommandList;

public class RemoveLoverCommand extends Command {
    /**
     * CLass that allows to create command "remove_lover" and execute it.
     */
    public RemoveLoverCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }
    @Override
    public void execute(Organization organization){
        commandList.remove_lower(organization);
    }
}
