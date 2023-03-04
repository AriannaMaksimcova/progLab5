package commands;

import interfaces.Command;
import organizations.Organization;
import tools.CommandList;

public class UpdateIDCommand implements Command {
    CommandList collection;
    Organization organization;

    public UpdateIDCommand(CommandList collection, Organization organization) {
        this.collection = collection;
        this.organization = organization;
    }

    public void execute() {
        collection.update(organization);
    }
}
