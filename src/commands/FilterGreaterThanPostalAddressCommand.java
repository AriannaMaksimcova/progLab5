package commands;

import interfaces.Command;
import organizations.Address;
import tools.CommandList;

public class FilterGreaterThanPostalAddressCommand implements Command {
    CommandList collection;
    Address postalAddress;

    public FilterGreaterThanPostalAddressCommand(CommandList collection, Address postalAddress) {
        this.collection = collection;
        this.postalAddress = postalAddress;
    }
    @Override
    public void execute(){
        collection.filter_greater_than_postal_address(postalAddress);
    }
}
