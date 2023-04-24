package commands;

import organizations.Address;
import tools.CommandList;

public class FilterGreaterThanPostalAddressCommand extends Command {
    /**
     * Class that allows to create command "filter_grater_than_postal_address" and execute it.
     */
    public FilterGreaterThanPostalAddressCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }
    @Override
    public void execute(Address postalAddress){
        commandList.filter_greater_than_postal_address(postalAddress);
    }

}
