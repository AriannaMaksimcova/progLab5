package commands;

import organizations.Address;
import tools.CommandList;

public class RemoveAllByPostalAddressCommand extends Command{
    /**
     * Class that allows to create command "remove_all_by_postal_address" and execute it.
     */
    public RemoveAllByPostalAddressCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }
    @Override
    public void execute(Address postalAddress){
        commandList.remove_all_by_postal_address(postalAddress);
    }
}
