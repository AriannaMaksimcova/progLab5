package commands;

import interfaces.Command;
import organizations.Organization;
import tools.CommandList;

public class AddCommand implements Command {
    private CommandList commandList;
    private Organization organization;
    private String name;
    private String description;


    public AddCommand(String name, String description, CommandList commandList) {
        this.name = name;
        this.description = description;
        this.commandList = commandList;
    }

    @Override
    public void execute(String arg) {
        commandList.add();
    }

    @Override
    public String toString() {
        return "AddCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
