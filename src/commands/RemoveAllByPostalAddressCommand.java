package commands;

import organizations.Address;
import tools.CommandList;
import interfaces.Command;

public class RemoveAllByPostalAddressCommand implements Command{
    CommandList collection;
    Address postalAddress;

    public RemoveAllByPostalAddressCommand(CommandList collection, Address postalAddress) {
        this.collection = collection;
        this.postalAddress = postalAddress;
    }
    @Override
    public void execute(){
        collection.remove_all_by_postal_address(postalAddress);
    }
}
