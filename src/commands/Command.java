package commands;

import organizations.Address;
import organizations.Organization;
import tools.CommandList;
/**
 * Command abstract class.
 */

public abstract class Command {
    protected final String name;
    protected final String description;
    protected final CommandList commandList;
    protected final boolean needObject;


    protected Command(String name, String description, CommandList commandList, boolean needObject) {
        this.name = name;
        this.description = description;
        this.needObject = needObject;
        this.commandList = commandList;
    }
    public void execute(String arg){}

    public void execute(Organization arg){}

    public void execute(Address postalAddress){}

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public boolean isNeedObject() {
        return needObject;
    }
}
