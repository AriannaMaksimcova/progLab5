package commands;

import interfaces.Command;
import organizations.Organization;
import tools.CommandList;

public class AddCommand implements Command {
    private CommandList commandList;
    private Organization organization;


    public AddCommand(CommandList commandList, Organization organization) {
        this.commandList = commandList;
        this.organization = organization;
    }

    @Override
    public void execute() {
        commandList.add(organization);
    }
}
