package commands;

import interfaces.Command;
import tools.CommandList;

public class FilterGreaterThanPostalAddressCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;
    /**
     * Class that allows to create command "filter_grater_than_postal_address" and execute it.
     */
    public FilterGreaterThanPostalAddressCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg){
        collection.filter_greater_than_postal_address();
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
