package commands;

import interfaces.Command;
import tools.CommandList;

public class RemoveAllByPostalAddressCommand implements Command{
    private CommandList collection;
    private String name;
    private String description;

    public RemoveAllByPostalAddressCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(String arg){
        collection.remove_all_by_postal_address();
    }

    @Override
    public String toString() {
        return "RemoveAllByPostalAddressCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
