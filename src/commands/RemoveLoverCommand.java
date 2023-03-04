package commands;

import interfaces.Command;
import organizations.Organization;
import tools.CommandList;

public class RemoveLoverCommand implements Command {
    CommandList collection;
    Organization organization;

    public RemoveLoverCommand(CommandList collection, Organization organization) {
        this.collection = collection;
        this.organization = organization;
    }
    @Override
    public void execute(){
        collection.remove_lower(organization);
    }

}
