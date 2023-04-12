package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveAllByPostalAddressCommand implements Command{
    private final CommandList commandList;
    private final String name;
    private final String description;
    /**
     * Class that allows to create command "remove_all_by_postal_address" and execute it.
     */
    public RemoveAllByPostalAddressCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg){
        commandList.remove_all_by_postal_address();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
